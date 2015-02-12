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

<script type="text/javascript" src="/sotukenAdmin/js/top_datatables.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/site.css"/>
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/jquery.dataTables.css"/>

<title>Top</title>
</head>
<body>

<%@include file="../../menu/admin_menu.jsp" %>
<div id="wrapper">
<h1>トップ</h1>

<h2>更新履歴</h2>
<table id="table1" class="table01">
	<thead>
	<tr id="tr1">
		<th style="width:15%" align="left">提出日時</th>
		<th style="width:14%" align="left">受験ID</th>
		<th style="width:14%" align="left">企業名</th>
		<th style="width:14%" align="left">出席番号</th>
		<th style="width:15%" align="left">氏名</th>
		<th style="width:14%" align="left">何次試験</th>
		<th style="width:14%" align="left">卒業年度</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${km.ji}" var="item">
	<tr>
		<td style="width:15%"><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.teiDate }</a></td>
		<td style="width:14%" ><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.juId }</a></td>
		<td style="width:14%" ><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.kigyoName }</a></td>
		<td style="width:14%" ><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.syuNum }</a></td>
		<td style="width:15%"><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.name }</a></td>
		<td style="width:14%" ><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.nanji }</a></td>
		<td style="width:14%" ><a href="/sotukenAdmin/KensakuServlet?page=syosai&juId=${item.juId }">${item.sotuDate }</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<h2>${km.resultMsg }</h2>

<hr />

<form>
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
</form>
</div>

</body>
</html>
