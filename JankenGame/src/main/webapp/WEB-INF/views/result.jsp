<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" type="text/css" href="/JankenGame/style/style.css">
<title>Win or Lose</title>
</head>
<body>
	<h1>結果発表ーー！！</h1>
	
	<div class="result">
      <strong>${result}</strong>
      <p class = yh>
        あなたの手：<br>
        <img src="./images/${playerhand}.jpeg">
      </p>
      <p class = oh>
        相手の手：<br>
        <img src="./images/${cphand}.jpeg">
      </p>
    </div>
    <br>
    <br>
    <p><a href="JankenController">もう一回勝負！！！</a></p>
      
</body>
</html>