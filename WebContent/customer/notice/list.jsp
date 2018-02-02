<%@page import="com.newlecture.jspweb.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.jspweb.dao.NoticeDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	NoticeDao noticeDao = new NoticeDao();
	List<Notice> list = noticeDao.getList();
%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE</title>
<link href="../../css/style.css" type = "text/css" rel = "stylesheet"/>

</head>
<body>
	<header id="header">
		<div class="root-container">
		<h1 id="logo"><img src="../../images/logo.png"  alt="뉴렉처 온라인"/></h1>

		<section>
			<h1 class = "hidden">헤더</h1>
			<nav class="hor-menu main-menu first-pad-none">
				<h1 class = "hidden">메인 메뉴</h1>
				<ul>
					<li><a href="" >학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<section>
				<h1 class = "hidden">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend class = "hidden">검색필드</legend>
						<label>과정검색</label> <input type="text" /> 
						<input class = "btn btn-img btn-search" type="submit"	value="검색" />
					</fieldset>
				</form>
			</section>

			<nav class="hor-menu member-menu first-pad-none">
				<h1 class = "hidden">회원 메뉴</h1>
				<ul>
					<li>HOME</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</nav>

			<nav class="hor-menu">
				<h1 class = "hidden">간편 메뉴</h1>
				<ul>
					<li><img src="../../images/txt-mypage.png"  alt="마이페이지"/></li>
					<li><img src="../../images/txt-customer.png"  alt="고객센터"/></li>
				</ul>
			</nav>
		</section>
		</div>
	</header>
	<!--visual 시작 -->
	<div id="visual">
		<div class="root-container">
		</div>
	</div>
	
	<div id="body">
		<div class="root-container clear-fix">
	<!-----------------------------------------aside 시작 ----------------------------------------->

	<aside id="aside">
		<h1>고객센터</h1>
		<nav>
			<h1>고객센터 메뉴</h1>
			<ul>
				<li>공지사항</li>
				<li>1:1고객문의</li>
				<li>학습안내</li>
			</ul>
		</nav>

		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li>앤서이즈</li>
				<li>W3C</li>
				<li>마이크로소프트</li>
			</ul>
		</nav>
	</aside>

	<!-----------------------------------------main 시작 ----------------------------------------->
	
	<main id="main">
		<section>
		<h1>공지사항<br></h1>

			<section>
				<h1>경로</h1>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</section>
		
			<section>
				<form>
					<label>검색어</label> <input type="text" />
					<input class = "btn btn-text btn-default" type="submit" value="검색" />
				</form>
			</section>
		
			<section>
				<h1>공지사항 검색 목록</h1>
				<table class = "table">
					<thead>
						<tr>
							<td class = "width-sm">번호</td>
							<td class = "width-ex">제목</td>
							<td class = "width-md">작성자</td>
							<td class = "width-md">작성일</td>
							<td class = "width-sm">조회수</td>
						</tr>
					</thead>	
					
					<tbody>
					<%for(Notice n : list){%>		
						<tr>
							<td><%=n.getRownum()%></td>
							<td class = "align-left text-indent text-ellipsis"><a href =""><span class="color-notice"><%=n.getTitle()%>가나다라마바사아자차카타파하abcdefghijklmnopqrstuvwxyz좀 넘어가라 ㅡㅡ 길이 엄청 넓네</span></a></td>
							<td><%=n.getWriterId()%></td>
							<td><%=n.getRegDate()%></td>
							<td><%=n.getHit()%></td>
						</tr>
					<%}%>
					</tbody>
				</table>
				<div>
					1/1 pages 
				</div>
				<div>
					<a href="" class="button btn-text default-button">글쓰기 버튼</a>
					<a href="" class="button btn-text btn-cancel">테스트</a>
				</div>
				<div>
					이전1다음
				</div>
			</section>
			<!---------------------------------------------------------------------------------------------------------------------->
			<section>
				<h1>공지사항 검색 목록</h1>
				<div class = "table">
					<div>
						<div>
							<div class = "width-sm">번호</div>
							<div class = "width-ex">제목</div>
							<div class = "width-md">작성자</div>
							<div class = "width-md">작성일</div>
							<div class = "width-sm">조회수</div>
						</div>
					</div>	
					
					<div>
					<%for(Notice n : list){%>		
						<div>
							<div><%=n.getRownum()%></div>
							<div class = "align-left text-indent text-ellipsis"><a href =""><span class="color-notice"><%=n.getTitle()%>가나다라마바사아자차카타파하abcdefghijklmnopqrstuvwxyz좀 넘어가라 ㅡㅡ 길이 엄청 넓네</span></a></div>
							<div><%=n.getWriterId()%></div>
							<div><%=n.getRegDate()%></div>
							<div><%=n.getHit()%></div>
						</div>
					<%}%>
					</div>
				</div>
				<div>
					1/1 pages 
				</div>
				<div>
					<a href="" class="button btn-text default-button">글쓰기 버튼</a>
					<a href="" class="button btn-text btn-cancel">테스트</a>
				</div>
				<div>
					이전1다음
				</div>
			</section>
		</section>
	</main>
		</div>
	</div>
	
	<!-----------------------------------------footer 시작 ----------------------------------------->
	
	<footer id="footer">
		<div id="visual">
		</div>
		<div class="root-container">
	<!-- 회사정보 주소서울특별시 마포구 토정로35길 11, 5층 266호(용강동, 인우빌딩)관리자메일admin@newlecture.com사업자 등록번호132-18-46763 통신 판매업 신고제 2013-서울강동-0969 호 상호뉴렉처대표박용우전화번호070-4206-4084 [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를 이용해주시기 바랍니다] Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
		</div>
	</footer>
</body>
</html>