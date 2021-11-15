package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyUI implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();
		int num = Integer.parseInt(request.getParameter("num"));
		DTO rdata = dao.replyui(num);
		request.setAttribute("rdata", rdata);
	}
}
