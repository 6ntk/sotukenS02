<?xml version="1.0" encoding="UTF-8" ?>

<%@page import="juken.JukenHoukokuInfo"%>
<%@page import="kigyo.KigyoDBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="true"%>
<%
	KigyoDBManage km = (KigyoDBManage)request.getAttribute("km");
	JukenHoukokuInfo jhi = km.getJhi();
%>

<fmt:setBundle basename="res.msg" var="msg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>
<!-- datetimepicker -->
<script src="/sotukenAdmin/js/jquery.datetimepicker.js"></script>

<!-- validate -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/toolValidate.js"></script>

<!-- tool -->
<script type="text/javascript" src="/sotukenAdmin/js/tool.js"></script>

<script type="text/javascript">

$(function(){

	nanji = '<%=jhi.getNanji() %>';
	toGa = '<%=jhi.getToGa() %>';

	//カンマで分割し配列に格納
	testSyu = '<%=jhi.getTestSyu() %>'.split(",");
	ippanKamoku = '<%=jhi.getIppanKamoku() %>'.split(",");
	senmonKamoku = '<%=jhi.getSenmonKamoku()%>'.split(",");
	kensaSyu = '<%=jhi.getKensaSyu()%>'.split(",");
	menKatati = '<%=jhi.getMenKatati()%>'.split(",");
});
</script>

<script type="text/javascript" src="/sotukenAdmin/js/check.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/form.css"/>
<link rel="stylesheet" href="/sotukenAdmin/css/jquery.datetimepicker.css" />



<title>受験報告書</title>

</head>
<body>

<%@include file="../menu/admin_menu.jsp" %>

<h1>受験報告書編集</h1>

<div id="wrapper">

