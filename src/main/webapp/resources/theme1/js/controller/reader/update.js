function updateReaderByID() {
	var name = $("#name").val();
	var gender = $("input[name=gender]:checked").val();
	var address = $("#address").val();
	var phone = $("#phone").val();
	var id = $("#idReader").val();
	var flagValid = true;
	if(name==""){
		flagValid = false;
		alert("Name is required")
	}
	else if(gender==""){
		flagValid = false;
		alert("Gender is required")
	}
	else if(address==""){
		flagValid = false;
		alert("Address is required")
	}
	else if(phone==""||phone.length>11||phone.length<10){
		flagValid = false;
		alert("phone number must be 10 to 11 characters")
	}
	if(flagValid){
		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : $("#contextPath").val() + "reader/updateReader",
				data : {
					name : name,
					gender : gender,
					address : address,
					phone: phone,
					id : id
				},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					if(data.success==true){
						window.location.href = $("#linkListScreenReader").val();
					}
				},
				error : function(e) {
				}
			});
	}
}