package com.boardcafe.boardcafe_project.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // HttpMethod 임포트 추가
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/signin", "/logout", "/signup", "/noticeCheckPage", "/menu/all").permitAll()
                        .requestMatchers(HttpMethod.POST, "/signin","/signup").permitAll()
                        .requestMatchers("/resources/**", "/WEB-INF/**").permitAll()
                        .requestMatchers("/noticeAdd", "/noticeModifyPage").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/menu/Add").hasAnyAuthority("ADMIN", "MANAGER") 
                        .requestMatchers(HttpMethod.POST, "/menu/update").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/menu/delete").hasAnyAuthority("ADMIN", "MANAGER")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/signin")
                        .loginProcessingUrl("/signin")
                        .failureUrl("/signin?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(authenticationSuccessHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                HttpSession session = request.getSession();
                boolean isManager = authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN") ||
                                grantedAuthority.getAuthority().equals("MANAGER"));
                if (isManager) {
                    session.setAttribute("MANAGER", true);
                }
                session.setAttribute("username", authentication.getName());
                session.setAttribute("isAuthenticated", true);
                response.sendRedirect(request.getContextPath() + "/");
                // 수정: 중복 리다이렉션 방지를 위해 super 호출 제거
                // 이전: super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "https://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}