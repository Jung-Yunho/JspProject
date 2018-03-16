
<%@page import="com.jspprj.entity.Answeris"%>
<%@page import="com.jspprj.entity.AnswerisView"%>
<%@page import="com.jspprj.dao.jdbc.JdbcAnswerisDao"%>
<%@page import="com.jspprj.dao_.AnswerisDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<main class="main" ng-controller="notice-controller">
         <h2 class="main title">내 오류노트</h2>
         
         <div class="breadcrumb">
            <h3 class="hidden">경로</h3>
            <ul>
               <li>home</li>
               <li>커뮤니티</li>
               <li>오류노트</li>
            </ul>
         </div>
         
         <div class="search-form margin-top first align-right">
            <h3 class="hidden">고객문의  검색폼</h3>
            <form class="table-form">
               <fieldset>
                  
                  <legend class="hidden">고개문의 검색 필드</legend>
                  <label class="hidden">검색분류</label>
                  <select name="f">
                     <option  value="title">제목</option>
                     <option  value="errorCode">에러코드</option>
                     <option  value="errorMessage">에러메시지</option>
                  </select>
                  <label class="">검색어</label>
                  <input type="text" name="q" value="" />
                  <input class="btn btn-search" type="submit" value="검색" />
               </fieldset>
            </form>
         </div>
                  
         <div class="notice margin-top">
            <h3 class="hidden">고객문의 목록</h3>
            <table class="table">
               <thead>
                  <tr>
                     <th class="expand">제목</th>
                     <th class="w100">언어</th>
                     <th class="w100">플랫폼</th>
                     <th class="w100">작성일</th>
                  </tr>
               </thead>
               <tbody>
               
            <template id="row">
                  <tr id="template">
                        <td class="text-align-left text-indent text-ellipsis"><a href="detail?id="></a></td>
                        <td>                        
                        </td>
                        <td class="text-ellipsis"></td>
                        <td>
                        
                        </td>
                  </tr>
                  </template>

			<c:forEach var="ai" items="${list}">
              <%--  <% for(AnswerisView a :list){%> --%>
               <tr>
                  <td class="text-align-left text-indent text-ellipsis">
                  		<a href="detail?id=${ai.id}"><%-- <%=a.getId()%> --%><%-- <%= a.getTitle() %> --%>${ai.title }</a></td>
                  <td><%-- <%= a.getLanguage() %> --%>${ai.language }
                  		   <%-- <%=((List<Answeris>)request.getAttribute("list")).get(0).getLanguage() %> --%></td>
                  <td class="text-ellipsis"><%-- <%= a.getPlatform() %> --%>${ai.platform}</td>
                  <td>
                     <%-- <%= a.getRegDate() %> --%>
                     ${ai.regDate }
                  </td>
               </tr>
               <%-- <% } %> --%>
			</c:forEach>
               
               
             <%--   <%if(list.size()==0) { %> --%>
               <tr>
                  <td colspan="4"> 작성된 글이 없습니다.</td>
               </tr>
              <%--  <% } %> --%>
               
               </tbody>
            </table>
         </div>
         
         <div class="indexer margin-top align-right">
            <h3 class="hidden">현재 페이지</h3>
            <div><span class="text-orange text-strong">${param.p == null ? 1 : param.p }</span> / ${lastPage } pages</div>
         </div>
         
         <div class="margin-top text-align-right">
            <span class="btn-text btn-default btn-clone1">복제1</span>
            <a href="reg" class="btn-text btn-default">글쓰기</a>
         </div>

         <div class="margin-top align-center pager">
      
   <div>
      
      <c:if test="${startNum != 1 }">
     <a class="btn btn-prev" href="?p=${startNum-1 }">이전</a>
      </c:if>
      
      <c:if test="${startNum == 1 }">
      <span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
      </c:if>
      
   </div>
   <ul class="-list- center">
      
         
            
               <!-- <li><a href="?p=1&t=&q=" >1</a></li>
               <li><a href="?p=2&t=&q=" >2</a></li>
               <li><a href="?p=3&t=&q=" >3</a></li>
               <li><a href="?p=4&t=&q=" >4</a></li>
               <li><a href="?p=5&t=&q=" >5</a></li> -->
               
               <c:forEach var="i" begin="0" end="4">
               		<c:if test="${startNum+i <= lastPage}">
               			<li><a href="?p=${startNum+i}&t=&q=" >${startNum+i }</a></li>
               		</c:if>
               </c:forEach>
      
      
   </ul>
   <div>
      
      	<c:if test="${startNum+5 <= lastPage }">
        <a class="btn btn-next"  href="?p=${startNum+5 }">다음</a>
         </c:if>
         
         <c:if test="${startNum+5 > lastPage }">
         <span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
         </c:if>
      
   </div>
   
         </div>
      </main>








      <script>
            window.addEventListener("load", function(){
                  var tbody = document.querySelector(".notice .table tbody");
                  var origin = tbody.querySelector("tr:first-child");
                  var cloneButton1 = document.querySelector(".btn-clone1");

                  // /answeris/list-data
                  cloneButton1.onclick = function(){
                        var answerises = [{id:"1", title:"aaa"}, {id:"2", "title": "bbb"}];

                        if ('content' in document.createElement('template')) {

                              var t = document.querySelector('#row'),
                              tds = t.content.querySelectorAll("td");
                              tds[0].textContent = answerises[0].id;
                              tds[1].textContent = answerises[0].title;
                              
                              var clone = document.importNode(t.content, true);
                              tbody.appendChild(clone);
                        }

				// alert("Test");
                        // var answerises = [{id:"1", title:"aaa"}, {id:"2", "title": "bbb"}];

                        // for(var i=0; i<answerises.length; i++){
                        //       var copy = origin.cloneNode(true);
                        //       var titleTd = copy.querySelector("td:nth-child(1)");
                        //       titleTd.textContent = answerises[i].title;
                              
                        //       tbody.appendChild(copy);
                        // }

                  };             

            });
      </script>