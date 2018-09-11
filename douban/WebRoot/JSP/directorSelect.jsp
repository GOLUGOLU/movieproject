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
    
    <title>My JSP 'directorSelect.jsp' starting page</title>
    
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
	  
	#div{
		float:left;
		margin:10px;
		
	}
	.div1{
	  margin: auto;
	    position: absolute;
	    top: 100px;
	    left: 0;
	    right: 0;
	    bottom: 0;
	 text-align: center;
	 width:1100px;}
	</style>

  <body>
  <center>
    <h3>演员列表</h3>
    <form action="SelectDirectorByNameServlet">
    <input type="text" name="selectdirectorname" placeholder="输入要查找的导演名"><input type="submit" value="搜索">
    </form>
    <div class="div1">
    <c:forEach var="director" items="${requestScope.directorlist}" varStatus="status">

    <div id="div" width="200" >
    <a href="#">
    <img src="${director.getDirectorPhoto()}" height="218" width="180"><br>
    <span>${director.getDirectorName()}</span><br>
    <a href="JSP/directorUpdate.jsp?directorid=${director.getDirectorId()}">修改</a>&nbsp;
    <a href="DeleteDirectorServlet?directorid=${director.getDirectorId()}" }">删除</a>
    </a>
    </div>
    </c:forEach>
    </div>
    </center>
  </body>
</html>
