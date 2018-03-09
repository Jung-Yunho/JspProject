<%@page import="com.jspprj.dao_.AnswerisDao"%>
<%@page import="com.jspprj.dao.jdbc.JdbcAnswerisDao"%>
<%@page import="com.jspprj.entity.AnswerisView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<main>
		<h2 class="main title">내 오류노트 등록</h2>
		
		<div class="breadcrumb">
			<h3 class="hidden">breadlet</h3>
			<ul>
				<li>home</li>
				<li>커뮤니티</li>
				<li>Answeris</li>
			</ul>
		</div>
				
		<div class="margin-top first">
				<h3 class="hidden">오류 내용</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getTitle() %> --%>
								${answeris.title}
							</td>
						</tr>
						<tr>
							<th>오류가 발생할 때 사용한 언어</th>
							<td colspan="3" class="text-align-left text-indent">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getLanguage() %> --%>
								${answeris.language}			
							</td>							
						</tr>
						<tr>
							<th>오류가 발생할 때 사용한 플랫폼</th>
							<td colspan="3" class="text-align-left text-indent">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getPlatform() %> --%>	
								${answeris.platform}		
							</td>							
						</tr>
						<tr>
							<th>오류가 발생할 때 사용한 실행환경</th>
							<td colspan="3" class="text-align-left text-indent">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getRuntime()%> --%>
								${answeris.runtime}		
							</td>
						</tr>										
						<tr>
							<th>오류 코드</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getErrorCode() %> --%>
								${answeris.errorCode}
							</td>
						</tr>
						<tr>
							<th>오류 메시지</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getErrorMessage() %> --%>
								${answeris.errorMessage}
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getErrorMessage() %> --%>
								<a download href="../../upload/${answeris.attachedFile}">${answeris.attachedFile}</a>
							</td>
						</tr>	
												
						<tr>
							<th colspan="4">오류 상황 설명</th>
						</tr>
						<tr>
							<td colspan="4" class="text-align-left" style="padding:10px 0px 10px 10px;">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getSituation() %> --%>
								${answeris.situation}
							</td>
						</tr>
						<tr>
							<th colspan="4">시도해본 내용</th>
						</tr>
						<tr>
							<td colspan="4" class="text-align-left" style="padding:10px 0px 10px 10px;">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getTriedToFix()%> --%>
								${answeris.triedToFix}
							</td>
						</tr>
						<tr>
							<th colspan="4">원인</th>
						</tr>
						<tr>
							<td class="text-align-left" colspan="4" style="padding:10px 0px 10px 10px;">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getReason() %> --%>
								${answeris.reason}
							</td>
						</tr>
						
						<tr>
							<th colspan="4">해결방법</th>
						</tr>
						<tr>
							<td class="text-align-left" colspan="4" style="padding:10px 0px 10px 10px;">
								<%-- <%=((AnswerisView)request.getAttribute("answeris")).getHowToFix() %> --%>
								${answeris.howToFix}
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
			<div class="margin-top text-align-center">				
				<a class="btn-text btn-default" href="edit">수정</a>
				<a class="btn-text btn-cancel" href="list">취소</a>
			</div>
			
						
	</main>
	<!-- <script type="text/javascript" src="js/lib/web-editor/util.js"></script>
	<script type="text/javascript" src="js/lib/web-editor/multi-editor.js"></script> -->