<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${basePath}doUserPregister">
用户名：<input type="text" name="registerName">${repeatUsername}
密码:<input type="password" name="registerPassword">${fail}
再次输入密码:<input type="password" name="registerRpassword">
<input type="submit" value="点击注册">
</form>
</body>
</html>