<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/menu.css"/>

</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<div id="wrapper">

	<!-- 企業登録・変更・削除､報告書登録・変更・削除 完了通知-->
	<h1>${km.resultMsg }</h1>

	<!-- 一時表 -> 本データベース登録 完了通知 -->
	<h1>${tm.resultMsg }</h1>

	<input type="button" value="戻 る" class="button" onclick="location.href='/sotukenAdmin/TopServlet'" />

</div>

</body>
</html>