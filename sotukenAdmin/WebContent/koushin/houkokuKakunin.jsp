<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="juken.JukenHoukokuInfo"%>
<%@page import="toNull.ToNull"%>
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
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/confirm.css"/>

<title>受験報告書</title>
</head>
<body>

<%@include file="../../menu/student_menu.jsp" %>

<h1>受験報告書 確認</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KoushinServlet" method="post">

<!-- 1 -->
<table id="kigyoInfo" class="table1">

	<!-- 出席番号、性別、名前 -->
	<tr >
		<td rowspan="3" width="10"><b>生徒情報</b></td>

		<th>出席番号</th>
		<td>${km.ui.syuNum}</td>

	</tr>
	<tr>
		<th>性別</th>
		<td>${km.ui.sex}</td>
	</tr>
	<tr>
		<th>名前</th>
		<td>${km.ui.sex}</td>
	</tr>

	<!-- 企業情報 -->
	<tr >
		<td rowspan="8" width="10"><b>企業情報</b></td>
		<th>企業名</th><td>${km.ki.kigyoName}</td>
	</tr>
	<tr>
		<th>住所</th><td>${km.ki.address}</td>
	</tr>
	<tr>
		<th>何次試験</th><td>${JukenHoukokuInfo.nanji}</td>
	</tr>
	<tr>
		<th>試験開始<br />日時</th><td>${JukenHoukokuInfo.dateFrom}</td>
	</tr>
	<tr>
		<th>試験終了<br />日時</th><td>${JukenHoukokuInfo.dateTo}</td>
	</tr>
	<tr>
		<th>試験種類</th><td>${JukenHoukokuInfo.testSyu}</td>
	</tr>
	<tr>
		<th>結果通知<br />日時</th><td>${tn.jhitn.tutiDate}</td>
	</tr>
	<tr>
		<th>宛</th><td>${JukenHoukokuInfo.toGa}</td>
	</tr>

</table>

<br/>

<!-- 2 -->
<table id="table2" class="table1">

	<tr>
		<th colspan="3" height="5">試験内容</th>
	</tr>

	<!-- 筆記試験 -->
	<tr >
		<td rowspan="7" width="10"><b>筆記試験</b></td>
		<th>一般常識<br />科目</th><td>${JukenHoukokuInfo.ippanKamoku}</td>
	</tr>
	<tr>
		<th>一般常識<br />時間</th><td>${tn.jhitn.ippanTime}</td>
	</tr>
	<tr>
		<th>専門科目<br />科目</th><td>${JukenHoukokuInfo.senmonKamoku}</td>
	</tr>
	<tr>
		<th>専門科目<br />時間</th><td>${tn.jhitn.senmonTime}</td>
	</tr>
	<tr>
		<th>その他</th><td>${JukenHoukokuInfo.sonota}</td>
	</tr>
	<tr>
		<th>その他<br />時間</th><td>${tn.jhitn.sonoTime}</td>
	</tr>
	<tr>
		<th>試験内容</th><td>${JukenHoukokuInfo.sikenComment}</td>
	</tr>

	<!-- 作文 -->
	<tr >
		<td rowspan="4" width="10"><b>作文</b></td>
		<th>テーマ名</th><td>${JukenHoukokuInfo.theme}</td>
	</tr>
	<tr>
		<th>時間</th><td>${tn.jhitn.bunTime}</td>
	</tr>
	<tr>
		<th>字数</th><td>${tn.jhitn.bunRyo}</td>
	</tr>
	<tr>
		<th>完成度</th><td>${tn.jhitn.kanseido}</td>
	</tr>

	<!-- 適性検査 -->
	<tr >
		<td rowspan="3" width="10"><b>適性検査</b></td>
		<th>検査の<br />種類</th><td>${JukenHoukokuInfo.kensaSyu}</td>
	</tr>
	<tr>
		<th>検査時間</th><td>${tn.jhitn.kensaTime}</td>
	</tr>
	<tr>
		<th>検査内容</th><td>${JukenHoukokuInfo.kensaComment}</td>
	</tr>

	<!-- 面接試験 -->
	<tr >
		<td rowspan="6" width="10"><b>面接試験</b></td>
		<th>面接人数<br />企業側</th><td>${tn.jhitn.menNin1}</td>
	</tr>
	<tr>
		<th>面接人数<br />受験者側</th><td>${tn.jhitn.menNin2}</td>
	</tr>
	<tr>
		<th>面接形態</th><td>${JukenHoukokuInfo.menKatati}</td>
	</tr>
	<tr>
		<th>面接時間</th><td>${tn.jhitn.menTime}</td>
	</tr>
	<tr>
		<th>企業側<br />質問内容</th><td>${JukenHoukokuInfo.sitsuComment}</td>
	</tr>
	<tr>
		<th>反省点</th><td>${JukenHoukokuInfo.hanseiComment}</td>
	</tr>

	<!-- 健康診断 -->
	<tr >
		<td rowspan="1" width="10"><b>健康診断</b></td>
		<th>検査内容</th><td>${JukenHoukokuInfo.kenComment}</td>
	</tr>

	<!-- 助言 -->
	<tr >
		<td rowspan="1" width="10"><b>助言</b></td>
		<th>受験後の<br />感想と<br />後輩への<br />助言</th><td>${JukenHoukokuInfo.jogen}</td>
	</tr>

</table>

	<input type="submit" value="登 録" name="updateKettei" class="button"/>
	<input type="button" value="戻 る" class="button" onclick="history.back()" />
</form>

</div>

</body>
</html>