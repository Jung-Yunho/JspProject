import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GoToHell")
public class Nana  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*OutputStream os = response.getOutputStream();*/
		/*PrintStream out = new PrintStream(os);*/		// 파일이나 숫자를 염두
		
		/*PrintWriter out = new PrintWriter(os, true);*/		//문자를 염두
		/*PrintWriter out = new PrintWriter(new OutPutStreamWriter(os, StandardCharsets.UTF_8), true);*/
		PrintWriter out = response.getWriter();
		
		int cnt = 0;
		
		String temp = request.getParameter("cnt");
		if(temp != null && !temp.equals(""))
			cnt = Integer.parseInt(temp);
		
		for(int i=0; i<cnt; i++) 
			out.println( (i+1) + " : " + "\t" + "안뇽 Servlet?<br/>");
	}	
}