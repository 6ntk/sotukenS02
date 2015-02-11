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
	        "sLoadingRecords":"読み込み中...",
	        "sProcessing":"読み込み中..."
	  },
	  "bFilter":false,
	  "bProcessing":false,
	  "dom": 'Rlfrtip',
	  "pagingType": "full_numbers",
	 bLengthChange:false,
	 bPaginate:false,
	 bSort:false,
	 bInfo:false
  });
});