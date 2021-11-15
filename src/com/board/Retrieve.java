package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Retrieve implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		DAO dao = new DAO();
		DTO data = dao.retrieve(num);
		request.setAttribute("data", data);
	}
}
