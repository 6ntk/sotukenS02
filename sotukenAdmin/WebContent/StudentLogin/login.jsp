<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/login.css"/>

<title>StudentLogin</title>
</head>
<body>

<div id="wrapper">

	<form name="login-form" class="login-form" action="/sotukenAdmin/LoginControl?page=student" method="post">

		<div class="header">
		<h1>ログイン</h1>
		</div>

		<div class="content">
		<span>学籍番号</span>
		<input name="user" type="text" class="input username" />
		<span>パスワード</span>
		<input name="passwd" type="password" class="input password" />
		</div>

		<div class="footer">
		<input type="submit" name="submit" value="Login" class="button" />
		</div>

	</form>

</div>
<div class="gradient"></div>

${errMsg }
</body>
</html>