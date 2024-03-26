<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Todo新規作成</title>
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
	<h1>Todo新規作成</h1>

	<form action="SaveServlet" method="get">
		<label for="userid">あなたのID</label><br> 
		<input type="text" name="userid" value=''><br><br>
		<label for="title">タイトル</label><br> 
		<input type="text" name="title" value=''><br><br>
		<label for="title">優先度</label><br> 
		<select name="priority" value="" id="priority">
			<option value="1">High</option>
			<option value="2">Middle</option>
			<option value="3">Low</option>
		</select> 
		<br><br>
		<label for="content">本文</label><br>
		<textarea name="content" id="" cols="30" rows="10"></textarea>
		<p></p>
		<button type="submit">保存する</button>
		<a href='ManageServlet'>キャンセル</a>
	</form>
	<ul>
		<li><p>
				<a href='ManageServlet'>戻る</a>
			</p></li>
	</ul>
</body>
</html>
