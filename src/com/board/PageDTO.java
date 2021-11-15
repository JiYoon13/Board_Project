package com.board;

import java.util.ArrayList;

public class PageDTO {
	int curpage = 1; // 현재 페이지
	int perpage = 5; // 1페이지안에 표시될 레코드 수
	int totalcnt; // 전체 레코드의 수
	ArrayList<DTO> alist; // 레코드 저장 목록

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPerpage() {
		return perpage;
	}

	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}

	public int getTotalcnt() {
		return totalcnt;
	}

	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}

	public ArrayList<DTO> getAlist() {
		return alist;
	}

	public void setAlist(ArrayList<DTO> alist) {
		this.alist = alist;
	}
}
