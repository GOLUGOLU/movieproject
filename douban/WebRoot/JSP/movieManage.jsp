<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'movieManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  <h3>电影管理</h3>
    <a href="SelectMovieServlet">查看电影</a><br>
    <a href="JSP/movieAdd.jsp">添加电影</a><br>
    <a href="SelectActorServlet">查看演员</a><br>
    <a href="JSP/actorAdd.jsp">添加演员</a><br>
    <a href="SelectDirectorServlet">查看导演</a><br>
    <a href="JSP/directorAdd.jsp">添加导演</a><br>
    </center>
  </body>
</html>
