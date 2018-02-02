package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Comment;

public class CommentDao {
		public List<Comment> getList() throws ClassNotFoundException, SQLException {
				
				String sql = "SELECT * FROM COMMENT";
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
				
				Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			
				Statement st = con.createStatement();
			
				ResultSet rs = st.executeQuery(sql); 
				
				String id;
				String content;
				Date regdate;
				String noticeId;
				
				List<Comment> list = new ArrayList<>();
				 while(rs.next()){ 
						id = rs.getString("id");
						content = rs.getString("content");
						regdate = rs.getDate("regdate");
						noticeId = rs.getString("notice_id");
						
						Comment comment = new Comment(
								id, content, regdate, noticeId
								);
						list.add(comment);
				 }
				 
				rs.close();
				st.close();
				con.close();
				
				return list;
			}
		}