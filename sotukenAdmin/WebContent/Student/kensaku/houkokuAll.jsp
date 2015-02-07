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
<link href="/sotukenAdmin/css/site.css" rel="stylesheet" type="text/css" />

<title>受験報告書</title>
</head>
<body>

<%@include file="../../menu/student_menu.jsp" %>

<h1>企業検索 報告書</h1>

<table id="table1" class="table01">

	<tr id="tr1">
		<th style="width:16%" align="left">受験ID</th>
		<th style="width:16%" align="left">出席番号</th>
		<th style="width:18%" align="left">氏名</th>
		<th style="width:16%" align="left">何次試験</th>
		<th style="width:18%" align="left">提出日時</th>
		<th style="width:16%" align="left">卒業年度</th>
	</tr>

	<c:forEach items="${km.ji}" var="item">
	<tr>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.juId }</a></th>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.syuNum }</a></th>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.name }</a></th>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.nanji }</a></th>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.teiDate }</a></th>
		<th><a href="/sotukenAdmin/StudentServlet?page=syosai&juId=${item.juId }">${item.sotuDate }</a></th>
	</tr>
	</c:forEach>

</table>

<hr />

<div id="wrapper">
<form>
	<input type="button" value="戻る" onclick="history.back()" />
</form>
</div>

</body>
</html>