package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reply implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int r_num = Integer.parseInt(request.getParameter("num"));
		int r_reproot = Integer.parseInt(request.getParameter("reproot"));
		int r_repstep = Integer.parseInt(request.getParameter("repstep"));
		int r_repindent = Integer.parseInt(request.getParameter("repindent"));
		String r_title = request.getParameter("r_title");
		String r_content = request.getParameter("r_content");
		String r_author = request.getParameter("r_author");
		
		DAO dao = new DAO();
		dao.reply(r_num, r_reproot, r_repstep, r_repindent, r_title, r_author, r_content);
	}

}
