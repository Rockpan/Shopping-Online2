<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Hello World!</h2>
	<a href="${path}/s_and_m/user/1/detail">提交</a>

	<a href="${basePath}user/1/123456/detail">huanyuan</a>
	<hr>

	<a href="${path}/s_and_m/潘希城/CarsDetail" >购物车</a>
</body>
</html>
