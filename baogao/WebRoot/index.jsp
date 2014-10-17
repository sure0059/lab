<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body> <center>
    图书查询系统<br></br><br/>
    <s:iterator value="#list">
       <s:property value="blog_id"/>
       <s:property value="title"/>
       <s:property value="content"/>
       <s:a href="blog!delete.action?blog_id=%{blog_id}">delete</s:a></br><br/>
       <s:a href="blog!update.action?blog_id=%{blog_id}">update</s:a></br><br/>
    </s:iterator>
    <s:a href="blog!add.action">add</s:a></br></br>
    <s:a href="blog!add.action">search</s:a></br></br>
  <center>
  </body>
</html>
