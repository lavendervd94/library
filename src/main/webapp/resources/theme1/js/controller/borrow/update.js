var table;
var data_set = [];
var checkMode = $('#mode').val();
$(document).ready(function() {
	table = $('#example').DataTable({
		"columnDefs" : [ {
			"targets" : [ 0 ],
			"visible" : false,
			"searchable" : false
		}, ]
	});
});

$('#date_borrow').datepicker({
	format : "yyyy/mm/dd"
});

$('#date_return').datepicker({
	format : "yyyy/mm/dd"
});

$('#example').on('click', '#removeBook', function() {
	table.row($(this).parents('tr')).remove().draw();
});

$('a.modalButton').on('click', function(e) {
	var src = $(this).attr('data-src');
	var height = $(this).attr('data-height') || 300;
	var width = $(this).attr('data-width') || 400;
	$("#myModal iframe").attr({
		'src' : src,
		'height' : height,
		'width' : width
	});
});

$('a.bookModal').on('click', function(e) {
	var dataArr = [];
	var data = table.rows().data();
	for (var i = 0; i < data.length; i++) {
		var dataObject = {};
		dataObject.id = data[i][0];
		dataObject.name = data[i][1];
		dataObject.category = data[i][2];
		dataObject.author = data[i][3];
		dataObject.price = data[i][4];
		dataArr.push(dataObject);
	}
	var dataString = JSON.stringify(dataArr);
	var src = $(this).attr('data-src');
	var height = $(this).attr('data-height') || 300;
	var width = $(this).attr('data-width') || 400;
	$("#bookModal iframe").attr({
		'src' : src + "?data=" + dataString,
		'height' : height,
		'width' : width,
	});
});

function zipData(data) {
	((console && console.log) || alert)("Ten = " + data[0][0]);
	var name = data[0][1];
	var id = data[0][0];
	$('#Name').val(name);
	$('#idReader').val(id);
}

function sendData(data_send) {
	var data = table.rows().data();
	for (var i = 0; i < data_send.length; i++) {
		var button_remove = '<a class="btn-info btn-sm" id="removeBook" onclick="removeBookBorrow('+ data_send[i].id + ')"><span class="glyphicon glyphicon-remove"></span></a>';
		var data_row = [ data_send[i].id, data_send[i].name, data_send[i].category, data_send[i].author, data_send[i].price, button_remove ]
		data_set.push(data_row);
	}
	table.clear();
	if (checkMode == "EDIT") {
		table.rows.add(data);
	}
	table.rows.add(data_set);
	table.draw();
	data_set = [];
}

function closeIframe() {
	$("[data-dismiss=modal]").trigger({
		type : "click"
	});
}
function updateBorrow() {
	var data = table.rows().data();
	var listIDBook = [];
	for (var i = 0; i < data.length; i++) {
		var data_row = {};
		data_row.id = data[i][0];
		listIDBook.push(data_row);
	}
	var listIdBookSent = JSON.stringify(listIDBook);
	var idBorrow = $('#idBorrow').val();
	var idReader = $("#idReader").val();
	var nameReader = $("#Name").val();
	var date_borrow = $("#date_borrow").val();
	var date_return = $("#date_return").val();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : $("#contextPath").val() + "borrow/updateBorrow",
		data : {
			listIdBookSentAjax : listIdBookSent,
			idReaderAjax : idReader,
			dateBorrowAjax : date_borrow,
			dateReturnAjax : date_return,
			checkModeAjax : checkMode,
			nameReaderAjax : nameReader,
			idBorrowAjax : idBorrow
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if (data.success == true) {
				window.location.href = $("#linkListScreenBorrow").val();
			}
		},
		error : function(e) {
		}
	});
}