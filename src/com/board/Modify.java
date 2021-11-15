package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Modify implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();
		HttpSession hs = request.getSession();
		int num = (Integer)hs.getAttribute("num");
		dao.modify(num, request);
	}
}
