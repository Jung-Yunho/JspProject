package com.jspprj.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.jspprj.dao.jdbc.JdbcMemberDao;
import com.jspprj.dao_.MemberDao;
import com.jspprj.entity.Member;

@WebServlet("/member/logout")

public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.getSession().invalidate();				// Session 에 있는 데이터들 삭제
		
		response.sendRedirect("../index");
	}
}
