package com.boardcafe.boardcafe_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardcafe.boardcafe_project.entity.Menu;
import com.boardcafe.boardcafe_project.mapper.MenuRestMapper;

@Service
public class MenuRestService {

	@Autowired
	private MenuRestMapper menuMapper;
	
	public List<Menu>getLists() {
		return menuMapper.getList();
	}
	
	public void boardInsert(Menu menu) {
		menuMapper.boardInsert(menu);
	}
	
	public void boardUpdate(Menu menu) {
		menuMapper.boardUpdate(menu);
	}
	
	public void boardDelete(int id) {
		menuMapper.boardDelete(id);
	}
	
	public Menu boardContent(int id) {
		return menuMapper.boardCotent(id);
	}
	
	public void boardCount(int id) {
		 menuMapper.bordCount(id);
	}
}
