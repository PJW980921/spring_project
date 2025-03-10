package com.boardcafe.boardcafe_project.entity;

import java.io.Writer;

public class Menu {
private int id;
private String memberId;
private String title;
private String content;
private String writer;
private String indate;
private String count;

public Menu() {}

public Menu(int id, String memId, String title, String content, String writer, String indeate, String count) {
	this.id = id;
	this.memberId = memId;
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.indate = indeate;
	this.count = count;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMemId() {
	return memberId;
}

public void setMemId(String memId) {
	this.memberId = memId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getIndeate() {
	return indate;
}

public void setIndeate(String indeate) {
	this.indate = indeate;
}

public String getCount() {
	return count;
}

public void setCount(String count) {
	this.count = count;
}


}
