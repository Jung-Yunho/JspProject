package com.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.jspprj.dao_.AnswerisDao;
import com.jspprj.entity.Answeris;
import com.jspprj.entity.AnswerisView;

public class JdbcAnswerisDao implements AnswerisDao 
{

	@Override
	public int insert(Answeris answeris) 
	{
		 String sql = "INSERT INTO answeris (" + 
		 		"    id," + 
		 		"    title," + 
		 		"    language," +
		 		"    platform," + 
		 		"    runtime," + 
		 		"    error_code," + 
		 		"    error_message," + 
		 		"    situation," + 
		 		"    tried_to_fix," + 
		 		"    reason," + 
		 		"    how_to_fix," + 
		 		"    writer_id," + 
		 		"    attached_File" + 
		 		") VALUES ((SELECT NVL(MAX(TO_NUMBER(ID)),0)+1 ID FROM ANSWERIS)"
		 		+ ",?,?,?,?,?,?,?,?,?,?,?,?)";
		 
		 int result = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
				Connection con = DriverManager.getConnection(url, "c##sist","dclass");
				PreparedStatement st = con.prepareStatement(sql);
				
				//st.setString(1, answeris.getId());
				st.setString(1, answeris.getTitle());
				st.setString(2, answeris.getLanguage());
				st.setString(3, answeris.getPlatform());
				st.setString(4, answeris.getRuntime());
				st.setString(5, answeris.getErrorCode());
				st.setString(6, answeris.getErrorMessage());
				st.setString(7, answeris.getSituation());
				st.setString(8, answeris.getTriedToFix());
				st.setString(9, answeris.getReason());
				st.setString(10, answeris.getHowToFix());
				st.setString(11, answeris.getWriterId());
				st.setString(12, answeris.getAttachedFile());
				//insert에서는 resultset 필요없음
				/*ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) 
				{ 
					
					Answeris answeriss = new Answeris(
							rs.getString("ID"),
							rs.getString("LANGUAGE"),
							rs.getString("PLATFORM"),
							
							
							);
					
				}
			
				rs.close();*/
				
				result = st.executeUpdate();
				
				st.close();
				con.close(); 
				
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		
		return result;
	}

	@Override
	public int update(Answeris answeris) 
	{
		String sql = "UPDATE ANSWERIS SET title =?," + 
				"    language =?," + 
				"    platform =?," + 
				"    runtime =?," + 
				"    error_code =?," + 
				"    error_message =?," + 
				"    situation =?," + 
				"    tried_to_fix =?," + 
				"    reason =?," + 
				"    how_to_fix =?," + 
				"    hit = ? WHRER ID=?";
		 
		 int result = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
				Connection con = DriverManager.getConnection(url, "c##sist","dclass");
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, answeris.getTitle());
				st.setString(2, answeris.getLanguage());
				st.setString(3, answeris.getPlatform());
				st.setString(4, answeris.getRuntime());
				st.setString(5, answeris.getErrorCode());
				st.setString(6, answeris.getErrorMessage());
				st.setString(7, answeris.getSituation());
				st.setString(8, answeris.getTriedToFix());
				st.setString(9, answeris.getReason());
				st.setString(10, answeris.getHowToFix());
				st.setInt(11, answeris.getHit());
				st.setString(12, answeris.getId());
				
				result = st.executeUpdate();
				
				st.close();
				con.close(); 
				
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		
		return result;
	}

	@Override
	public int delete(String id) 
	{
		String sql = "DELETE ANSWERIS WHRER ID=?";
		 
		 int result = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
				Connection con = DriverManager.getConnection(url, "c##sist","dclass");
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, id);
				
				result = st.executeUpdate();
				
				st.close();
				con.close(); 
				
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		
		return result;
	}

	@Override
	public List<AnswerisView> getList(int page) 
	{
		/*String sql = "SELECT * FROM ANSWERIS_VIEW ORDER BY REG_DATE DESC";*/
		int start = 1+(page-1)*15;	//1,16,31,46
		int end = page*15;
		
		String sql = "SELECT * FROM ANSWERIS_VIEW WHERE NUM BETWEEN ? AND ?";
		
		
		//list에 answerisview 값을 저장하기 위한 준비
		List<AnswerisView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist","dclass");
			//쿼리문을 물음표로 설정할시 preparedstatement 사용
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, start); //자료형에 따라서 입력되는 형태가 달라짐
			st.setInt(2, end);
			
			ResultSet rs = st.executeQuery(); //prepared 사용시 resultset에서 sql 사용 x
			
			//자료형 일치시키기 
			AnswerisView answeris = null;
			
			while(rs.next())
			{
				answeris = new AnswerisView(
						rs.getString("ID"),
						rs.getString("TITLE"),
						rs.getString("LANGUAGE"),
						rs.getString("PLATFORM"),
						rs.getString("RUNTIME"),
						rs.getString("ERROR_CODE"),
						rs.getString("ERROR_MESSAGE"),
						rs.getString("SITUATION"),
						rs.getString("TRIED_TO_FIX"),
						rs.getString("REASON"),
						rs.getString("WRITER_ID"),
						rs.getString("HOW_TO_FIX"),
						rs.getDate("REG_DATE"),
						rs.getInt("HIT"),
						rs.getString("ATTACHED_FILE"),
						rs.getInt("COMMENT_COUNT")
						);
				
				//list에 가져온값 추가
				list.add(answeris);
			}
		
			
		
			rs.close();
			st.close();
			con.close(); 
			
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//list에 반환
		return list;
	}

	@Override
	public AnswerisView get(String id) 
	{
		 String sql = "SELECT * FROM ANSWERIS_VIEW WHERE ID=?";
		 AnswerisView answeris = null;
		 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
				Connection con = DriverManager.getConnection(url, "c##sist","dclass");
				//쿼리문을 물음표로 설정할시 preparedstatement 사용
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, id); //자료형에 따라서 입력되는 형태가 달라짐
				
				ResultSet rs = st.executeQuery(); //prepared 사용시 resultset에서 sql 사용 x
				
				
				
				if(rs.next())
				{
					answeris = new AnswerisView(
							rs.getString("ID"),
							rs.getString("TITLE"),
							rs.getString("LANGUAGE"),
							rs.getString("PLATFORM"),
							rs.getString("RUNTIME"),
							rs.getString("ERROR_CODE"),
							rs.getString("ERROR_MESSAGE"),
							rs.getString("SITUATION"),
							rs.getString("TRIED_TO_FIX"),
							rs.getString("REASON"),
							rs.getString("WRITER_ID"),
							rs.getString("HOW_TO_FIX"),
							rs.getDate("REG_DATE"),
							rs.getInt("HIT"),
							rs.getString("ATTACHED_FILE"),
							rs.getInt("COMMENT_COUNT")
							);
				}
			
				
			
				rs.close();
				st.close();
				con.close(); 
				
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		
		return answeris;
	}

	@Override
	public int getCount() {
		
			 String sql = "SELECT COUNT(ID) COUNT FROM ANSWERIS";

			 int count = 0;
			 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
					Connection con = DriverManager.getConnection(url, "c##sist","dclass");
					//쿼리문을 물음표로 설정할시 preparedstatement 사용
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery(sql); //prepared 사용시 resultset에서 sql 사용 x
					
					
					
					if(rs.next())
						count = rs.getInt("count");
				
					
				
					rs.close();
					st.close();
					con.close(); 
					
				} catch (ClassNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
			
			return count;
		}

	}


