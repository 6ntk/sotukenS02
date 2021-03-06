<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/login.css"/>

<title>受験報告書</title>
</head>
<body>

<h1>受験報告書 閲覧・提出</h1>

<div id="wrapper">

<form name="login-form" class="form-container" action="/sotukenAdmin/LoginControl?page=student" method="post">

	<div class="form-title"><h2>ログイン</h2></div>
	<div class="form-title">ユーザーID</div>
		<input class="input" type="text" name="user" />
		<label><font color="red">（学籍番号7桁）</font></label><br />
	<div class="form-title">パスワード</div>
		<input class="input" type="password" name="passwd" /><br />
	<div class="submit-container">
		<input type="submit" name="submit" value="ログインして、受験報告書Siteへ行く" class="button" />
		<br/>${errMsg }
	</div>

</form>

</div>
<div class="gradient"></div>
</body>
</html>