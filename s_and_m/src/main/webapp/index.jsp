<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>Hello World!</h2>
<a href="${basePath}user/2/detail">提交</a>

<a href="${basePath}user/1/wwwww/detail">huanyuan</a>
</body>
</html>
