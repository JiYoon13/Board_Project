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
		PageDTO plist = dao.page(curpage); // 출력 결과에서 사용자가 클릭한 페이지 번호	
		request.setAttribute("alist", plist.getAlist());
		request.setAttribute("page", plist);
	}
}
