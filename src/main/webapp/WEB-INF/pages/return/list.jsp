<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Return List</title>
<%@ include file="/WEB-INF/pages/template/header.jsp" %>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp" %>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp" %>
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-arrow-down"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> RETURN </b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label"style="margin-top: 10px; margin-left: 50px;"> Borrow_ID: </label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 116px">
							<input type="text" class="form-control" id="borrowId">
						</div>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
						<label class="col-md-1 control-label" style="margin-top: 10px; margin-left: 50px;"> Reader_ID: </label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 116px">
							<input type="text" class="form-control" id="readerId">
						</div>
						<ul class=""style="margin-top: 15px; margin-left: 600px; width: 290px;">
							<a class="btn-info btn-sm" href="#" onclick = "seachReturn()"><span
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
					style="font-size: 23px; margin-left: 5px"> RETURN LIST</b>
					<a
					type="button" class="btn-info btn-sm" href="addBorrow.html"
					style="width: 150px; margin-left: 856px"><span
					class="glyphicon glyphicon-star"></span> Select All </a>
			</div>
			<table id="return" class="display" width="95%" style="">
				<thead>
					<tr>
						<th width="5%">Borrow Id</th>
						<th>Reader Name</th>
						<th>Book Name</th>
						<th width="20%">Date Borrow Reality</th>
						<th width="10%">Status</th>
						<th width="10%">Confirm</th>
					</tr>
				</thead>
				</tbody>
			</table>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/pages/template/script.jsp" %>
<script src="<c:url value="/resources/js/controller/return/list.js" />"></script>
</html>