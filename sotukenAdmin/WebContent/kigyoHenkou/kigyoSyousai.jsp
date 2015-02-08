<?xml version="1.0" encoding="UTF-8" ?>
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

<title>登録企業編集</title>
</head>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<br/>
<h1>企業編集 詳細</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KigyoServlet?id=${km.ki.id }" method="post">

	<table id="kigyoInfo" class="table2">

		<tr >
			<td rowspan="4" class="td1"><b>企業情報</b></td>

			<th>企業ID</th>
			<td>${km.ki.id }</td>

		</tr>
		<tr>
			<th>企業名</th>
			<td>${km.ki.kigyoName }</td>
		</tr>
		<tr>
			<th>企業名<br />（ふりがな）</th>
			<td>${km.ki.kigyoFuri }</td>
		</tr>
		<tr>
			<th>住所</th>
			<td>${km.ki.address }</td>
		</tr>

	</table>

	<hr />

	<input type="submit" value="編集" name="kigyoHensyu"/>
	<input type="submit" value="削除" name="kigyoDelete"/>
	<input type="button" value="戻る" onclick="history.back()"/>

</form>

</div>

</body>
</html>