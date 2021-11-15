package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Page implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int curpage = 1;
		if(request.getParameter("curpage")!=null) {
			curpage = Integer.parseInt(request.getParameter("curpage"));
		}
		DAO dao = new DAO();
		PageDTO plist = dao.page(curpage); // ��� ������� ����ڰ� Ŭ���� ������ ��ȣ	
		request.setAttribute("alist", plist.getAlist());
		request.setAttribute("page", plist);
	}
}
