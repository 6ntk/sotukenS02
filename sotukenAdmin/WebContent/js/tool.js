
//チェックボックス
function connecttext( textid, ischecked ) {

   if( ischecked == true ) {
      // チェックが入っていたら有効化
      document.getElementById(textid).disabled = false;
   }
   else {
      // チェックが入っていなかったら無効化
      document.getElementById(textid).disabled = true;
   }
}

//ラジオボタン
function changeDisabled() {
    if ( document.myform["nanji"][3].checked ) {
        document.myform["nanjiEtc"].disabled = false;
    } else {
        document.myform["nanjiEtc"].disabled = true;
    }
}

//でーとたいむぴっかー
$(function (){

	$('#date_from').datetimepicker();
	$('#date_to').datetimepicker();
	$('#date_kekka').datetimepicker();

});

//textarea初期値(textareaクリックすると消える奴)
function setupTextareaDes() {
    var textareas = document.getElementsByTagName("textarea");
    for (var i = 0; i < textareas.length; i++) {
        if (textareas[i].className != "nodes") {
            textareas[i].onfocus = function (event) { return TextareaDes(this); };
        }
    }
    return;
}
function TextareaDes(from) {
    from.className = "nodes";
    from.value = "";
    from.onfocus = function (event) {};// これ以降呼び出されないように、自殺。
    return;
}

//
$(function($) {
    $('tbody tr[data-href]').addClass('clickable').delegate('*', 'click', function() {
        if ( this.tagName !== 'A' ) {
            window.location = $(this).parents('tr').data('href');
        }
        return false;
    });
});

//テーブル
$(document).ready(function(){
  $('#table1').dataTable();
});
