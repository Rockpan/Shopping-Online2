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
    <form method="post" action="${basePath}doRegiste">
    真实姓名：
    <input type="text" name="realName">
    <br>
    性别：
      <label><input name="sex" type="radio" value="男" />男 </label>
      <label><input name="sex" type="radio" value="女" />女</label> 
   <br>
   身份证号：
    <input type="text" name="IdCard">
    <br>
   手机号码： 
    <input type="text" name="phone">
    <br>
    家庭住址：
    <input type="text" name="address">
    <br>
    <input type="submit" value="下一步">
    </form>
</body>
</html>