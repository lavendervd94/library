var table;
$(document).ready(function() {
	table = $('#example').DataTable();
});
function searchBook() {
	var name = $("#name").val();
	var category = $("#category").val();
	var author = $("#author").val();
	var price = $("#price").val();
		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : $("#contextPath").val() + "book/searchBook",
				data : {
					nameAjax : name,
					categoryAjax : category,
					authorAjax : author,
					priceAjax : price,
				},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					var data_set = [];
					for (var i = 0; i < data.length; i++) {
						var button_edit = '<a class="btn-info btn-sm" href="/Library/book/update/?id='+data[i].id+'"><span class="glyphicon glyphicon-pencil"></span></a>';
						var button_delete = '<a class="btn-info btn-sm" onclick="deleteBook('+data[i].id+');"><span class="glyphicon glyphicon-trash"></span></a>';
						var data_row = [ data[i].name,data[i].category, data[i].author,data[i].price,button_edit,button_delete];
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
function deleteBook(id){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url :"deleteBook",
		data : {
			id:id
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if(data.success){
				alert("Delete success");
				searchBook();
			}else{
				alert("Delete fail");
			}
		},
		error : function(e) {
		}
	});
}