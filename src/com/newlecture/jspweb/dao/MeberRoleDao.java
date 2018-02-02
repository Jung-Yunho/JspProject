package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.MemberRole;

public class MeberRoleDao {
	public List<MemberRole> getList() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM MEMBER_ROLE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	
		Statement st = con.createStatement();
	
		ResultSet rs = st.executeQuery(sql); 
		
		String memberId;
		String roleId;
		
		List<MemberRole> list = new ArrayList<>();
		 while(rs.next()){ 
				memberId = rs.getString("member_id");
				roleId = rs.getString("role_id");
				
				MemberRole memberRole = new MemberRole(
						memberId,roleId
						);
				list.add(memberRole);
		 }
		 
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
