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
		
		int page = 1;
		int lastPage = 1;
		
		String page_ = request.getParameter("p");
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		
		   AnswerisDao answerisDao = new JdbcAnswerisDao();
		   
		   int count = answerisDao.getCount();
		   
		   if(count > 0) {
			   lastPage = count/15;
			   if(lastPage % 15 > 0)
				   lastPage++;
		   }
		   
		   int off = page%5-1;
		   int startNum = page - off;
		   
		   List<AnswerisView> list = answerisDao.getList(page);
		   
		   request.setAttribute("list", list);
		   request.setAttribute("count", count);
		   request.setAttribute("lastPage", lastPage);
		   request.setAttribute("startNum", startNum);
		   
		   RequestDispatcher dispatcher = 
				   request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/list.jsp");
		   
		   dispatcher.forward(request, response);
	}
}
