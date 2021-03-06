import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Calc extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int result = 0;
		
		String result_ = request.getParameter("result");
		if(result_ != null && !result_.equals(""))
			result = Integer.parseInt(result_);
		
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>서블릿 더하기 예제</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("	<div>");
			out.write("		<form action = \"add\" method=\"post\">");
			out.write("			<div>");
			out.write("				<label>더하실 숫자 2개를 입력해주세요.</label>");
			out.write("			</div>");
							
			out.write("			<div>");
			out.write("				X : <input type = \"text\" name = \"x\" value=\'\'/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.write("				Y : <input type = \"text\" name = \"y\" value=\'\'/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.write("				<input type = \"submit\" id = \"btn-submit\" name = \"btn\" value = \"덧셈\"/>");
			out.write("				<input type = \"submit\" id = \"btn-Application\" name = \"btn\" value = \"Application\"/>");
			out.write("				<input type = \"submit\" id = \"btn-Session\" name = \"btn\" value = \"Session\"/>");
			out.write("				<input type = \"submit\" id = \"btn-Cookie\" name = \"btn\" value = \"Cookie\"/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.printf("				두 수의 합 : %d", result);
			out.write("				<input type = \"hidden\" name = \"result\" value = \"" + result + "\"/>");
			out.write("			</div>");
			out.write("		</form>");
			out.write("	</div>");
			
			out.write("	<div>");
			out.write("		<a href = \"mypage\"> 마이페이지 </a>");
			out.write("	</div>");
			
			out.write("</body>");
			out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		
		int result = 0;
		
		int x = 0;
		int y = 0;
		
		String btn = "덧셈";
		
		
		String temp1 = request.getParameter("x");
		if(temp1 != null && !temp1.equals(""))
			x = Integer.parseInt(temp1);
		
		String temp2 = request.getParameter("y");
		if(temp2 != null && !temp2.equals(""))
			y = Integer.parseInt(temp2);
	
		// 만약에 btn으로 전달된 값이 있다면
		// 그 값을 btn 변수에 대입
		String btn_ = request.getParameter("btn");
		if(btn_ != null && !btn_.equals(""))
			btn = btn_;

		switch(btn) {
		
			case "덧셈":
				System.out.println("테스트");
				result = x + y;
				break;
			
			case "Application":{
				ServletContext application = request.getServletContext();
				String result_ = request.getParameter("result");
				//int result_ = Integer.parseInt(request.getParameter("result"));
				application.setAttribute("result", result_);
				//application.setAttribute("result", result);
			}
				break;
			
			case "Session":{
				HttpSession session = request.getSession();
				//String result_ = request.getParameter("result");
				int result_ = Integer.parseInt(request.getParameter("result"));
				session.setAttribute("result", result_);
				//session.setAttribute("result", result);
			}
				break;
				
			case "Cookie":{ 
				String result_ = request.getParameter("result");
				Cookie cookie = new Cookie("result", result_);
				cookie.setMaxAge(60*60*24);			// 만료시간 정해주기
				response.addCookie(cookie);
			}
			break;
		}
		
		result = x + y;
		/*response.sendRedirect("add?x=&y=&result="+result);*/
		response.sendRedirect(String.format("add?x=%d&y=%d&result=%d",x,y,result));
	}
	
	
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int sum = 0;
		
		if(request.getMethod().equals("POST")) {
			int x = 0;
			int y = 0;
			
			String temp1 = request.getParameter("x");
			if(temp1 != null && !temp1.equals(""))
				x = Integer.parseInt(temp1);
			
			String temp2 = request.getParameter("y");
			if(temp2 != null && !temp2.equals(""))
				y = Integer.parseInt(temp2);
			
			sum = x + y;
			
			if((temp1 != null && !temp1.equals("")) && (temp2 != null && !temp2.equals(""))) {
				x = Integer.parseInt(temp1);
				y = Integer.parseInt(temp2);
			}
			
			//response.sendRedirect("AddExam.html");
		}
		
			값을 전달,요청하는 것은 GET (ex. 검색 등의 방식 , Select) 대상요청
			 값을 전달만하는 것은 POST(ex. 회원가입 / 수정 등의 방식) 행위요청
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>서블릿 더하기 예제</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("	<div>");
			out.write("		<form action = \"add\">");
			out.write("			<div>");
			out.write("				<label>더하실 숫자 2개를 입력해주세요.</label>");
			out.write("			</div>");
							
			out.write("			<div>");
			out.write("				X : <input type = \"text\" name = \"x\"/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.write("				Y : <input type = \"text\" name = \"y\"/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.write("				<input type = \"submit\" id = \"btn-submit\" value = \"덧셈\"/>");
			out.write("			</div>");
			
			out.write("			<div>");
			out.print("두 수의 합 : " + sum);
			out.write("			</div>");
			out.write("			</div>");
			out.write("		</form>");
			out.write("	</div>");
			out.write("</body>");
			out.write("</html>");
			
			// 공유 저장소
			//	입출력 도구 2가지 (1. Request / 2. Response)
			// 상대 저장 도구 3가지 ( 1. Application / 2. Session / 3. Cookie / 4. Query String(주소) ) 
			
	}*/
	
}