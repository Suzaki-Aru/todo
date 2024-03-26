<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>ユーザー作成</h1>
    <form method="POST" action="NewuserServlet">
        <label for="userid">UserID:</label><a>数字で入れてください</a>
        <input type="text" id="userid" name="userid"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="作成">
    </form>
</body>
</html>
