<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Hello World!</h2>
<a href="${basePath}user/2/detail">提交</a>

<a href="${basePath}user/1/wwwww/detail">huanyuan</a>
<a href="${basePath}registe">注册</a>
<a href="${basePath}toLogin">登录</a>
<a href="${basePath}toStore">商家</a>
</body>
</html>
