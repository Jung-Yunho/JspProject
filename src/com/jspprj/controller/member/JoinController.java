package com.jspprj.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

@WebServlet("/member/join")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 100,	// 100메가
		maxRequestSize = 1024 * 1024 * 100 * 5 // 100메가 5개까지
		)
public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ApplicationContext applicationContext = ServletUtil
		            .getApplicationContext(request.getSession().getServletContext());
		      TilesContainer container = TilesAccess.getContainer(applicationContext);
		      ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		      container.render("member.join", servletRequest);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_ = request.getParameter("id");
		
		response.sendRedirect("../index");
	}
}
