<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="/JankenGame/style/style.css">
<title>RSP</title>
</head>
<body>
	
	<h1>Let`s Play Rock Scissors Paper</h1>

	<form action="JankenController" method="post">
	  	<select name="playerhand">
         	<option value="rock">rock</option>
         	<option value="scissors">scissors</option>
         	<option value="paper">paper</option>
      	</select>
      <input type="submit" value="Play!">
	</form>

</body>
</html>