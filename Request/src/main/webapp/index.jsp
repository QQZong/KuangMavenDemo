<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
</head>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobbys" value="睡觉">睡觉
        <input type="checkbox" name="hobbys" value="玩游戏">玩游戏
        <input type="checkbox" name="hobbys" value="吃饭">吃饭
        <input type="checkbox" name="hobbys" value="电影">电影
        <input type="checkbox" name="hobbys" value="锻炼">锻炼
        <input type="submit">
    </form>
</div>
</body>
</html>
