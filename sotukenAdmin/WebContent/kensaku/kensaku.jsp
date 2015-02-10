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

<<<<<<< HEAD
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
  <!-- jQuery -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <!-- DataTables -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
  $('#table1').dataTable();
});
</script>

<!-- dataTables -->
<!-- <link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/jquery.dataTables.css"/>
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/tool.js"></script> -->

=======
<!-- <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
  jQuery
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  DataTables
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script> -->

<!-- dataTables -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/jquery.dataTables.min.js"></script>
<!-- <script type="text/javascript" src="/sotukenAdmin/js/tool.js"></script> -->

<script type="text/javascript" src="/sotukenAdmin/js/datatables.js"></script>
>>>>>>> refs/heads/オリジナル

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/site.css"/>
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/jquery.dataTables.css"/>

<title>企業検索</title>
</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>企業検索</h1>

<!-- 企業全表示ボタン -->
<div id="level">
<ul id="level1">
	<li><a href="/sotukenAdmin/KensakuServlet?page=all">全表示</a></li>
</ul>
</div>

<form action="/sotukenAdmin/KensakuServlet" method="post">

	<select name="select">
		<option value="1">曖昧検索</option>
		<option value="2">完全一致</option>
	</select>
	<input type="text" name="name" class="input"/>
	<input type="submit" value="検 索" class="searchButton"/>

	<table id="table1" class="table01">
	<thead>
	<tr id="tr1">
		<th style="width:10%" align="left">企業ID</th>
		<th style="width:30%" align="left">企業名</th>
		<th style="width:30%" align="left">企業名(ふりがな)</th>
		<th style="width:30%" align="left">住所</th>
	</tr>
	</thead>
<<<<<<< HEAD
<tbody>
=======
	<tbody>
>>>>>>> refs/heads/オリジナル
	<c:forEach items="${km.list}" var="item">

		<tr id="tr2">
		<td style="width:10%"><a href="/sotukenAdmin/KensakuServlet?page=all&id=${item.id }">${item.id }</a></td>
		<td style="width:30%"><a href="/sotukenAdmin/KensakuServlet?page=all&id=${item.id }">${item.kigyoName }</a></td>
		<td style="width:30%"><a href="/sotukenAdmin/KensakuServlet?page=all&id=${item.id }">${item.kigyoFuri }</a></td>
		<td style="width:30%"><a href="/sotukenAdmin/KensakuServlet?page=all&id=${item.id }">${item.address }</a></td>
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
