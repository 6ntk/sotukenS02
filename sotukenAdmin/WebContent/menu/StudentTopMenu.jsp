<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/menu.css"/>

<title>メニュー</title>
</head>
<body>

<%@include file="../menu/student_menu.jsp" %>

<h1>トップ</h1>

<p><a href="/sotukenAdmin/Student/kensaku/kensaku.jsp">企業検索</a></p>
<p><a href="/sotukenAdmin/Student/houkoku/houkoku.jsp">受験報告登録</a></p>
<p><a href="/sotukenAdmin/LoginControl?state=student">ログアウト</a></p>
</body>
</html>