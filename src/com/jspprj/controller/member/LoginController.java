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

@WebServlet("/member/login")

public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ApplicationContext applicationContext = ServletUtil
		            .getApplicationContext(request.getSession().getServletContext());
		      TilesContainer container = TilesAccess.getContainer(applicationContext);
		      ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		      container.render("member.login", servletRequest);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao memberDao = new JdbcMemberDao();
		Member member = memberDao.get(id);
		
		if(member == null) {
			out.println("<script> alert('아이디 또는 비밀번호가 올바르지 않습니다.'); location.href='login';</script>");
			//response.sendRedirect("login?error=1"); 		//페이지에 띄움
		}
		else if(!member.getPwd().equals(pwd)){
			out.println("<script> alert('아이디 또는 비밀번호가 올바르지 않습니다.'); location.href='login';</script>");
		}
		else {
			//인증이 성공한 경우
			request.getSession().setAttribute("id", id);
			
			String returnUrl = request.getParameter("returnUrl");
			if(returnUrl != null)
				response.sendRedirect(returnUrl);
			else
				response.sendRedirect("../index");
		}
	}
}
