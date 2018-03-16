package com.jspprj.controller.student.home;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.jspprj.dao_.MemberRoleDao;
import com.newlecture.jspweb.entity.MemberRole;

@WebServlet("/student/index")
public class IndexController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if(request.getSession().getAttribute("id") == null)
			response.sendRedirect("../member/login?returnUrl=../student/index");
			
		String memberId = (String) request.getSession().getAttribute("id");
		
		PrintWriter out = response.getWriter();
		
		//MemberRoleDao memberRoleDao = new JdbcAnswerisDao();
		//if(!memberRoleDao.hasRole(memberId, "ROLE_STUDENT"));		// 함수를 미리 하나 만들어 사용
		//		out.println("<script>alert('허락되지 않는 접근입니다.'); history.back();</script>");
				
				
		// For-Each문 사용한 리스트화
		/*List<MemberRole>memberRoleDao.getRoleListByMeberId(memberId);
		
		for(MemberRole role : roles) {
			role.getRoleId().equals("ROLE_STUDENT");
			
		}*/
		
		 ApplicationContext applicationContext = ServletUtil
		            .getApplicationContext(request.getSession().getServletContext());
		      TilesContainer container = TilesAccess.getContainer(applicationContext);
		      ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		      container.render("student.home.index", servletRequest);
	}
}
