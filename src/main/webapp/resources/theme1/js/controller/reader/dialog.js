var table;
$(document).ready(function() {
	table = $('#example').DataTable({
		"columnDefs" : [ {
			"targets" : [ 0 ],
			"visible" : false,
			"searchable" : false
		}, ]
	});
	$('#example tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
	$('#ok').on('click', function() {
		var data = table.rows('.selected').data();
		window.parent.zipData(data);
		window.parent.closeIframe();
	});
});
function searchReader() {
	var name = $("#name").val();
	var gender = $("input[name=gender]:checked").val();
	var address = $("#address").val();
	var phone = $("#phone").val();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url :  "searchReader",
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
				if (data[i].gender == 0) {
					data[i].gender = "Nam";
				} else if (data[i].gender == 1) {
					data[i].gender = "Nu";
				}
				var data_row = [data[i].id, data[i].name, data[i].gender, data[i].address,data[i].phone];
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
