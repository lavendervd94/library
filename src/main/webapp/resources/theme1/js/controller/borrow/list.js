var table;
$(document).ready(function() {
	table = $('#example').DataTable({
	});
});

$('#dateBorrow').datepicker({
	format : "yyyy/mm/dd"
});

$('#dateReturn').datepicker({
	format : "yyyy/mm/dd"
});

function searchBorrow() {
	var nameReader = $("#nameReader").val();
	var dateBorrow = $("#dateBorrow").val();
	var dateReturn = $("#dateReturn").val();
$.ajax({
		type : "GET",
		contentType : "application/json",
		url : $("#contextPath").val() + "borrow/searchBorrow",
		data : {
			nameReaderAjax : nameReader,
			dateBorrowAjax : dateBorrow,
			dateReturnAjax : dateReturn,
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data){
			var data_set = [];
			for (var i = 0; i < data.length; i++){
				var button_edit = '<a class="btn-info btn-sm" href="/Library/borrow/update/?id='+data[i].id+'"><span class="glyphicon glyphicon-pencil"></span></a>';
				var button_delete = '<a class="btn-info btn-sm" onclick="deleteBorrow('+data[i].id+');"><span class="glyphicon glyphicon-trash"></span></a>';
				var data_row = [ data[i].id, data[i].nameReader,data[i].phone,data[i].dateBorrow,data[i].dateReturn,button_edit,button_delete];
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

function deleteBorrow(id){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : $("#contextPath").val() + "borrow/deleteBorrow",
		data : {
			id:id
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if(data.success){
				alert("Delete success");
				searchBorrow();
			}else{
				alert("Delete fail");
			}
		},
		error : function(e) {
		}
	});
}