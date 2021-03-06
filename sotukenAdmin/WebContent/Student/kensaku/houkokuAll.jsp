<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




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

<%@include file="../../menu/student_menu.jsp" %>

<h1>企業検索 報告書</h1>

<!-- 選択企業名表示 -->
<h2>${km.ki.kigyoName}</h2>

<table id="table1" class="table01">
	<thead>
	<tr id="tr1">
		<th style="width:18%" align="left">提出日時</th>
		<th style="width:16%" align="left">出席番号</th>
		<th style="width:18%" align="left">氏名</th>
		<th style="width:16%" align="left">何次試験</th>
		<th style="width:16%" align="left">卒業年度</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${km.ji}" var="item">
	<tr>
		<td style="width:16%"><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.teiDate }</a></td>
		<td style="width:16%"><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.syuNum }</a></td>
		<td style="width:16%"><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.name }</a></td>
		<td style="width:16%"><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.nanji }</a></td>
		<td style="width:16%"><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.sotuDate }</a></td>
	</tr>
	</c:forEach>
	</tbody>

</table>
${km.resultMsg }
<hr />

<div id="wrapper">
<form>
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
</form>
</div>

</body>
</html>