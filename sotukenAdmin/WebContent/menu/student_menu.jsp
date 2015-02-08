<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/footer.css"/>
</head>

<c:if test="{empty loginInfo}">
<c:redirect url="/login/login.jsp"/>
</c:if>

<p>${loginInfo.name}さん ようこそ</p>


    <div id="globalnavi">
	<table width="100%">
    <tr>
	    <th id="menu1" width="25%"><a href="/sotukenAdmin/menu/StudentTopMenu.jsp">トップ</a></th>
	    <th id="menu2" width="25%"><a href="/sotukenAdmin/Student/kensaku/kensaku.jsp">企業検索</a></th>
	    <th id="menu3" width="25%"><a href="/sotukenAdmin/Student/houkoku/houkoku.jsp">報告書提出</a></th>
	    <th id="menu4" width="25%"><a href="/sotukenAdmin/LoginControl?state=student">ログアウト</a></th>
    </tr>
	</table>
    </div>