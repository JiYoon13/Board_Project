package com.board;

import java.util.Date;

public class DTO {
	int num;
	String author, title, content;
	String writeday;
	int readcnt, reproot, repstep, repindent;
	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTO(int num, String author, String title, String content, String writeday, int readcnt, int reproot,
			int repstep, int repindent) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.reproot = reproot;
		this.repstep = repstep;
		this.repindent = repindent;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getReproot() {
		return reproot;
	}
	public void setReproot(int reproot) {
		this.reproot = reproot;
	}
	public int getRepstep() {
		return repstep;
	}
	public void setRepstep(int repstep) {
		this.repstep = repstep;
	}
	public int getRepindent() {
		return repindent;
	}
	public void setRepindent(int repindent) {
		this.repindent = repindent;
	}
	
	
}
