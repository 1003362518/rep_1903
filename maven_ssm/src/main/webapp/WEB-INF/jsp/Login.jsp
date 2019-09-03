<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>登录页面</h2>
	<h3 style="color:red">${msg }</h3>
	<form action="${pageContext.request.contextPath }/user/login" method="POST">
		用户账号 :<input name="username" /><br>
		用户密码:<input  name="password" type="password" /><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>