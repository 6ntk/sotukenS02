/**
 * datatable
 */
$(document).ready(function(){
  $('#table1').dataTable({
	  "oLanguage": {
	        "sLengthMenu": "表示行数 _MENU_ 件",
	        "oPaginate": {
		        "sNext": "次のページ",
		        "sPrevious": "前のページ",
		        "sFirst":"先頭",
		        "sLast":"末尾"
	        },
	        "sInfo": "全_TOTAL_件中 _START_件から_END_件を表示",
	        "sInfoEmpty":"全0件中 0件を表示",
	        "sEmptyTable " : "データが登録されていません。",
	        "sZeroRecords" : "該当するデータが見つかりませんでした。",

	  },
	  "bFilter":false,
	  "bProcessing":true,
	  "dom": 'Rlfrtip',
	  "pagingType": "full_numbers"
  });
});