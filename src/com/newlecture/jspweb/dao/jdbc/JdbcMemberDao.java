package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Member;

public class JdbcMemberDao {
public List<Member> getList() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM MEMBER";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	
		Statement st = con.createStatement();
	
		ResultSet rs = st.executeQuery(sql); 
		
		
		String id;
		String pwd;
		String name;
		String gender;
		int age;
		String birthday;
		String major;
		String address;
		String phone;
		String ssn;
		String ip;
		String boss;
		Date regdate;
		
		List<Member> list = new ArrayList<>();
		 while(rs.next()){ 
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				name = rs.getString("name");
				gender = rs.getString("gender");
				age = rs.getInt("age");
				birthday = rs.getString("birthday");
				major = rs.getString("major");
				address = rs.getString("address");
				phone = rs.getString("phone");
				ssn = rs.getString("ssn");
				ip = rs.getString("ip");
				boss = rs.getString("boss");
				regdate = rs.getDate("regdate");
				
				Member member = new Member(
						id, pwd, name, gender, age, birthday,
						major, address, phone, ssn, ip, boss, regdate
						);
				list.add(member);
		 }
		 
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
