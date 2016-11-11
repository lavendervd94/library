var table;
$(document).ready(function() {
	table = $('#example').DataTable();
});
function searchReader() {
	var name = $("#name").val();
	var gender = $("input[name=gender]:checked").val();
	var address = $("#address").val();
	var phone = $("#phone").val();
		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : $("#contextPath").val() + "reader/searchReader",
				data : {
					nameAjax : name,
					genderAjax : gender,
					addressAjax : address,
					phoneAjax : phone,
				},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					var data_set = [];
					for (var i = 0; i < data.length; i++) {
						if(data[i].gender==0){
							data[i].gender="Nam";
						}
						else if (data[i].gender==1){
							data[i].gender="Nu";
						}
						var button_edit = '<a class="btn-info btn-sm" href="/Library/reader/update/?id='+data[i].id+'"><span class="glyphicon glyphicon-pencil"></span></a>';
						var button_delete = '<a class="btn-info btn-sm" onclick="deleteReader('+data[i].id+');"><span class="glyphicon glyphicon-trash"></span></a>';
						var data_row = [ data[i].name, data[i].gender, data[i].address,data[i].phone ,button_edit,button_delete];
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

function deleteReader(id){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : $("#contextPath").val() + "reader/deleteReader",
		data : {
			id:id
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if(data.success){
				alert("Delete success");
				searchReader();
			}else{
				alert("Delete fail");
			}
		},
		error : function(e) {
		}
	});
	searchReader();
}