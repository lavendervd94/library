<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/template/header.jsp"%>
<title>Reader Update</title>
<%@ include file="/WEB-INF/pages/template/script.jsp"%>
<script src="<c:url value="/resources/js/controller/reader/update.js" />"></script>
<body>
	<%@ include file="/WEB-INF/pages/template/menu_top.jsp"%>
	<%@ include file="/WEB-INF/pages/template/menu_left.jsp"%>
	<div class="col-sm-10_88" style="background-color: white">
		<input type="hidden" value="${MODE}" class="form-control" id="mode"
			name="mode"> <input type="hidden" value="${id}"
			class="form-control" id="idReader" name="idReader">
			<input type="hidden" value='<c:url value="/reader/list"></c:url>'
			class="form-control" id="linkListScreenReader">
		<div class="vendor">
			<div class="col-sm-12"
				style="background-color: rgba(227, 231, 239, 0.34); height: 50px; border: 1px solid rgba(0, 0, 0, 0.08)">
				<div style="margin-top: 10px; margin-left: 5px">
					<span class="glyphicon glyphicon-education"
						style="color: red; font-size: 25px;"></span> <b
						style="font-size: 23px; margin-left: 5px"> READER ENTRY</b>
				</div>
			</div>
			<div style="margin-bottom: 10px;">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="width: 1000px; height: 100px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 150px;">Name:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 116px">
							<input type="text" class="form-control" id="name"
								value="${mapReaderInfo.name}">
						</div>
					</div>
					<div class="form-group"
						style="width: 1000px; height: 50px; margin-left: 89px">
						<label class="col-md-2 control-label"
							style="margin-top: 10px; padding-right: 30px">Gender:</label>
						<ul style="margin-top: 10px; margin-left:218px">
							<input type="radio" name="gender" value="0" checked> Nam
							<input type="radio" name="gender" value="1"> Nu
						</ul>
					</div>

					<div class="form-group" style="width: 1000px; height: 50px;">
						<label class="col-md-1 control-label"
							style="margin-top: 10px; margin-left: 160px;">Address:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 105px">
							<input type="text" class="form-control" id="address"
								value="${mapReaderInfo.address}">
						</div>
					</div>
					<div class="form-group"
						style="width: 1000px; height: 50px; margin-left: 140px">
						<label class="col-md-1 control-label" style="margin-top: 10px;">Phone:</label>
						<div class="col-md-4" style="margin-top: 10px; margin-left: 115px">
							<input type="number" class="form-control" id="phone"
								value="${mapReaderInfo.phone}">
						</div>
					</div>
					<ul class=""
						style="margin-top: 15px; margin-left: 545px; width: 290px;">
						<a class="btn-info btn-sm" 
							id="updateReader" onclick="updateReaderByID();"><span
							class="glyphicon glyphicon-ok"></span> <c:if
								test="${MODE=='EDIT'}">
 						EDIT
						</c:if> <c:if test="${MODE =='NEW'}">
 						NEW
						</c:if> </a>
					</ul>
			</div>
		</div>
	</div>
</body>
</html>