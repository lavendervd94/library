var table;
$(document).ready(function() {
	table = $('#return').DataTable();
});

function seachReturn() {
	var borrowId = $('#borrowId').val();
	var readerId = $('#readerId').val();
$.ajax({
		type : "GET",
		contentType : "application/json",
		url : $("#contextPath").val() + "return/seachReturn",
		data : {
			borrowIdAjax : borrowId,
			readerIdAjax : readerId
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data){
			var data_set = [];
			for (var i = 0; i < data.length; i++){
				var button_confrim;
				if(data[i].status == 1){
					data[i].status = 'OK'
					button_confrim = '<a class="btn-info btn-sm" href="#"><span class="glyphicon glyphicon-minus"></span></a>';
				}else{
					data[i].status = ' ---'
					button_confrim = '<a class="btn-info btn-sm" href="#"><span class="glyphicon glyphicon-ok"></span></a>';
				}
				var data_row = [ data[i].borrowID, data[i].nameReader,data[i].bookName,data[i].dataReturnReality,data[i].status,button_confrim];
				data_set.push(data_row);
			}
			table.clear();
			table.rows.add(data_set);
			table.draw();
		},
			error : function(e) {
		}
	});
}