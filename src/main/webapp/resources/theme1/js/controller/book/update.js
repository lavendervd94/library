
function updateBook(){
	$(".validation").remove();
	var name = $("#name").val();
	var category = $("#category").val();
	var author = $("#author").val();
	var price = $("#price").val();
	var id = $("#idBook").val();
	var flagValid;
	if(name == ""){
		 if ($("#name").parent().next(".validation").length == 0) // only add if not added
	        {
	            $("#name").parent().parent().after('<div class="validation" style="width: 1000px;height: 36px;"><label class="col-md-2 control-label" style="margin-top: 10px; margin-left: 100px"></label><div id "mes" class="col-md-4" style="margin-top: 10px;margin-left: 52px;">Error: Please enter name </div></div>');
	            $("#name").addClass("borderInput");
	        }
		flagValid = false;
	}
	if(author==""){
		if ($("#author").parent().next(".validation").length == 0) // only add if not added
        {
            $("#author").parent().parent().after('<div class="validation" style="width: 1000px;height: 36px;"><label class="col-md-2 control-label" style="margin-top: 10px; margin-left: 100px"></label><div id "mes" class="col-md-4" style="margin-top: 10px;margin-left: 52px;">Error: Please enter name </div></div>');
            $("#author").addClass("borderInput");
        }
		flagValid = false;
	}
	if(price==""){
		if ($("#price").parent().next(".validation").length == 0) // only add if not added
        {
            $("#price").parent().parent().after('<div class="validation" style="width: 1000px;height: 36px;"><label class="col-md-2 control-label" style="margin-top: 10px; margin-left: 100px"></label><div id "mes" class="col-md-4" style="margin-top: 10px;margin-left: 52px;">Error: Please enter name </div></div>');
            $("#price").addClass("borderInput");
        }
		flagValid = false;
	}
	if(flagValid){
		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : $("#contextPath").val() + "book/updateBook",
				data : {
					nameAjax : name,
					categoryAjax : category,
					authorAjax : author,
					priceAjax : price,
					id : id
				},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					if(data.success==true){
						window.location.href = $("#linkListScreen").val();
					}
				},
				error : function(e) {
				}
			}); 
	}
}