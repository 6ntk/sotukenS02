/**
 * チェックとラジオボタンの引継ぎ
 */

$(document).ready(function(){

	switch (nanji){
		 case "1":
			document.myform["nanji"][0].checked = true;
		break;
		case "2":
			document.myform["nanji"][1].checked = true;
		break;
		case "3":
			document.myform["nanji"][2].checked = true;
		break;
		default:
			document.myform["nanji"][3].checked = true;
			document.myform.nanjiEtc.value = nanji;
			document.myform["nanjiEtc"].disabled = false;
	    break;
	}

	switch (toGa){
		case "学校宛　郵送":
			document.myform["toGa"][0].checked = true;
		break;
		case "学校宛　TEL":
			document.myform["toGa"][1].checked = true;
		break;
		case "個人宛　郵送":
			document.myform["toGa"][2].checked = true;
		break;
		case "個人宛　TEL":
			document.myform["toGa"][3].checked = true;
		break;
	}

	var i = 0;
	while(testSyu[i] != null){

		switch(testSyu[i]){
		case "筆記":
			document.myform["testSyu"][0].checked = true;
			break;
		case "作文":
			document.myform["testSyu"][1].checked = true;
			break;
		case "適性":
			document.myform["testSyu"][2].checked = true;
			break;
		case "面接":
			document.myform["testSyu"][3].checked = true;
			break;
		default :
			document.myform["testSyu"][4].checked = true;
			document.myform.testSyuEtc.value = testSyu[i];
			document.myform["testSyuEtc"].disabled = false;
			break;
		}
		i++;
	}
	var i = 0;
	while(testSyu[i] != null){

		switch(ippanKamoku[i]){
		case "国語":
			document.myform["ippanKamoku"][0].checked = true;
			break;
		case "数学":
			document.myform["ippanKamoku"][1].checked = true;
			break;
		case "社会":
			document.myform["ippanKamoku"][2].checked = true;
			break;
		case "英語":
			document.myform["ippanKamoku"][3].checked = true;
			break;
		default :

			if(typeof ippanKamoku[i] == "string" && ippanKamoku[i] != null && ippanKamoku[i] !="null"){
				alert(ippanKamoku[i]);
				document.myform["ippanKamoku"][4].checked = true;
				document.myform.ippanKamokuEtc.value = ippanKamoku[i];
				document.myform["ippanKamokuEtc"].disabled = false;
			}
			break;
		}
		i++;
	}

	var i = 0;
	while(senmonKamoku[i] != null){

		switch(senmonKamoku[i]){
		case "情報基礎":
			document.myform["senmonKamoku"][0].checked = true;
			break;
		case "流れ図":
			document.myform["senmonKamoku"][1].checked = true;
			break;
		case "コーディング":
			document.myform["senmonKamoku"][2].checked = true;
			break;
		default :
			if(typeof senmonKamoku[i] == "string" && senmonKamoku[i] != null && senmonKamoku[i] !="null"){
				document.myform["senmonKamoku"][3].checked = true;
				document.myform.senmonKamokuEtc.value = senmonKamoku[i];
				document.myform["senmonKamokuEtc"].disabled = false;
			}
			break;
		}
		i++;
	}

	var i = 0;
	while(kensaSyu[i] != null){

		switch(kensaSyu[i]){
		case "能力適性":
			document.myform["kensaSyu"][0].checked = true;
			break;
	   case "職業適性":
			document.myform["kensaSyu"][1].checked = true;
			 break;
		case "性格検査":
			document.myform["kensaSyu"][2].checked = true;
			break;
		default :
			if(typeof kensaSyu[i] == "string" && kensaSyu[i] != null && kensaSyu[i] !="null"){
				document.myform["kensaSyu"][3].checked = true;
				document.myform.kensaSyuEtc.value = kensaSyu[i];
				document.myform["kensaSyuEtc"].disabled = false;
			}
			break;
		}
		i++;
	}

	var i = 0;
	while(menKatati[i] != null){

		switch(menKatati[i]){
		case "個人面接":
			document.myform["menKatati"][0].checked = true;
			 break;
		case "集団面接":
			document.myform["menKatati"][1].checked = true;
			break;
		case "グループ討議 ":
			document.myform["menKatati"][2].checked = true;
			break;
		default :
			if(typeof menKatati[i] == "string" && menKatati[i] != null && menKatati[i] !="null"){
				document.myform["menKatati"][3].checked = true;
				document.myform.menKatatiEtc.value = menKatati[i];
				document.myform["menKatatiEtc"].disabled = false;
			}
			break;
		}
			i++;
	}
});