package com.jspprj.controller.student.community.answeris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.jspprj.dao_.AnswerisDao;
import com.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/list-data")		// 실제 디렉토리가 아니라 구분 짓기 위한 디렉토리 설정
public class ListDataController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext applicationContext = ServletUtil
	            .getApplicationContext(request.getSession().getServletContext());
	      TilesContainer container = TilesAccess.getContainer(applicationContext);
	      ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
	      container.render("student.community.answeris.list-data", servletRequest);
	}
}
