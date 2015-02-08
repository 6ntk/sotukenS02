<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="kigyo.KigyoInfo"%>
<%@page import="user.UserInfo"%>
<%@page import="kigyo.KigyoDBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="res.msg" var="msg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/confirm.css"/>

<title>企業登録</title>
</head>
<body>
<%@include file="../menu/admin_menu.jsp" %>

<h1>企業登録 確認</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KigyoServlet" method="post">

	<table id="table1" class="table2">

		<tr>
			<th>企業名</th>
			<td>${KigyoInfo.kigyoName }</td>
		</tr>
		<tr>
			<th>企業名<br />(ふりがな)</th>
			<td>${KigyoInfo.kigyoFuri }</td>
		</tr>
		<tr>
			<th>住所</th>
			<td>${KigyoInfo.address }</td>
		</tr>

	</table>

	<p>登録しますか</p>

	<div id="wrapper">
	<input type="submit" value="登 録" name="insertKigyo" class="button"/>
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
	</div>

</form>

</div>

</body>
</html>