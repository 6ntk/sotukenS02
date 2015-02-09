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

	<form name="login-form" class="login-form" action="/sotukenAdmin/LoginControl" method="post">

	<table width="100%">
	<tr>
		<th width="30%">管理者ID</th><td><input name="user" type="text" class="input" /></td>
	</tr>

	<tr>
		<th width="30%">パスワード</th><td><input name="passwd" type="password" class="input" /></td>
	</tr>
	</table>

	<hr />

	<input type="submit" name="submit" value="ログイン" class="button" />

	</form>

</div>
<div class="gradient"></div>
${km.resultMsg }
${errMsg }
</body>
</html>