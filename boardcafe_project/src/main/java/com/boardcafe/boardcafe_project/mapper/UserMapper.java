package com.boardcafe.boardcafe_project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boardcafe.boardcafe_project.entity.User;

@Mapper //자바언어와 mySql언어를 통역해주는(?) 어노테이션 
public interface UserMapper {

	@Insert("INSRT INTO backend_spring_project.user(username,password,writer,role)" + "VALUES(#{username},#{password},#{writer},#{role})")
	void InsertUser (User user);
	@Select("SELECT username,password,writer,role FROM backend_spring_project.user WHERE username=#{username}")
	User findByUsername(String username);
	@Select("SELECT write FROM backend_spring_project.user WHERE username=#{usernmae}")
	String findWriter(String usernmae);
	

	
	
}
