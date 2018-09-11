<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'movieAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  .div{
  margin: auto;
    position: absolute;
    top: 100px;
    left: 0;
    right: 0;
    bottom: 0;
 text-align: center;
 }
 </style>
 <script>

 </script>
  <body>
<!--  <div class="div">
  <span><%= request.getAttribute("updatemsg") %></span>
  </div>-->
  		<div class="div">
		<h3>电影信息添加</h3>
		<form action="AddMovieServlet" method="post">
		电影名称：<input type="text" name="moviename"><br>
		电影类型：<input type="text" name="movietype"><br>
		电影图片：<input type="text" name="movieimgurl"><br>
		电影评分：<input type="text" name="movieavgscore"><br>		
		电影语言：<input type="text" name="movielanguage"><br>
		电影地区：<input type="text" name="moviearea"><br>
		电影年份：<input type="text" name="movieyear"><br>
		电影时长：<input type="text" name="movietime"><br>
		电影播放地址：<input type="text" name="movieurl"><br>
		电影描述信息：<input type="text" name="moviedescription"><br><br>
		<input type="submit" value="保存">&nbsp;&nbsp;
		<input type="reset" value="重置"><br>
		</form>
  </div>
  </body>
