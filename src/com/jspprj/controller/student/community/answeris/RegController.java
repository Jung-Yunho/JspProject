package com.jspprj.controller.student.community.answeris;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.jspprj.dao_.AnswerisDao;
import com.jspprj.entity.Answeris;
import com.jspprj.entity.AnswerisView;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/student/community/answeris/reg")// 실제 디렉토리가 아니라 구분 짓기 위한 디렉토리 설정
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*100,		//5메가
		maxRequestSize = 1024*1024*5*5		//5메가 5개까지
		)

public class RegController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/reg.jsp");
		
		dispatcher.forward(request, response);*/
		
		request.getContextPath();
		
		/*1.pageContext;
		2.ServletContext;*/
		
		ApplicationContext applicationContext = ServletUtil
	            .getApplicationContext(request.getSession().getServletContext());
	      TilesContainer container = TilesAccess.getContainer(applicationContext);
	      ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
	      container.render("student.community.answeris.reg", servletRequest);
	      
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Answeris answeris = new Answeris();
		
		// 파일시스템-------------------------------------------------------------
		String pathUrl = "/student/upload";
		
		String pathSystem = request
													.getServletContext()
													.getRealPath(pathUrl);
		
		//response.getWriter().println(pathSystem);
		
		File file = new File(pathSystem);
		if(!file.exists())
			file.mkdirs();
		
		// 1. cos lib 를 이용했을때
		/*MultipartRequest req = new MultipartRequest(request,
																									pathSystem,
																									1024*1024*100,
																									"UTF-8",
																									new DefaultFileRenamePolicy());	//100MB(1kb * 1kb * 100)
		
		answeris.setTitle(request.getParameter("title"));
		answeris.setSituation(request.getParameter("situation"));
		answeris.setAttachedFile( request.getFilesystemName("attached"));
		*/
		
		// 2. 버퍼, 스트림을 이용했을때
		Part part = request.getPart("attached");
		//request.getParts();
		
		InputStream is = part.getInputStream();
		String fname = part.getSubmittedFileName();
		
		byte[] buf = new byte[1024];
		
		FileOutputStream fos = new FileOutputStream(pathSystem+File.separator+fname);
		
		int size = 0;
		
		while((size = is.read(buf, 0, size)) != -1)
			fos.write(buf, 0, size);
		
		is.close();
		fos.close();
		
		//파일시스템-------------------------------------------------------------
		
		answeris.setTitle(request.getParameter("title"));
		answeris.setSituation(request.getParameter("situation"));
		//answeris.setAttachedFile(part.getSubmittedFileName());
		answeris.setAttachedFile(fname);
		answeris.setWriterId("newlec");
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		answerisDao.insert(answeris);
		
		response.sendRedirect("list");
		
		
		//String fileName = req.getFilesystemName("attached");
		//response.getWriter().println(fileName);
		
		/*Enumeration en = req.getFileNames();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String name = req.getFilesystemName(key);
			response.getWriter().println(name);
		}*/
	}
}

