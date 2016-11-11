<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Main</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<style>
body {
	background-image: url(".../resources/images/library.jpg");
}
</style>
</head>
<body >
	<nav class="navbar navbar-inverse">
		<div style="text-align: center;">
			<h2>Library Management Program</h2>
		</div>
	</nav>
	<div class="well">
		<div class="container">
			<a href="http://localhost:8080/Library/book/list" class="btn btn-primary btn-lg"
				style="width: 122.22222px; height: 122.22222px;"> <span
				class="glyphicon glyphicon-book"></span>
				<p>Book</p>
			</a> <a href="http://localhost:8080/Library/reader/list" class="btn btn-danger btn-lg"
				style="width: 122.22222px; height: 122.22222px;"> <span
				class="glyphicon glyphicon-education"></span>
				<p>Reader</p>
			</a> <a href="http://localhost:8080/Library/borrow/list" class="btn btn-success btn-lg"
				style="width: 122.22222px; height: 122.22222px;"> <span
				class="glyphicon glyphicon-arrow-up"></span>
				<p>Borrow</p>
			</a> <a href="http://localhost:8080/Library/return/list" class="btn btn-success btn-lg"
				style="width: 122.22222px; height: 122.22222px;"> <span
				class="glyphicon glyphicon-arrow-down"></span>
				<p>Return</p>
			</a>
		</div>
	</div>
	<div class="col-sm-12" id="a" style="height: auto">
	<a class="btn-info btn-sm" id="" href="http://localhost:8080/Library/logout" style="margin-left: 92%"><span class="glyphicon glyphicon-arrow-left"></span>
	Logout</a>
	</div>
</body>
</html>