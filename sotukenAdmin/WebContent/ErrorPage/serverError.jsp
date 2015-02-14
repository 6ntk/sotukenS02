<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link href="/sotukenAdmin/css/form.css" rel="stylesheet" type="text/css" />
<title>エラー</title>
</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>エラー</h1>

<div id="wrapper">

${em.errMsg }

<form  method="post">
<input type="button" value="戻 る" onclick="history.back()" />
<input type="button" value="ログイン画面へ戻る" class="button" onclick="location.href='/sotukenAdmin/StudentLogin/login.jsp'" />
</form>

</div>

</body>
</html>