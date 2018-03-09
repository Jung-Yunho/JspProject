
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
<c:set var="ctx" value="${pageContext.request.servletContext.contextPath }"></c:set>   

<%-- <%
   AnswerisDao answerisDao = new JdbcAnswerisDao();
   List<AnswerisView> list = answerisDao.getList();

%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
<title></title>

<link href="${ctx }/student/css/layout.css" type="text/css" rel="stylesheet" />
</head>
<body>
   <!-- header 부분 -->

	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>

   <!-- --------------------------- <visual> --------------------------------------- -->
   <!-- visual 부분 -->
   
   <tiles:insertAttribute name="visual"></tiles:insertAttribute>
   <!-- --------------------------- <body> --------------------------------------- -->
   <div id="body">
      <div class="content-container clearfix">

         <!-- --------------------------- aside --------------------------------------- -->
         <!-- aside 부분 -->
         <tiles:insertAttribute name="aside"></tiles:insertAttribute>
         <!-- --------------------------- main --------------------------------------- -->
         
         <!-- content 부분 -->
         <tiles:insertAttribute name="main"></tiles:insertAttribute>


      
      
         
      </div>
   </div>
   <!-- ------------------- <footer> --------------------------------------- -->
   <tiles:insertAttribute name="footer"></tiles:insertAttribute>



</body>
</html>