<form action="/sotukenAdmin/KoushinServlet" method="post" id="myform" name="myform">

	<!-- 出席番号、性別、名前 -->
	<table id="studentInfo" class="table1">

		<tr >
			<td rowspan="4" width="10"><b>生徒情報</b></td>

			<th>出席番号</th>
			<td><a href="/sotukenAdmin/KoushinServlet?page=userHenkou">${km.ui.syuNum}</a></td>

		</tr>
		<tr>
			<th>性別</th>
			<td>${km.ui.sex}</td>
		</tr>
		<tr>
			<th>名前</th>
			<td>${km.ui.name}</td>
		</tr>
		<tr>
			<th>卒業年度</th>
			<td>${km.ui.sotuDate}</td>
		</tr>

	</table>

	<br/>

	<!-- 1 -->
	<table id="table1" class="table1">

		<tr >
			<td rowspan="2" width="10"><b>受験先</b></td>
			<th>企業名</th>
			<td><a href="/sotukenAdmin/KoushinServlet?page=kigyoHenkou">${km.ki.kigyoName}</a></td>
		</tr>
		<tr>
			<th>住所</th>
			<td>${km.ki.address}</td>
		</tr>
		<tr >
			<td rowspan="3" width="10">
			<b>日時<br />
			および<br />
			実施試験</b></td>

			<th>何次試験</th>
			<td><input type="radio" name="nanji" value="1" onclick="changeDisabled()" />一次試験　
			<input type="radio" name="nanji" value="2"  onclick="changeDisabled()"/>二次試験　
			<input type="radio" name="nanji" value="3"  onclick="changeDisabled()"/>三次試験　
			<input type="radio" name="nanji" value="4"  onclick="changeDisabled()"/>その他　<input type="text" name="nanjiEtc" />

			<!-- エラー表示場所 -->
			<div id="nanji_error"></div>
			</td>
		</tr>
		<tr>
			<th>実施日</th>
			<td><p>
			開始：　<input type="text" value="${JukenHoukokuInfo.dateFrom }" name="dateFrom" id="date_from"/>
			</p>
			<p>
			終了：　<input type="text" value="${JukenHoukokuInfo.dateTo }" name="dateTo" id="date_to"/>
			</p>

			<!-- エラー表示場所 -->
			<div id="testSyu_error"></div>
			</td>
		</tr>
		<tr>
			<th>試験種類</th>
			<td><input type="checkbox" name="testSyu" value="1"/>筆記
			<input type="checkbox" name="testSyu" value="2"/>作文
			<input type="checkbox" name="testSyu" value="3"/>適性
			<input type="checkbox" name="testSyu" value="4"/>面接
			<input type="checkbox" name="testSyu" value="5" onclick="connecttext('testSyuEtc',this.checked);"/>その他　<input type="text" name="testSyuEtc" id="testSyuEtc" disabled="disabled"/>

			<!-- エラー表示場所 -->
			<div id="testSyu_error"></div>
			</td>
		</tr>
	</table><!-- 1 -->

	<br/>

	<!-- 2 -->
	<table id="table2" class="table1">

		<tr >
			<td rowspan="3" width="10"><b>結果通知</b></td>
			<th>学校宛</th>
			<td><input type="radio" name="toGa" value="1" />郵送
			<input type="radio" name="toGa" value="2" />TEL
			</td>

		</tr>

		<tr>
			<th>本人宛</th>
			<td><input type="radio" name="toGa" value="3" />郵送
			<input type="radio" name="toGa" value="4" />TEL</td>
		</tr>

		<tr>
			<th>日時</th>
			<td><input type="text" value="${JukenHoukokuInfo.tutiDate }" name="tutiDate" id="date_kekka"/>頃
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
			<td rowspan="2" width="10"><b>一般常識</b></td>

			<th>科目</th>
			<td><input type="checkbox" name="ippanKamoku" value="1" />国語
				<input type="checkbox" name="ippanKamoku" value="2" />数学
				<input type="checkbox" name="ippanKamoku" value="3" />社会
				<input type="checkbox" name="ippanKamoku" value="4" />英語
				<input type="checkbox" name="ippanKamoku" value="5" onclick="connecttext('ippanKamokuEtc',this.checked);"/>その他　<input type="text" name="ippanKamokuEtc" id="ippanKamokuEtc" disabled="disabled"/>
			</td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="ippanTime" value="${tn.jhitn.ippanTime}"/>分</td>
		</tr>

		<tr>
			<td rowspan="2" width="10"><b>専門科目</b></td>

			<th>科目</th>
			<td><input type="checkbox" name="senmonKamoku" value="1" />情報基礎
				<input type="checkbox" name="senmonKamoku" value="2" />流れ図
				<input type="checkbox" name="senmonKamoku" value="3" />コーディング
				<input type="checkbox" name="senmonKamoku" value="4" onclick="connecttext('senmonKamokuEtc',this.checked);"/>その他　<input type="text" name="senmonKamokuEtc" id="senmonKamokuEtc" disabled="disabled"/>
			</td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="senmonTime" value="${tn.jhitn.senmonTime}"/>分</td>
		</tr>

		<tr >
			<td rowspan="2" width="10"><b>その他</b></td>

			<th>科目</th>
			<td><input type="text" name="sonota" style="width:99%;" value="${JukenHoukokuInfo.sonota}"/></td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="sonoTime" value="${tn.jhitn.sonoTime}"/>分</td>
		</tr>
	</table><!-- 3 -->

	<!-- tableを分割 -->
	<!-- 4 -->
	<table id="table4" class="table0">

		<!-- 筆記試験 試験内容 -->
		<tr >
			<th>試験内容</th>
			<td><textarea name="sikenComment" cols="95" rows="15">${JukenHoukokuInfo.sikenComment}</textarea></td>
		</tr>

		<!-- 作文 -->
		<tr>
			<th colspan="2" height="5">作文</th>
		</tr>

		<tr >
			<th>テーマ名</th>
			<td><input type="text" name="theme" style="width:99%;" value="${JukenHoukokuInfo.theme}"/></td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="bunTime" size="2" value="${tn.jhitn.bunTime}"/>　分</td>
		</tr>

		<tr>
			<th>字数</th>
			<td><input type="text" name="bunRyo" size="2" value="${tn.jhitn.bunRyo}"/>　字</td>
		</tr>

		<tr>
			<th>完成度</th>
			<td><input type="text" name="kanseido" size="2" value="${tn.jhitn.kanseido}"/>　％</td>
		</tr>


		<!-- 適性検査 -->
		<tr>
			<th colspan="2" height="5">適性検査</th>
		</tr>

		<tr >
			<th>検査種類</th>
			<td><input type="checkbox" name="kensaSyu" value="1" />能力適性
				<input type="checkbox" name="kensaSyu" value="2" />職業適性
				<input type="checkbox" name="kensaSyu" value="3" />性格検査
				<input type="checkbox" name="kensaSyu" value="4" onclick="connecttext('kensaSyuEtc',this.checked);"/>その他　<input type="text" name="5" id="kensaSyuEtc"  disabled="disabled"/>
			</td>

		</tr>
		<tr>
			<th>検査時間</th>
			<td><input type="text" name="kensaTime" value="${tn.jhitn.kensaTime}"/>分</td>
		</tr>

		<tr>
			<th>検査内容</th>
			<td><textarea name="kensaComment" cols="95" rows="15">${JukenHoukokuInfo.kensaComment}</textarea></td>
		</tr>


		<!-- 面接試験 -->
		<tr>
			<th colspan="2" height="5">面接試験</th>
		</tr>

		<tr >
			<th>面接人数<br/>企業側</th>
			<td><input type="text" name="menNin1" size="2" value="${tn.jhitn.menNin1}"/>人</td>
		</tr>

		<tr>
			<th>面接人数<br/>受験者側</th>
			<td><input type="text" name="menNin2" size="2" value="${tn.jhitn.menNin2}"/>人（自分を含め）</td>
		</tr>

		<tr>
			<th>面接時間</th>
			<td><input type="text" name="menTime" size="2" value="${tn.jhitn.menTime}"/>　分</td>
		</tr>

		<tr>
			<th>面接形態</th>
			<td><input type="checkbox" name="menKatati" value="1" />個人面接
				<input type="checkbox" name="menKatati" value="2" />集団面接
				<input type="checkbox" name="menKatati" value="3" />グループ討議
				<input type="checkbox" name="menKatati" value="4" onclick="connecttext('menkatatiEtc',this.checked);"/>その他　<input type="text" name="menkatatiEtc" id="menkatatiEtc" size="40" disabled="disabled"/>
			</td>
		</tr>

		<tr>
			<th>企業側の<br/>質問内容</th>
			<td><textarea name="sitsuComment" cols="95" rows="15">${JukenHoukokuInfo.sitsuComment}</textarea></td>
		</tr>

		<tr>
			<th>反省点</th>
			<td><textarea name="hanseiComment" cols="95" rows="15">${JukenHoukokuInfo.hanseiComment}</textarea></td>
		</tr>


		<!-- 健康診断 -->
		<tr>
			<th colspan="2" height="5">健康診断</th>
		</tr>

		<tr >
			<th>検査内容</th>
			<td><textarea name="kenComment" cols="95" rows="15">${JukenHoukokuInfo.kenComment}</textarea></td>
		</tr>

		<!-- 助言 -->
		<tr>
			<th colspan="2" height="5">助言</th>
		</tr>

		<tr >
			<th>受験後の<br/>感想と<br/>後輩への<br/>助言</th>
			<td><textarea name="jogen" cols="95" rows="15">${JukenHoukokuInfo.jogen}</textarea></td>
		</tr>

	</table><!-- 4 -->


	<input type="submit" value="確 認" name="updateKakunin" />

	<input type="button" value="戻る" onclick="history.back()" />
</form>

</div>

</body>
</html>