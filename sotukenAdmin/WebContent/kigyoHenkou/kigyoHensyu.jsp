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

<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>

<!-- validate -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery.validate.min.js"></script>

<!-- tool -->
<script type="text/javascript" src="/sotukenAdmin/js/toolKigyoValidate.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/confirm.css"/>

<title>登録企業編集</title>
</head>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<br/>
<h1>企業編集</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KigyoServlet" method="post" id="myform">

	<table id="kigyoInfo" class="table2">

		<tr >
			<td rowspan="3" class="td1"><b>企業情報</b></td>

			<th>企業名</th>
			<td><input type="text" name="kigyoName" value="${km.ki.kigyoName }" style="width:99%;height: 99%;"/></td>

		</tr>
		<tr>
			<th>企業名<br />（ふりがな）</th>
			<td><input type="text" name="kigyoFuri"value="${km.ki.kigyoFuri }" style="width:99%;height: 99%;"/></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><input type="text" name="address" value="${km.ki.address }" style="width:99%;height: 99%;"/></td>
		</tr>

	</table>

	<hr />

	<input type="button" value="戻る" onclick="history.back()" />
	<input type="submit" value="確認" name="kigyoKakunin"/>

</form>

</div>
</body>
</html>