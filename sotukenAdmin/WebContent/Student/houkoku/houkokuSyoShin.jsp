<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- <script type="text/javascript" src="/sotukenAdmin/js/jquery-2.1.1.min.js"></script> -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery-1.11.0.min.js"></script>
<!-- datetimepicker -->
<script src="/sotukenAdmin/js/jquery.datetimepicker.js"></script>
<!-- tool -->
<script type="text/javascript" src="/sotukenAdmin/js/tool.js"></script>
<script type="text/javascript" src="/sotukenAdmin/js/toolValidate.js"></script>
<!-- validate -->
<script type="text/javascript" src="/sotukenAdmin/js/jquery.validate.min.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/sotukenAdmin/css/form.css"/>
<link rel="stylesheet" href="/sotukenAdmin/css/jquery.datetimepicker.css" />

<title>受験報告書</title>
</head>
<body onload="setupTextareaDes();">

<%@include file="../../menu/student_menu.jsp" %>

<h1>受験報告書 入力</h1>

<div id="wrapper">

<form action="/sotukenAdmin/StudentServlet" method="post" id="myform" name="myform">

	<!-- 出席番号、性別、名前 -->
	<table id="studentInfo" class="table1">

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
			<td>${km.ui.name}</td>
		</tr>
	</table>

	<br/>

	<!-- 1 -->
	<table id="table1" class="table1">

		<tr >
			<td rowspan="2" width="10"><b>受験先</b></td>
			<th>企業名</th>
			<td>${km.ki.kigyoName}</td>
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
			<input type="radio" name="nanji" value="4"  onclick="changeDisabled()"/>その他<input type="text" name="nanjiEtc" style="width:15%"/>
			<br/>(必須項目)

			<!-- エラー表示場所 -->
			<div id="nanji_error"></div>
			</td>
		</tr>

		<tr>
			<th>実施日</th>
			<td>
			開始：<input type="text" value="" name="dateFrom"  id="date_from" style="width: 25%"/>
			終了：<input type="text" value="" name="dateTo"  id="date_to" style="width: 25%"/>
			<br/>(必須項目)

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
			<input type="checkbox" name="testSyu" value="5" onclick="connecttext('testSyuEtc',this.checked);"/>その他<input type="text" name="testSyuEtc" id="testSyuEtc" disabled="disabled" style="width:30%"/>
			<br/>(必須項目)

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
			<input type="radio" name="toGa" value="4" />TEL
			</td>
		</tr>

		<tr>
			<th>日時</th>
			<td><input type="text" value="" name="tutiDate"  id="date_kekka" style="width: 25%" />頃
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

		<!-- 一般常識 -->
		<tr >
			<td rowspan="2" width="10"><b>一般常識</b></td>
			<th>科目</th>
			<td><input type="checkbox" name="ippanKamoku" value="1" />国語
				<input type="checkbox" name="ippanKamoku" value="2" />数学
				<input type="checkbox" name="ippanKamoku" value="3" />社会
				<input type="checkbox" name="ippanKamoku" value="4" />英語
				<input type="checkbox" name="ippanKamoku" value="5" onclick="connecttext('ippanKamokuEtc',this.checked);"/>その他<input type="text" name="ippanKamokuEtc" id="ippanKamokuEtc" disabled="disabled" style="width:30%"/>
			</td>
		</tr>
		<tr>
			<th>時間</th>
			<td><input type="text" name="ippanTime"  style="width:10%"/>分</td>
		</tr>

		<!-- 専門科目 -->
		<tr>
			<td rowspan="2" width="10"><b>専門科目</b></td>
			<th>科目</th>
			<td><input type="checkbox" name="senmonKamoku" value="1" />情報基礎
				<input type="checkbox" name="senmonKamoku" value="2" />流れ図
				<input type="checkbox" name="senmonKamoku" value="3" />コーディング
				<input type="checkbox" name="senmonKamoku" value="4" onclick="connecttext('senmonKamokuEtc',this.checked);"/>その他<input type="text" name="senmonKamokuEtc" id="senmonKamokuEtc" disabled="disabled" style="width:30%"/>
			</td>
		</tr>
		<tr>
			<th>時間</th>
			<td><input type="text" name="senmonTime"  style="width:10%"/>分</td>
		</tr>

		<!-- その他 -->
		<tr >
			<td rowspan="2" width="10"><b>その他</b></td>
			<th>科目</th>
			<td><input type="text" name="sonota" style="width:99%"/></td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="sonoTime"  style="width:10%"/>分</td>
		</tr>
	</table><!-- 3 -->

	<!-- tableを分割 -->
	<!-- 4 -->
	<table id="table4" class="table0">

		<!-- 筆記試験 試験内容 -->
		<tr >
			<th>試験内容</th>
			<td><textarea name="sikenComment" cols="95" rows="10"></textarea></td>
		</tr>

		<!-- 作文 -->
		<tr>
			<th colspan="2" height="5">作文</th>
		</tr>

		<tr >
			<th>テーマ名</th>
			<td><input type="text" name="theme"  style="width:99%"/></td>
		</tr>

		<tr>
			<th>時間</th>
			<td><input type="text" name="bunTime"  style="width:10%"/>　分</td>
		</tr>

		<tr>
			<th>字数</th>
			<td><input type="text" name="bunRyo"  style="width:10%"/>　字</td>
		</tr>

		<tr>
			<th>完成度</th>
			<td><input type="text" name="kanseido"  style="width:10%"/>　％</td>
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
				<input type="checkbox" name="kensaSyu" value="4" onclick="connecttext('kensaSyuEtc',this.checked);"/>その他<input type="text" name="5" id="kensaSyuEtc"  disabled="disabled" style="width:30%" />
			</td>

		</tr>
		<tr>
			<th>検査時間</th>
			<td><input type="text" name="kensaTime"  style="width:10%" />分</td>
		</tr>

		<tr>
			<th>検査内容</th>
			<td><textarea name="kensaComment" cols="95" rows="10"></textarea></td>
		</tr>


		<!-- 面接試験 -->
		<tr>
			<th colspan="2" height="5">面接試験</th>
		</tr>

		<tr >
			<th>面接人数<br/>企業側</th>
			<td><input type="text" name="menNin1"  style="width:10%"/>人</td>
		</tr>

		<tr>
			<th>面接人数<br/>受験者側</th>
			<td><input type="text" name="menNin2"  style="width:10%"/>人（自分を含め）</td>
		</tr>

		<tr>
			<th>面接形態</th>
			<td><input type="checkbox" name="menKatati" value="1" />個人面接
				<input type="checkbox" name="menKatati" value="2" />集団面接
				<input type="checkbox" name="menKatati" value="3" />グループ討議
				<input type="checkbox" name="menKatati" value="4" onclick="connecttext('menkatatiEtc',this.checked);"/>その他<input type="text" name="menkatatiEtc" id="menkatatiEtc" disabled="disabled" style="width:10%"/>
			</td>
		</tr>

		<tr>
			<th>面接時間</th>
			<td><input type="text" name="menTime"  style="width:10%"/>分</td>
		</tr>


		<tr>
			<th>企業側の<br/>質問内容</th>
			<td><textarea name="sitsuComment" cols="95" rows="10"></textarea></td>
		</tr>

		<tr>
			<th>反省点</th>
			<td><textarea name="hanseiComment" cols="95" rows="10">(必須項目)</textarea></td>
		</tr>


		<!-- 健康診断 -->
		<tr>
			<th colspan="2" height="5">健康診断</th>
		</tr>

		<tr >
			<th>検査内容</th>
			<td><textarea name="kenComment" cols="95" rows="10"></textarea></td>
		</tr>

		<!-- 助言 -->
		<tr>
			<th colspan="2" height="5">助言</th>
		</tr>

		<tr >
			<th>受験後の<br/>感想と<br/>後輩への<br/>助言</th>
			<td><textarea name="jogen" cols="95" rows="10">(必須項目)</textarea></td>
		</tr>

	</table><!-- 4 -->

	<!-- ボタン -->
	<input type="submit" value="確 認" name="insertKakunin" />
	<input type="button" value="戻 る" onclick="history.back()" />

</form>

</div>

</body>
</html>