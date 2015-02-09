<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <fmt:setBundle basename="res.msg" var="msg" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<!-- css -->
<link href="/sotukenAdmin/css/site.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>一時表一覧</title>
</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>一時表一覧</h1>

<!-- table -->
<table id="table1" class="table01">

	<tr id="tr1">
	<th style="width:10%" align="left">受験ID</th>
	<th style="width:14%" align="left">提出日時</th>
	<th style="width:10%" align="left">出席番号</th>
	<th style="width:14%" align="left">氏名</th>
	<th style="width:18%" align="left">企業名</th>
	<th style="width:14%" align="left">何次試験</th>
	<th style="width:14%" align="left">卒業年度</th>
	</tr>

<c:forEach items="${tm.ji}" var="item">

	<tr id="tr2">
		<td style="width:10%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.juId }</a></td>
		<td style="width:14%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.teiDate }</a></td>
		<td style="width:10%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.syuNum }</a></td>
		<td style="width:14%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.name }</a></td>
		<td style="width:18%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.kigyoName }</a></td>
		<td style="width:14%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.nanji }</a></td>
		<td style="width:14%"><a href="/sotukenAdmin/TempServlet?page=tempAll&juId=${item.juId }">${item.sotuDate }</a></td>
	</tr>

</c:forEach>
</table>
${tm.resultMsg }

<hr />

<div id="wrapper">
<form>
<input type="button" value="戻 る" class="button" onclick="history.back()" />
</form>
</div>

</body>
</html>