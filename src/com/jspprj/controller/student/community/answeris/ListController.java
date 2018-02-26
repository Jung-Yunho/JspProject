package com.jspprj.controller.student.community.answeris;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.jspprj.dao_.AnswerisDao;
import com.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   AnswerisDao answerisDao = new JdbcAnswerisDao();
		   List<AnswerisView> list = answerisDao.getList();
		   
		   request.setAttribute("list", list);
		   RequestDispatcher dispatcher = 
				   request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/list.jsp");
		   
		   dispatcher.forward(request, response);
	}
}
