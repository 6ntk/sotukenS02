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

<!-- dataTables -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/jquery.dataTables.min.js"></script>
<!-- <script type="text/javascript" src="/sotukenAdmin/js/tool.js"></script> -->

<script type="text/javascript" src="/sotukenAdmin/js/datatables.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/site.css"/>
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/jquery.dataTables.css"/>

<title>受験報告書</title>
</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>受験報告書提出</h1>

<!-- 企業全表示ボタン -->
<div id="level">
<ul id="level1">
	<li><a href="/sotukenAdmin/HoukokuServlet?page=all">全表示</a></li>
</ul>
</div>

<form action="/sotukenAdmin/HoukokuServlet" method="post">

	<select name="select">
		<option value="1">曖昧検索</option>
		<option value="2">完全一致</option>
	</select>
	<input type="text" name="name" class="input"/>
	<input type="submit" value="検 索" class="searchButton"/>

	<!-- table -->
	<table id="table1" class="table01">
		<thead>
		<tr id="tr1">
		<th style="width:10%" align="left">企業ID</th>
		<th style="width:30%" align="left">企業名</th>
		<th style="width:30%" align="left">企業名(ふりがな)</th>
		<th style="width:30%" align="left">住所</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${km.list}" var="item">
			<tr id="tr2" >
			<td style="width:10%"><a href="/sotukenAdmin/HoukokuServlet?page=all&id=${item.id }">${item.id }</a></td>
			<td style="width:30%"><a href="/sotukenAdmin/HoukokuServlet?page=all&id=${item.id }">${item.kigyoName }</a></td>
			<td style="width:30%"><a href="/sotukenAdmin/HoukokuServlet?page=all&id=${item.id }">${item.kigyoFuri }</a></td>
			<td style="width:30%"><a href="/sotukenAdmin/HoukokuServlet?page=all&id=${item.id }">${item.address }</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	${km.resultMsg }

	<hr />
	<div id="wrapper">
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
	</div>

</form>

</body>
</html>