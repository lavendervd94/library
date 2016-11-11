 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<title>Book Dialog</title>
<body>
<input type="hidden" value='${data}' id ="arrBook">
	<form class="form-horizontal" role="form">
		<div class="form-group row"
			style="height: 50px; margin: 0 auto; margin-top: 20px">
			<label for="name" class="col-xs-1 col-form-label"
				style="line-height: 30px">Name:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="name">
			</div>
			<label for="category" class="col-xs-1 col-form-label"
				style="line-height: 30px">Category:</label>
			<div class="col-xs-4">
				<select class="form-control" id="category" name="category">
					<option></option>
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.c_name}">${category.c_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group row"
			style="height: 50px; margin: 0 auto; margin-top: 20px">
			<label for="address" class="col-xs-1 col-form-label"
				style="line-height: 30px">Author:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="author">
			</div>
			<label for="phone" class="col-xs-1 col-form-label"
				style="line-height: 30px">Price:</label>
			<div class="col-xs-4">
				<input class="form-control" type="text" id="price">
			</div>
			<a onclick="searchBook()" class="btn-info btn-sm" href="#"><span
				class="glyphicon glyphicon-search"></span></a>
		</div>
	</form>
	<table id="dataBook" class="display" width="95%" style="">
		<thead>
			<tr>
				<th width=3%>Select</th>
				<th>Name</th>
				<th>Category</th>
				<th>Author</th>
				<th>Price</th>
				<th>id</th>
			</tr>
		</thead>
	</table>
	<div class="modal-footer">
		<button type="button" id="ok" class="btn-primary">OK</button>
	</div>
</body>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<script src="<c:url value="/resources/js/controller/book/dialog.js" />"></script>
</html>