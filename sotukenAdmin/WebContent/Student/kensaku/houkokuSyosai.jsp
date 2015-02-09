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
<link href="/sotukenAdmin/css/form.css" rel="stylesheet" type="text/css" />

<title>受験報告書</title>
</head>
<body>

<%@include file="../../menu/student_menu.jsp" %>

<h1>受験報告書 詳細</h1>

<div id="wrapper">

<!-- 提出日 -->
<table id="teiDate" class="table2">
		<tr>
			<th>提出日</th>
			<td>${km.jhi.teiDate}</td>
	</tr>
</table>

<!-- 出席番号、性別、名前 -->
<table id="studentInfo" class="table1">

	<tr >
		<td rowspan="3" class="td1"><b>生徒情報</b></td>

		<th>出席番号</th>
		<td>${km.ui.syuNum}</td>

	</tr>
	<tr>
		<th>性別</th>
		<td>${km.ui.sex}</td>
	</tr>
	<tr>
		<th>名前</th>
		<td>${km.ui.name}</td>
	</tr>
</table>

<br/>

<!-- 1 -->
<table id="table1" class="table1">

	<tr >
		<td rowspan="2" class="td1"><b>受験先</b></td>
		<th>企業名</th>
		<td>${km.ki.kigyoName}</td>
	</tr>

	<tr>
		<th>住所</th>
		<td>${km.ki.address}</td>
	</tr>

	<tr >
		<td rowspan="3" class="td1">
		<b>日時<br />
		および<br />
		実施試験</b></td>

		<th>何次試験</th>
		<td>${km.jhi.nanji}次試験
		<!-- エラー表示場所 -->
		<div id="nanji_error"></div>
		</td>
	</tr>

	<tr>
		<th>実施日</th>
		<td><p>
		開始：${km.jhi.dateFrom}
		</p>
		<p>
		終了：${km.jhi.dateTo}
		</p>

		<!-- エラー表示場所 -->
		<div id="testSyu_error"></div>
		</td>
	</tr>

	<tr>
		<th>試験種類</th>
		<td>${km.jhi.testSyu}
		<!-- エラー表示場所 -->
		<div id="testSyu_error"></div>
		</td>
	</tr>

</table><!-- 1 -->

<br/>

<!-- 2 -->
<table border="1" id="table2" class="table1">

	<tr>
		<td rowspan="3" class="td1"><b>結果通知</b></td>
		<th>宛</th>
		<td>${km.jhi.toGa}</td>
	</tr>

	<tr>
		<th>日時</th>
		<td>${tn.jhitn.tutiDate}
		</td>
	</tr>

</table><!-- 2 -->

<br/>

<!-- 3 -->
<table id="table3" class="table1">

	<!-- 筆記試験 -->
	<tr>
		<th colspan="3" height="5">筆記試験</th>
	</tr>

	<tr >
		<td rowspan="2" class="td1"><b>一般常識</b></td>

		<th>科目</th>
		<td>${km.jhi.ippanKamoku}</td>
	</tr>

	<tr>
		<th>時間</th>
		<td>${tn.jhitn.ippanTime}</td>
	</tr>

	<tr>
		<td rowspan="2" class="td1"><b>専門科目</b></td>

		<th>科目</th>
		<td>${km.jhi.senmonKamoku}</td>
	</tr>

	<tr>
		<th>時間</th>
		<td>${tn.jhitn.senmonTime}</td>
	</tr>

	<tr >
		<td rowspan="2" class="td1"><b>その他</b></td>

		<th>科目</th>
		<td>${km.jhi.sonota}</td>
	</tr>

	<tr>
		<th>時間</th>
		<td>${tn.jhitn.sonoTime}</td>
	</tr>
</table><!-- 3 -->


<!-- colspan3 -> colspan2 sにするためにtableを分割 -->
<!-- 4 -->
<table id="table4" class="table2">

	<!-- 筆記試験 試験内容 -->
	<tr >
		<th>試験内容</th>
		<td>${km.jhi.sikenComment}</td>
	</tr>

	<!-- 作文 -->
	<tr>
		<th colspan="2" height="5">作文</th>
	</tr>

	<tr >
		<th>テーマ名</th>
		<td>${km.jhi.theme}</td>
	</tr>

	<tr>
		<th>時間</th>
		<td>${tn.jhitn.bunTime}</td>
	</tr>

	<tr>
		<th>字数</th>
		<td>${tn.jhitn.bunRyo}</td>
	</tr>

	<tr>
		<th>完成度</th>
		<td>${tn.jhitn.kanseido}</td>
	</tr>


	<!-- 適性検査 -->
	<tr>
		<th colspan="2" height="5">適性検査</th>
	</tr>

	<tr >
		<th>検査種類</th>
		<td>${km.jhi.kensaSyu}</td>

	</tr>
	<tr>
		<th>検査時間</th>
		<td>${tn.jhitn.kensaTime}</td>
	</tr>

	<tr>
		<th>検査内容</th>
		<td>${km.jhi.kensaComment}</td>
	</tr>


	<!-- 面接試験 -->
	<tr>
		<th colspan="2" height="5">面接試験</th>
	</tr>

	<tr >
		<th>面接人数<br/>企業側</th>
		<td>${tn.jhitn.menNin1}</td>
	</tr>

	<tr>
		<th>面接人数<br/>受験者側</th>
		<td>${tn.jhitn.menNin2}</td>
	</tr>

	<tr>
		<th>面接形態</th>
		<td>${km.jhi.menKatati}</td>
	</tr>

	<tr>
		<th>面接時間</th>
		<td>${tn.jhitn.menTime}</td>
	</tr>

	<tr>
		<th>企業側の<br/>質問内容</th>
		<td>${km.jhi.sitsuComment}</td>
	</tr>

	<tr>
		<th>反省点</th>
		<td>${km.jhi.hanseiComment}</td>
	</tr>


	<!-- 健康診断 -->
	<tr>
		<th colspan="2" height="5">健康診断</th>
	</tr>

	<tr >
		<th>検査内容</th>
		<td>${km.jhi.kenComment}</td>
	</tr>

	<!-- 助言 -->
	<tr>
		<th colspan="2" height="5">助言</th>
	</tr>

	<tr >
		<th>受験後の<br/>感想と<br/>後輩への<br/>助言</th>
		<td>${km.jhi.jogen}</td>
	</tr>

</table><!-- 4 -->

<!-- 前画面に戻る -->
<form>
<input type="button" value="戻 る" class="button" onclick="history.back()" />
</form>

</div>

</body>
</html>