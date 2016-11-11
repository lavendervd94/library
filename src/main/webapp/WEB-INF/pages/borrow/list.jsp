<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/template/header.jsp" %>
<title>Borrow List</title>
<%@ include file="/WEB-INF/pages/template/script.jsp" %>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
	<input type="hidden" value='<c:url value="/book/list"></c:url>'
			class="form-control" id="linkListScreenBorrow">
		
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-arrow-up"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> BORROW </b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label" style="margin-top: 10px; margin-left: 40px;">Reader_Name:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 50px">
							<input type="text" class="form-control" id="nameReader" name="nameReader">
						</div>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
					<label for="address" class="col-xs-1 col-form-label" style="line-height: 30px;margin-left:40px;margin-top:6px">Date_Borrow:</label>
						<div class="col-md-3">
							<input type="text" class="form-control" style = "margin-left:50px; margin-top:6px" placeholder="click to show datepicker" id="dateBorrow" name="dateBorrow">
						</div>
					<label for="address" class="col-xs-1 col-form-label" style="line-height: 30px ;margin-left:70px">Date_Return:</label>
						<div class="col-md-3" >
							<input type="text"  class="form-control" style = "margin-left:28px; margin-top: 5px;"placeholder="click to show datepicker" id="dateReturn" name="dateReturn">
						</div>
						<ul class="" style="margin-top: 17px; margin-left: 970px; width: 290px;">
							<a class="btn-info btn-sm" id="search" onclick="searchBorrow()"><span
								class="glyphicon glyphicon-search"></span>Search</a>
						</ul>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 5px; background-color: rgba(227, 231, 239, 0.34); border: 1px solid rgba(0, 0, 0, 0.08); height: 50px">
			<div style="margin-top: 10px; margin-left: 5px; margin-bottom: 20px">
				<span class="glyphicon glyphicon-list"
					style="color: red; font-size: 25px;"></span> <b
					style="font-size: 23px; margin-left: 5px"> BORROW LIST</b>
			</div>
			<table id="example" class="display" width="95%" style="">
				<thead>
					<tr>
						<th width="4%" >Id Borrow</th>
						<th>Reader Name</th>
						<th>Phone Number</th>
						<th width="15%">Date Borrow</th>
						<th width="15%">Date Return</th>
						<th width="7%%">Edit</th>
						<th width="7%">Delete</th>
					</tr>
				</thead>
			</table>
			<a class="btn-info btn-sm" id="" href="/Library/borrow/update" 
				style="margin-left: 3px; margin-left: 0%"><span class="glyphicon glyphicon-plus"></span>
				Add Borrow</a>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/template/modal.jsp"%>
</body>
<script src="<c:url value="/resources/js/controller/borrow/list.js" />"></script>
</html>