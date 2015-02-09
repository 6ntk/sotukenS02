/**
 * datatables
 */
$(document).ready(function(){
  $('#table1').dataTable({
	  "bFilter": false,

	  "oLanguage": {
	        "sLengthMenu": "表示行数 _MENU_ 件",
	        "oPaginate": {
	            "sNext": "次のページ",
	            "sPrevious": "前のページ"
	        },
	        "sInfo": "全_TOTAL_件中 _START_件から_END_件を表示",
	        "sSearch": "検索：",
	        "sEmptyTable":"見つかりませんでした",
	        "sInfoEmpty":""
	    }

  });

});


