var table;
var arrBook = JSON.parse($('#arrBook').val());
$(document).ready(function() {
    var arrBook = JSON.parse($('#arrBook').val());
    table = $('#dataBook').DataTable( {
        "columnDefs": [
            {
                "targets": [ 5 ],
                "visible": false,
                "searchable": false
            },
        ]
    } );

    $('#ok').on('click', function() {
        var data_send = [];
        var data_select = table.rows('.selected').data();
        for (var i = 0; i < data_select.length; i++) {
            var row = {};
            row.id = data_select[i][5];
            row.name = data_select[i][1];
            row.category = data_select[i][2];
            row.author = data_select[i][3];
            row.price = data_select[i][4];
            data_send.push(row);
        }
        window.parent.sendData(data_send);
        window.parent.closeIframe();
    });
    addListenerCheckbox();
});

function isInListBook(data) {
    if(arrBook==""){
        return false;
    }
    var flag = false;
    for (var i = 0; i < arrBook.length; i++) {
        if ((data.id) == arrBook[i].id) {
            flag = true;
        }
    }
    return flag;
}

function searchBook() {
    var name = $("#name").val();
    var category = $("#category").val();
    var author = $("#author").val();
    var price = $("#price").val();
    var id = arrBook.id;
$.ajax({
        type : "GET",
        contentType : "application/json",
        url : "searchBook",
        data : {
            nameAjax : name,
            categoryAjax : category,
            authorAjax : author,
            priceAjax : price,
            idAjax : id,
        },
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            var data_row;
            var data_set = [];
            for (var i = 0; i < data.length; i++) {
                var checkbox;
                if (isInListBook(data[i]) == true) {
                    checkbox = '<input type="checkbox" class="selected_checkbox" checked >';
                    data_row = [ checkbox, data[i].name,data[i].category, data[i].author,data[i].price,data[i].id];
                    data_set.push(data_row);
                } else {
                    checkbox = '<input type="checkbox" class="selector" >';
                    data_row = [ checkbox, data[i].name,data[i].category, data[i].author,data[i].price,data[i].id];
                    data_set.push(data_row);
                }
            }
            table.clear();
            table.rows.add(data_set);
            table.draw();
            addListenerCheckbox();
            $(".selected_checkbox").closest("tr").addClass("gray");
            $(".selected_checkbox").click(enable_cb);
        },
        error : function(e) {
        }
    });
}

function enable_cb() {
     if (this.checked) {
         $("input.selected_checkbox").prop("disabled", true);
     } else {
         $("input.selected_checkbox").prop("disabled", false);
     }
}

function addListenerCheckbox() {
    $('.selector').on('click', function() {
        $(this).closest("tr").toggleClass("selected");
    })
}