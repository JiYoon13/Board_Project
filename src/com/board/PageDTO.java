package com.board;

import java.util.ArrayList;

public class PageDTO {
	int curpage = 1; // ���� ������
	int perpage = 5; // 1�������ȿ� ǥ�õ� ���ڵ� ��
	int totalcnt; // ��ü ���ڵ��� ��
	ArrayList<DTO> alist; // ���ڵ� ���� ���

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
