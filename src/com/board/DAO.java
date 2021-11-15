package com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet res;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public DAO() {
		super();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "ez311", "12345");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void input(HttpServletRequest request) { 
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content").replace("\r\n", "<br>");
		int repstep = 0;
		int repindent = 0;
		
		String sql = "INSERT INTO BOARD(NUM, AUTHOR, TITLE, CONTENT, REPROOT, REPSTEP, REPINDENT) VALUES (BOARD_SEQ.nextval, ?,?,?,BOARD_SEQ.currval,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, author);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setInt(4, repstep);
			psmt.setInt(5, repindent);
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// input-end
	
	public ArrayList<DTO> list() {
		ArrayList<DTO> alist = new ArrayList<DTO>();
		String sql="SELECT NUM, TITLE, AUTHOR, CONTENT, to_char(WRITEDAY, 'yy-mm-dd')WRITEDAY, READCNT, REPROOT, REPSTEP, REPINDENT FROM BOARD ORDER BY REPROOT DESC, REPSTEP ASC";
		try {
			psmt=con.prepareStatement(sql);
			res=psmt.executeQuery();
			
			while(res.next()) {
				int num = res.getInt("num");
				String author = res.getString("author");
				String title = res.getString("title");
				String content = res.getString("content");
				String writeday = res.getString("writeday");
				int readcnt = res.getInt("readcnt");
				int reproot = res.getInt("reproot");
				int repstep = res.getInt("repstep");
				int repindent = res.getInt("repindent");
				
				DTO dto = new DTO(num, author, title, content, writeday, readcnt, reproot, repstep, repindent);
				alist.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alist;
	}// list-end
	
	public void modify(int num, HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sql = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE NUM=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// modify-end
	
	public void delete(int num) {
		String sql="DELETE FROM BOARD WHERE NUM=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// delete-end
	
	public DTO retrieve(int r_num) {
		readcnt(r_num); // 조회수 1증가
		String sql="SELECT NUM, TITLE, AUTHOR, CONTENT, to_char(WRITEDAY, 'yy-mm-dd')WRITEDAY, READCNT FROM BOARD WHERE NUM=?";
		DTO dto = new DTO();
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, r_num);
			res=psmt.executeQuery();
			if(res.next()) {
				int num = res.getInt("num");
				String author = res.getString("author");
				String title = res.getString("title");
				String contents = res.getString("content");
				String content = contents.replace("\r\n", "<br");
				String writeday = res.getString("writeday");
				int readcnt = res.getInt("readcnt");
				
				dto.setNum(num);
				dto.setAuthor(author);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setWriteday(writeday);
				dto.setReadcnt(readcnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}// retrieve-end
	
	public void readcnt(int num) {
		String sql="UPDATE BOARD SET READCNT=READCNT+1 WHERE NUM=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// readcnt-end
	
	public ArrayList<DTO> search(String sname, String svalue){ 
		ArrayList<DTO> alist = new ArrayList<DTO>();
	    String sql="SELECT NUM, READCNT, to_char(WRITEDAY, 'yy-mm-dd')WRITEDAY, AUTHOR, TITLE, CONTENT FROM BOARD";
	    if(sname.equals("title")){
	       sql += " WHERE TITLE LIKE ?";
	    }
	    else{
	        sql += " WHERE AUTHOR LIKE ?";
	    }
	      
	    try {
	       psmt=con.prepareStatement(sql);
	       psmt.setString(1, "%" + svalue + "%");
	       res = psmt.executeQuery();         
	       while(res.next())
	       {
	           int num=res.getInt("num");
	           int readcnt=res.getInt("readcnt");
	           String author=res.getString("author");
	           String title=res.getString("title");	            
	           String content=res.getString("content");
	           String writeday=res.getString("writeday");
	           DTO dto = new DTO();
	           dto.setNum(num);
	           dto.setReadcnt(readcnt);
	           dto.setAuthor(author);
	           dto.setTitle(title);
	           dto.setContent(content);
	           dto.setWriteday(writeday);
	       	
	           alist.add(dto);        
	        }         
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return alist;      
	}// search-end
	
	public DTO replyui(int num) {
		DTO dto = new DTO();
		String sql="SELECT * FROM BOARD WHERE NUM=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, num);
			res=psmt.executeQuery();
			
			if(res.next()) {
				dto.setNum(res.getInt("num"));
				dto.setAuthor(res.getString("author"));
				dto.setTitle(res.getString("title"));
				dto.setContent(res.getString("content"));
				dto.setWriteday(res.getString("writeday"));
				dto.setReadcnt(res.getInt("readcnt"));
				dto.setReproot(res.getInt("reproot"));
				dto.setRepstep(res.getInt("repstep"));
				dto.setRepindent(res.getInt("repindent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	} // replyui-end
	
	public void reply(int r_num, int r_reproot, int r_repstep, int r_repindent, String r_title, String r_author, String r_content) {
		makereply(r_reproot, r_repstep);
		String sql="INSERT INTO BOARD(NUM, TITLE, AUTHOR, CONTENT, REPROOT, REPSTEP, REPINDENT) VALUES (BOARD_SEQ.nextval,?,?,?,?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, r_title);
			psmt.setString(2, r_author);
			psmt.setString(3, r_content);
			psmt.setInt(4, r_reproot);
			psmt.setInt(5, r_repstep+1);
			psmt.setInt(6, r_repindent+1);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// reply-end
	
	public void makereply(int r_reproot, int r_repstep) {// step 증가 
		String sql="UPDATE BOARD SET REPSTEP = REPSTEP + 1 WHERE REPROOT = ? AND REPSTEP > ?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, r_reproot);
			psmt.setInt(2, r_repstep);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}// makereply-end
	
	public PageDTO page(int curpage) {
		PageDTO pdto = new PageDTO();
		ArrayList<DTO> alist = new ArrayList<DTO>();
		int totalcnt = totalcnt();
		int perpage = pdto.getPerpage(); // 1페이지에 표시 가능한 레코드 수 
		int skip = (curpage-1) * perpage; // 2페이지를 보고싶다면 1페이지(5개) 스킵 > 레코드 위치 
	
		String sql="SELECT NUM, TITLE, AUTHOR, CONTENT, to_char(WRITEDAY, 'yy-mm-dd')WRITEDAY, READCNT, REPROOT, REPSTEP, REPINDENT FROM BOARD ORDER BY REPROOT DESC, REPSTEP ASC";
		try {
			psmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// next()는 한번 읽어온 데이터는 읽어올 수 없음, type_scroll_insentive는 이 기능을 끄는 것
			// read_only는 res 결과를 가지고 insert, update가 불가능 읽기만 가능
			res=psmt.executeQuery();
			if(skip > 0)
				res.absolute(skip); // 지정한 위치로 커서 이동
			for(int i=0; i<perpage && res.next(); i++) {
				int num = res.getInt("num");
				String author = res.getString("author");
				String title = res.getString("title");
				String content = res.getString("content");
				String writeday = res.getString("writeday");
				int readcnt = res.getInt("readcnt");
				int reproot = res.getInt("reproot");
				int repstep = res.getInt("repstep");
				int repindent = res.getInt("repindent");
				
				DTO dto = new DTO();
				dto.setNum(num);
				dto.setAuthor(author);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setWriteday(writeday);
				dto.setReadcnt(readcnt);
				dto.setReproot(reproot);
				dto.setRepstep(repstep);
				dto.setRepindent(repindent);
				alist.add(dto);
			}
			pdto.setAlist(alist);
			pdto.setTotalcnt(totalcnt);
			pdto.setCurpage(curpage); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pdto;
	}// page-end
	
	public int totalcnt() { // BOARD 테이블에서 모든 자료의 개수
		int count = 0;
		String sql="SELECT COUNT(*) FROM BOARD";
		try {
			psmt=con.prepareStatement(sql);
			res=psmt.executeQuery();
			if(res.next())
				count = res.getInt(1); // 1열 중에서 가장 큰 값 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}// totalcnt-end
	
}
