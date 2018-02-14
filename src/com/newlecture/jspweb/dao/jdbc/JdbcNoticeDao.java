package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.dao.NoticeDao;
import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao{
	
public List<NoticeView> getList(){
		
		String sql = "SELECT ROWNUM NUM,NOTICE.* FROM NOTICE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(sql); 
			
			int rownum;
			String id;
			String title;
			String content;
			String writerId;
			Date regDate;
			int hit;
			
			List<NoticeView> list = new ArrayList<>();
			 while(rs.next()){ 
					/*rownum = rs.getInt("NUM");
					id = rs.getString("ID");
					title = rs.getString("TITLE");
					content = rs.getString("CONTENT");
					writerId = rs.getString("WRITER_ID");
					regDate = rs.getDate("REG_DATE");
					hit = rs.getInt("HIT");*/
					
					/*NoticeView notice = new NoticeView(
							rs.getInt("NUM"),
							rs.getString("ID"),
							rs.getString("TITLE"),
							rs.getString("CONTENT"),
							rs.getString("WRITER_ID"),
							rs.getDate("REG_DATE"),
							rs.getInt("HIT"));*/
				 
				 NoticeView notice = new NoticeView();
					 notice.setRownum(rs.getInt("NUM"));
					 notice.setId(rs.getString("ID"));
					 notice.setTitle(rs.getString("TITLE"));
					 notice.setContent(rs.getString("CONTENT"));
					 notice.setWriterId(rs.getString("WRITER_ID"));
					 notice.setRegDate(rs.getDate("REG_DATE"));
					 notice.setHit(rs.getInt("HIT"));
				 
				 
				 /*NoticeView notice = new NoticeView(
					 notice.setRownum(rs.getInt("NUM")),
					 notice.setId(rs.getString("ID")),
					 notice.setTitle(rs.getString("TITLE")),
					 notice.setContent(rs.getString("CONTENT")),
					 notice.setWriterId(rs.getString("WRITER_ID")),
					 notice.setRegDate(rs.getDate("REG_DATE")),
					 notice.setHit(rs.getInt("HIT"))
				 );*/
					 
					list.add(notice);
			 }
			
			 
			rs.close();
			st.close();
			con.close();
			
			return list;
		}catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     }
	      
	      return null;
	
	/*------------------------------view 의 데이터 사용------------------------------*/		
	/*public List<Notice> getList(){
		
		return getList(1, "title", "");
	}
	
	public List<Notice> getList(String query){
		
		return getList(1, "title", query);
	}
	
	public List<Notice> getList(int page){
		
		return getList(page, "title", "");
	}
	
	public List<Notice> getList(int page, String field, String query){
		
		String sql = "SELECT ROWNUM NUM,NOTICE.* FROM NOTICE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(sql); 
			
			int rownum;
			String id;
			String title;
			String content;
			String writerId;
			Date regDate;
			int hit;
			
			List<Notice> list = new ArrayList<>();
			 while(rs.next()){ 
					rownum = rs.getInt("NUM");
					id = rs.getString("ID");
					title = rs.getString("TITLE");
					content = rs.getString("CONTENT");
					writerId = rs.getString("WRITER_ID");
					regDate = rs.getDate("REG_DATE");
					hit = rs.getInt("HIT");
					
					Notice notice = new Notice(
							rownum, id, title, content, writerId, regDate, hit);
					
					list.add(notice);
			 }
			 
			rs.close();
			st.close();
			con.close();
			
			return list;
		}catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     }
	      
	      return null;*/
	   }

	/*@Override
	public Notice get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getPrev(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getNext(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public NoticeView get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeView getPrev(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeView getNext(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
