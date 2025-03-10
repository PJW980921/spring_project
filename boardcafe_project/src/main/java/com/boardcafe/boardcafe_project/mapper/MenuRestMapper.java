package com.boardcafe.boardcafe_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boardcafe.boardcafe_project.entity.Menu;

public interface MenuRestMapper {
	
	@Insert("INSERT INTO backend_spring_project.menu(title,content,writer,indate) VALUES(#{title},#{content},#{writer},#{indate})")
	public void boardInsert(Menu menu);
	
	@Select("SELECT id,memberId,title,content,writer,indate,count FROM backend_spring_project.menu ORDER BY id DESC")
	public List<Menu>getList();
	
	@Select("SELECT id,memberId,title,content,writer,indate,count FROM backend_spring_project.menu WHERE id=#{id} ")
	public Menu boardCotent(int id);
	
	@Update("UPDATE backend_spring_project.menu set title=${title},content=${content}, writer=${writer} WHERE id=#{id}")
	public void boardUpdate(Menu menu);
	
	@Update("UPDATE backend_spring_project.menu set count=count+1 WHERE id=#{id}")
	public void bordCount(int id);
	
	@Delete("DELETE from backend_spring_project.menu WHERE id=#{id}")
	public void boardDelete(int id);
	

	
}
