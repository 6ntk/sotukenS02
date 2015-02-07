<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="temp.TempDBManage"%>
<%@page import="juken.JukenHoukokuInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="res.msg" var="msg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>login</title>
</head>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<h1>一次表一覧</h1>

<form action="/sotukenAdmin/TempServlet" method="post">
<table border="1">
<tr><td>出席番号</td><td>${tm.ui.syuNum}</td></tr>
<tr><td>性別</td><td>${tm.ui.sex}</td></tr>
<tr><td>氏名</td><td>${tm.ui.name}</td></tr>
<tr><td>企業名</td><td>${tm.ki.kigyoName}</td></tr>
<tr><td>住所</td><td>${tm.ki.address}</td></tr>
<tr><td>何次試験</td><td>${tm.jhi.nanji}</td></tr>
<tr><td>試験開始日時</td><td>${tm.jhi.dateFrom}</td></tr>
<tr><td>試験終了日時</td><td>${tm.jhi.dateTo}</td></tr>
<tr><td>試験種類</td><td>${tm.jhi.testSyu}</td></tr>
<tr><td>結果通知日時</td><td>${tn.jhitn.tutiDate}</td></tr>
<tr><td>宛</td><td>${tm.jhi.toGa}</td></tr>
</table>

<h2>試験内容</h2>

<table border="1">
<tr><td>一般常識 科目</td><td>${tm.jhi.ippanKamoku}</td></tr>
<tr><td>一般常識 時間</td><td>${tn.jhitn.ippanTime}</td></tr>
<tr><td>専門科目 科目</td><td>${tm.jhi.senmonKamoku}</td></tr>
<tr><td>専門科目 時間</td><td>${tn.jhitn.senmonTime}</td></tr>
<tr><td>その他</td><td>${tm.jhi.sonota}</td></tr>
<tr><td>その他 時間</td><td>${tn.jhitn.sonoTime}</td></tr>
<tr><td>試験内容</td><td>${tm.jhi.sikenComment}</td></tr>

<tr><td>テーマ名</td><td>${tm.jhi.theme}</td></tr>
<tr><td>時間</td><td>${tn.jhitn.bunTime}</td></tr>
<tr><td>字数</td><td>${tn.jhitn.bunRyo}</td></tr>
<tr><td>完成度</td><td>${tn.jhitn.kanseido}</td></tr>

<tr><td>検査の種類</td><td>${tm.jhi.kensaSyu}</td></tr>
<tr><td>検査時間</td><td>${tn.jhitn.kensaTime}</td></tr>
<tr><td>検査内容</td><td>${tm.jhi.kensaComment}</td></tr>

<tr><td>面接人数 企業側</td><td>${tn.jhitn.menNin1}</td></tr>
<tr><td>面接人数 受験者側</td><td>${tn.jhitn.menNin2}</td></tr>
<tr><td>面接形態</td><td>${tm.jhi.menKatati}</td></tr>
<tr><td>面接時間</td><td>${tn.jhitn.menTime}</td></tr>
<tr><td>企業側質問内容</td><td>${tm.jhi.sitsuComment}</td></tr>
<tr><td>反省点</td><td>${tm.jhi.hanseiComment}</td></tr>

<tr><td>検査内容</td><td>${tm.jhi.kenComment}</td></tr>

<tr><td>受験後の感想と後輩への助言</td><td>${tm.jhi.jogen}</td></tr>
</table>

登録してよろしいですか？
<input type="submit" value="登録" name="updateKakuninTouroku"/>
<input type="button" value="戻る" onclick="history.back()" />
</form>

</body>
</html>