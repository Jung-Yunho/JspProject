package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Notice;

public class NoticeDao {
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT ROWNUM NUM,NOTICE.* FROM NOTICE";
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
	}
}
