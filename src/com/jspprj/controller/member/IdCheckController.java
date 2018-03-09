package com.jspprj.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jspprj.dao.jdbc.JdbcMemberDao;
import com.jspprj.entity.Member;

@WebServlet("/member/idcheck")
public class IdCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String memberId = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Member member = new JdbcMemberDao().get(memberId);
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		
		//실행되는 흐름을 제어하는 도구 Thread  + 동기형의 문제점을 보여줌.
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		out.println(json);
	    
	}
}
