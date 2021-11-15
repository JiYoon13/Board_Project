package com.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sname = request.getParameter("sname");
		String svalue = request.getParameter("svalue");
		DAO dao = new DAO();
		ArrayList<DTO> alist = dao.search(sname, svalue);
		request.setAttribute("alist", alist);
	}
}
