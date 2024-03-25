<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Todo編集</title>
<style>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	float: left;
	margin-right: 20px;
}
</style>
</head>
<body>
	<h1>Todo編集</h1>

	<form action="UpdateServlet" method="post">
		<input type="hidden" name="id" value='<%= request.getAttribute("id") %>'> 
		<label for="title">タイトル</label><br>
		<input type="text" name="title" value='<%= request.getAttribute("title") %>'><br> <br> <label
			for="content">本文</label><br>
		<textarea name="content" id="" cols="30" rows="10"><%= request.getAttribute("content") %></textarea>
		<p></p>
		<label for="title">優先度</label><br>
		<select name="priority" value="" id="priority">
			<option value="1">High</option>
			<option value="2">Middle</option>
			<option value="3">Low</option>
		</select> <br><br>
		<button type="submit">保存する</button>
		<a href='ShowwServlet?id=<%= request.getAttribute("id") %>'>キャンセル</a>
	</form>
	<ul>
		<li><p>
				<a href='ManageServlet'>戻る</a>
			</p></li>
	</ul>
</body>
</html>
