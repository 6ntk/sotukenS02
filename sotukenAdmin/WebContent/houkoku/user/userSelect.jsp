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
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/site.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ユーザー一覧</title>
</head>
<body>
<%@include file="../../menu/admin_menu.jsp" %>


<h1>ユーザー一覧</h1>
<table id="table1" class="table01">

	<tr id="tr1">
		<th style="width:50%" align="left">学籍番号</th>
		<th style="width:50%" align="left">名前</th>
	</tr>

<c:forEach items="${km.uList}" var="item">

	<tr id="tr2">
		<td style="width:50%"><a href="/sotukenAdmin/HoukokuServlet?page=gakuseki&gakuseki=${item.gakuseki }">${item.gakuseki }</a></td>
		<td style="width:50%"><a href="/sotukenAdmin/HoukokuServlet?page=gakuseki&gakuseki=${item.gakuseki }">${item.name }</a></td>
	</tr>
</c:forEach>

</table>

<hr />

<div id="wrapper">
	<form>
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
	</form>
</div>

</body>
</html>