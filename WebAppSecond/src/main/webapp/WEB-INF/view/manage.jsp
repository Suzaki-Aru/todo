<%@ page language="java"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todoリスト</title>
</head>
<body>
    <h1>UserID:<%= session.getAttribute("userid") %>さんのTodoリスト</h1>
    
    <form action="ManageServlet" method="get">
    <select name="sort" value="" id="sort">
			<option value="1">優先度が高い順で表示</option>
			<option value="2">優先度が低い順で表示</option>
			<option value="3">作成日時が古い順で表示</option>
			<option value="4">作成日時が新しい順で表示</option>
    </select>
    <input type = "submit" value = "送信" />
    </form>
    
    <span><strong>ID</strong></span>
    <span><strong>タイトル</strong></span><br>
    <% 
      ArrayList<HashMap<String, String>> rows = 
      (ArrayList<HashMap<String, String>>)session.getAttribute
        ("rows"); 
    %>
    <%
      for (HashMap<String, String> columns : rows) {
    %>
   
    <form action="ShowwServlet" name = "form" method = "post">
    	<span name = "id" ><%= columns.get("id") %></span>
    	<span><%= columns.get("title") %></span>
    	<input type ="hidden" value =<%= columns.get("id") %>  name="id">
    	<input type ="hidden" value = "${sorted}" id ="sortValue" name="sortValue">	
    	<button type ="submit" class="detailBtn">詳細</button>
    </form>
   
    <% } %>
    <p><a href="NewServlet">新規作成</a></p><br><br>
    <form method="POST" action="LogoutServlet">
      <input type="submit" value="Logout">
    </form>
<script src ="manage.js"></script>   
</body>
</html>
