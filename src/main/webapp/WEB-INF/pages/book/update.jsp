<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<title>Book Update</title>
<style>
.validation
    {
      color: red;
    }
.borderInput
    {
      border-color: red;
    }
</style>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<script src="<c:url value="/resources/js/controller/book/update.js" />"></script>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<input type="hidden" value="${MODE}" class="form-control" id="mode"
				name="mode"> <input type="hidden" value="${id}"
				class="form-control" id="idBook" name="idBook"> <input
				type="hidden" value='<c:url value="/book/list"></c:url>'
				class="form-control" id="linkListScreen">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-book"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> BOOK ENTRY</b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-2 control-label"
							style="margin-top: 10px; margin-left: 100px"> Name: </label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 52px">
							<input type="text" value="${mapBookInfo.name}"
								class="form-control" id="name" name="name">
						</div>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
						<label class="col-md-2 control-label" style="margin-top: 10px; margin-left: 108px"> Author: </label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 45px">
							<input type="text" value="${mapBookInfo.author}"
								class="form-control" id="author" name="author">
						</div>
					</div>
					<div class="form-group"
						style="width: 1000px; height: 50px; margin-left: 109px">
						<label class="col-md-2 control-label" style="margin-top: 10px">
							Category: </label>
						<div class="col-md-3" style="margin-top: 10px; margin-left: 33px">
							<select class="form-control" name="category" id="category"
								name="category">
								<c:forEach items="${listCategory}" var="category">
									<option value="${category.c_name}">${category.c_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group"
						style="width: 1000px; height: 50px; margin-left: 86px">
						<label class="col-md-2 control-label" style="margin-top: 10px;">Price:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 56px">
							<input type="number" value="${mapBookInfo.price}"
								class="form-control" id="price" name="price">
						</div>
					</div>
					<ul class=""
						style="margin-top: 30px; margin-left: 528px; width: 290px; margin-bottom: 30px">
						<a class="btn-info btn-sm" id="updateBook" onclick="updateBook();"><span
							class="glyphicon glyphicon-ok"></span> <c:if
								test="${MODE=='EDIT'}">
 							EDIT
						</c:if> <c:if test="${MODE =='NEW'}">
 							NEW
						</c:if> </a>
					</ul>
				</form>
				
			</div>
		</div>
	</div>
</body>

</html>