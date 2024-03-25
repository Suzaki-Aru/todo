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
  <title>Todo詳細</title>
  <style>ul {list-style: none; margin: 0; padding: 0;} li {float: left; margin-right: 20px; }</style>
</head>
<body>
    <h1>Todo詳細</h1>
    
    <%= session.getAttribute("row") %>
    
    <p><strong>タイトル：</strong><%= request.getAttribute("title") %></p>
    <p><strong>本文：</strong><%= request.getAttribute("content") %></p><br>
    <p><strong>優先度：</strong><%= request.getAttribute("priority_name") %></p><br>
    <p><strong>作成日時：</strong><%= request.getAttribute("created_time") %></p><br>
    <ul>
      <li><p><a href="ManageServlet">戻る</a></p></li>
      <li><p><a href='EdittServlet?id=<%= request.getAttribute("id") %>'>編集</a></p></li>
      <li><p><a href='DeleteServlet?id=<%= request.getAttribute("id") %>'>削除</a></p></li>
    </ul>      
</body>
</html>
