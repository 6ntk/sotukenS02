<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="kigyo.KigyoInfo"%>
<%@page import="user.UserInfo"%>
<%@page import="kigyo.KigyoDBManage"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="res.msg" var="msg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- 郵便番号検索 -->
<script src="http://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3.js" charset="UTF-8"></script>

<!-- <script type="text/javascript" src="/sotukenAdmin/js/jquery-2.1.1.min.js"></script> -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>

<!-- validate -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery.validate.min.js"></script>

<!-- tool -->
<script type="text/javascript" src="/sotukenAdmin/js/toolKigyoValidate.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/confirm.css"/>

<title>企業登録</title>
</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>企業登録</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KigyoServlet" method="post" id="myform">

	<table id="kigyoInfo" class="table2">

		<tr >
			<td rowspan="4" class="td1"><b>企業情報</b></td>

			<th>企業名</th>
			<td><input type="text" name="kigyoName" value="${km.ki.kigyoName }" class="kigyoInput"/></td>

		</tr>
		<tr>
			<th>企業名<br />(ふりがな)</th>
			<td><input type="text" name="kigyoFuri"value="${km.ki.kigyoFuri }" class="kigyoInput"/></td>
		</tr>
		<tr>
			<th>郵便番号<br />(任意)</th>
			<td><input type="text" name="zip" class="kigyoInput" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','address','address');"/></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><input type="text" name="address" value="${km.ki.address }" class="kigyoInput"/></td>
		</tr>

	</table>

	<hr />

	<div id="wrapper">
	<input type="submit" value="送 信" name="insertKigyoKakunin" class="button"/>
	<input type="button" value="戻 る" class="button" onclick="history.back()"/>
	</div>

</form>

</div><!-- wrapper -->

</body>
</html>