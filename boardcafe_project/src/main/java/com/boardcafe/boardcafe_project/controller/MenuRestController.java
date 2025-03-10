package com.boardcafe.boardcafe_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardcafe.boardcafe_project.entity.Menu;
import com.boardcafe.boardcafe_project.service.MenuRestService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MenuRestController {

	@Autowired
	MenuRestService menuRestService;
	
	// 전체 게시판 조회 
	@GetMapping("/meu/all")
	public ResponseEntity<List<Menu>>getAllMenus(){
		List<Menu>menus = menuRestService.getLists();
		if(menus != null && !menus.isEmpty()) {
			return ResponseEntity.ok(menus);
		}else {
			return ResponseEntity.noContent().build(); // status code : 204 No Content return 
		}
	}
	
	//게시글 작성 
	@PostMapping("/menu/add")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu){
		
		if(menu.getIndeate() == null || menu.getIndeate().isEmpty()) {
			menu.setIndeate(LocalDate.now().toString());
		}
		
		 menu.setCount("0");
		 menuRestService.boardInsert(menu);
		 return ResponseEntity.ok("board added successfully");
	}
	// 특정 게시글 업데이트 
	@PutMapping("/menu/update/{id}")
	public void updateMenu(@RequestBody Menu menu, @PathVariable("id") int id) {
		menu.setId(id);
		menuRestService.boardUpdate(menu);
	}
	
	// 특정 게시글 삭제 
	@DeleteMapping("/menu/delete/{id}")
	public void deleteMenu(@PathVariable("id") int id) {
		menuRestService.boardDelete(id);
	}
	
	// 특정 게시글 조회 
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu>getMenuById(@PathVariable("id")int id){
		Menu menu = menuRestService.boardContent(id);
		if(menu != null) {
			return ResponseEntity.ok(menu);
		}else {
			return ResponseEntity.notFound().build();
			// notFound => status code : 404 error return 
		}
	}
	
	// 게시글 조회수 증가 
	@PutMapping("/menu/count/{id}")
	public void IncrementMenu(@PathVariable("id") int id) {
		menuRestService.boardCount(id);
	}
}
