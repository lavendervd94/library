<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<title>Add Borrow</title>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
	<input type="hidden" value="${MODE}" class="form-control" id="mode" name="mode">
	<input type="hidden" value="${id}" class="form-control" id="idBorrow" name="idBorrow">
	<input type="hidden" value="${listBookBorrow}" class="form-control" id="listBook" name="listBook">
	<input type="hidden" value='<c:url value="/borrow/list"></c:url>'class="form-control" id="linkListScreenBorrow">
	<input type="hidden" value="" class="form-control" id="idReader">
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-arrow-up"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> BORROW ENTRY</b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 40px;">Reader_Name:</label>
						<div class="col-md-5" style="margin-top: 10px; margin-left: 116px">
							<input type="text" class="form-control"
								value="${listBorrow.nameReader}" id="Name">
						</div>
						<ul class=""
							style="margin-top: 17px; margin-left: 500px; width: 290px; margin-top: 57px">
							<a type="button" class="modalButton btn-sm" data-toggle="modal"
								data-src="/Library/dialog/reader" data-height=500 data-width=860
								data-target="#myModal"> <span
								class="glyphicon glyphicon-search" style="margin-top: 8px"></span>
							</a>
						</ul>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
						<label for="address" class="col-xs-1 col-form-label"
							style="line-height: 30px; margin-left: 40px; margin-top: 6px">Date_Borrow:</label>
						<div class="container">
							<div class="col-md-5">
								<input type="text" class="form-control"
									style="margin-left: 28px; margin-top: 6px"
									value="${listBorrow.dateBorrow}"
									placeholder="click to show datepicker" id="date_borrow">
							</div>
						</div>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
						<label for="address" class="col-xs-1 col-form-label"
							style="line-height: 30px; margin-left: 40px">Date_Return:</label>
						<div class="container">
							<div class="col-md-5">
								<input type="text" class="form-control"
									style="margin-left: 28px" value="${listBorrow.dateReturn}"
									placeholder="click to show datepicker" id="date_return">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-12"
			style="margin-top: 5px; background-color: rgba(227, 231, 239, 0.34); border: 1px solid rgba(0, 0, 0, 0.08); height: 50px">
			<div style="margin-top: 10px; margin-left: 5px; margin-bottom: 20px">
				<span class="glyphicon glyphicon-list"
					style="color: red; font-size: 25px;"></span> <b
					style="font-size: 23px; margin-left: 5px"> BOOK LIST</b> <a
					type="button" class="bookModal btn-info btn-sm" data-toggle="modal"
					data-src="/Library/dialog/book" data-height=500 data-width=860
					data-target="#bookModal" style="width: 150px; margin-left: 856px"><span
					class="glyphicon glyphicon-arrow-up"></span>Book Borrow </a>
			</div>
			<table id="example" class="display" width="95%">
				<thead>
						<tr>
							<th>Id</th>
							<th>Book_Name</th>
							<th>Category</th>
							<th>Author</th>
							<th>Price</th>
							<th>Remove</th>
						</tr>
				</thead>
					<c:if test="${MODE =='EDIT'}">
						<c:forEach items="${listBookBorrow}" var="bookBorrow">
							<tr>
								<td>${bookBorrow.id}</td>
								<td>${bookBorrow.name}</td>
								<td>${bookBorrow.category}</td>
								<td>${bookBorrow.author}</td>
								<td>${bookBorrow.price}</td>
								<td><a class="btn-info btn-sm" id="removeBook"><span class="glyphicon glyphicon-remove"></span></a></td>
							</tr>
						</c:forEach>  
					</c:if>
			</table>
			<div style="margin-top: 18px; margin-left: 92.3%;">
				<a class="btn-info btn-sm" href="#" onclick="updateBorrow()"><span class="glyphicon glyphicon-plus"></span>
					<c:if test="${MODE=='EDIT'}"> 
						EDIT
					</c:if> 
					<c:if test="${MODE =='NEW'}">
 						NEW
					</c:if>
				</a>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/template/modal.jsp"%>
</body>
<script src="<c:url value="/resources/js/controller/borrow/update.js" />"></script>
</html>