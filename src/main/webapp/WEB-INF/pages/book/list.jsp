<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<title>Book List</title>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<script src="<c:url value="/resources/js/controller/book/list.js" />"></script>
<style>
#ajax-response {
	text-align: center;
	margin-left: 20px;
	border: 1px solid black;
	margin-bottom: 10px;
	padding-bottom: 20px;
}
</style>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
	<input type="hidden" value='<c:url value="/book/list"></c:url>'
		class="form-control" id="linkListScreen">
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-book"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> BOOK </b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 12px;">Name:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 72px">
							<input type="text" class="form-control" id="name" name="name">
						</div>
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 5px;">Price:</label>
						<div class="col-md-3" style="margin-top: 10px; margin-left: 78px">
							<input type="number" class="form-control" id="price" name="price">
						</div>
					</div>
					<div class="form-group"
						style="width: 1000px; height: 50px; margin-left: 11px">
						<label class="col-md-1 control-label" style="margin-top: 10px">Author:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 62px">
							<input type="text" class="form-control" id="author" name="author">
						</div>
						<label class="col-md-2 control-label"
							style="margin-top: 10px; padding-right: 62px">Category:</label>
						<div class="col-md-3" style="margin-top: 10px;">

							<select class="form-control" id="category" name="category">
								<option></option>
								<c:forEach items="${listCategory}" var="category">
									<option value="${category.c_name}">${category.c_name}</option>
								</c:forEach>
							</select>
						</div>
						<ul class=""
							style="margin-top: 17px; margin-left: 970px; width: 290px;">
							<a class="btn-info btn-sm" id="search" onclick="searchBook()"><span
								class="glyphicon glyphicon-search"></span>Search</a>
						</ul>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-12"
			style="margin-top: 5px; background-color: rgba(227, 231, 239, 0.34); border: 1px solid rgba(0, 0, 0, 0.08); height: 50px">
			<div style="margin-top: 10px; margin-left: 5px; margin-bottom: 20px">
				<span class="glyphicon glyphicon-list"
					style="color: red; font-size: 25px;"></span> <b
					style="font-size: 23px; margin-left: 5px"> DATA LIST</b>
			</div>
			<table id="example" class="display" width="95%" style="">
				<thead>
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Author</th>
						<th>Price</th>
						<th width="7%%">Edit</th>
						<th width="7%">Delete</th>
					</tr>
				</thead>
				<%-- 				<c:forEach items="${bookList}" var="book"> --%>
				<%-- 						<td>${book.getName()}</td> --%>
				<%-- 						<td>${book.getCategory()}</td> --%>
				<%-- 						<td>${book.getAuthor()}</td> --%>
				<%-- 						<td>${book.getPrice()}</td> --%>
				<%-- 				</c:forEach>  --%>
			</table>
			<a class="btn-info btn-sm" id="" href="/Library/book/update"
				style="margin-left: 3px; margin-left: 87.5%"><span
				class="glyphicon glyphicon-plus"></span> Add Book</a>
		</div>
	</div>
</body>
</html>