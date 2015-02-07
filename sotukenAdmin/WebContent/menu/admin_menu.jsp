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
	    <th id="menu1" width="15%"><a href="/sotukenAdmin/menu/Menu.jsp">トップ</a></th>
	    <th id="menu2" width="14%"><a href="/sotukenAdmin/KensakuServlet?page=all">企業検索</a></th>
	    <th id="menu3" width="14%"><a href="/sotukenAdmin/TempServlet?page=all">一時表一覧</a></th>
	    <th id="menu4" width="14%"><a href="/sotukenAdmin/HoukokuServlet?page=all">受験報告書提出</a></th>
	    <th id="menu5" width="14%"><a href="/sotukenAdmin/kigyoTouroku/kigyoTouroku.jsp">企業登録</a></th>
	    <th id="menu6" width="14%"><a href="/sotukenAdmin/KigyoServlet?page=all">企業編集</a></th>
	    <th id="menu7" width="15%"><a href="/sotukenAdmin/LoginControl?state=logout">ログアウト</a></th>
    </tr>
    </table>
    </div>