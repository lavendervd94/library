<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Reader List</title>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
		<input type="hidden" value='<c:url value="/reader/list"></c:url>'
			class="form-control" id="linkListScreenReader">
	<div class="col-sm-10_88" style="background-color: white">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-book"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> READER</b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 58px;">Name:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 108px">
							<input type="text" class="form-control" id="name">
						</div>
						<label class="col-md-2 control-label" style="margin-top: 10px; padding-right: 35px">Gender:</label>
						<ul style="margin-top: 66px">
							<input type="radio" name="gender" value="0"> Nam
							<input type="radio" name="gender" value="1"> Nu
						</ul>
					</div>
					<div class="form-group" style="width: 1000px; height: 50px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 68px;">Address:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 98px">
							<input type="text" class="form-control" id="address">
						</div>
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 50px">Phone:</label>
						<div class="col-md-2" style="margin-top: 10px">
							<input type="text" class="form-control" id="phone">
						</div>
						<ul class=""
							style="margin-top: 15px; margin-left: 87.5%; width: 290px;">
							<a onclick="searchReader()" class="btn-info btn-sm" href="#"><span
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
					style="font-size: 23px; margin-left: 5px"> READER LIST</b>
			</div>
			<table id="example" class="display" width="95%" style="">
				<thead>
					<tr>
						<th>Name</th>
						<th>Gender</th>
						<th>Address</th>
						<th>Phone</th>
						<th width="7%">Edit</th>
						<th width="7%">Delete</th>
					</tr>
				</thead>

				</tbody>
			</table>
			<a class="btn-info btn-sm" href="/Library/reader/update"
				style="margin-left: 3px; margin-left: 87.5%"><span class="glyphicon glyphicon-plus"></span>
				Add Reader</a>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<script src="<c:url value="/resources/js/controller/reader/list.js" />"></script>
</html>