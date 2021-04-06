<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>This is Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="get">
    <span>姓名：</span><input type="text" name="username"><br>
    <span>密码：</span><input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
