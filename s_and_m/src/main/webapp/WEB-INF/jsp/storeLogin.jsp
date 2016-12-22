<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${basePath}doStoreLogin" method="post">
用户名:<input type="text" name="sellername">
密码:<input type="password" name="password">${sellerLoginEror}
<input type="submit" value="登录">
<input type="reset" value="重置">
</form>
</body>
</html>