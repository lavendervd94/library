<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Reader Dialog</title>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<body>
	<form class="form-horizontal" role="form">
		<div class="form-group row"
			style="height: 50px; margin: 0 auto; margin-top: 20px">
			<label for="name" class="col-xs-1 col-form-label"
				style="line-height: 30px">Name:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="name">
			</div>
			<label for="gender" class="col-xs-1 col-form-label"
				style="line-height: 30px">Gender:</label>
			<div class="col-xs-4">
				<input type="radio" name="gender" value="0" > Male
				<input type="radio" name="gender" value="1"> Female
			</div>
		</div>
		<div class="form-group row"
			style="height: 50px; margin: 0 auto; margin-top: 20px">
			<label for="address" class="col-xs-1 col-form-label"
				style="line-height: 30px">Address:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="address">
			</div>
			<label for="phone" class="col-xs-1 col-form-label"
				style="line-height: 30px">Phone:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="phone">
			</div>
			<a onclick="searchReader()" class="btn-info btn-sm" href="#"><span
				class="glyphicon glyphicon-search"></span></a>
		</div>
	</form>
	<table id="example" class="display" width="95%" style="">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Phone</th>
			</tr>
		</thead>
	</table>
	<div class="modal-footer">
		<button type="button" id="ok" class="btn-primary">OK</button>
	</div>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>	
</body>
<script
	src="<c:url value="/resources/js/controller/reader/dialog.js" />"></script>
</html>