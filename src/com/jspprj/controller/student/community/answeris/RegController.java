package com.jspprj.controller.student.community.answeris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.jspprj.dao_.AnswerisDao;
import com.jspprj.entity.Answeris;
import com.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/reg")		// 실제 디렉토리가 아니라 구분 짓기 위한 디렉토리 설정
public class RegController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/reg.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Answeris answeris = new Answeris();
		answeris.setTitle(request.getParameter("title"));
		answeris.setWriterId("Alive");
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		answerisDao.insert(answeris);
		
		response.sendRedirect("list");
	}
}

