<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>publishreview.html</title>
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
   <div class=“div1‘”>
 	简短影评
  </div>
  <form action="AddReviewServlet">
  	<input type="hidden" name="movieid" value="<%=request.getParameter("movieid")%>">
  	<input type="hidden" name="reviewuser" value="<%=request.getParameter("reviewuser")%>">
  	<input type="hidden" name="moviename" value="<%=request.getParameter("moviename")%>">
 	电影名：<input type="text" name="reviewmoviename" value="<%=request.getParameter("moviename")%>" disabled="disabled"><br>
  	评分：<input type="text" name="reviewscore"><br>
     评论：<textarea name="reviewcontent" rows="10" cols="60"></textarea>
    <input type="submit" value="提交" align="left">
</form>
  </body>
</html>
