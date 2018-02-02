package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.Role;

public class RoleDao {
public List<Role> getList() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM ROLE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	
		Statement st = con.createStatement();
	
		ResultSet rs = st.executeQuery(sql); 
		
		String id;
		String introduction;
		
		List<Role> list = new ArrayList<>();
		 while(rs.next()){ 
				id = rs.getString("id");
				introduction = rs.getString("introduction");
				
				Role role = new Role(
						id,introduction
						);
				list.add(role);
		 }
		 
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
