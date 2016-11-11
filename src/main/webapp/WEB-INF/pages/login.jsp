<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
  <style>
	body{
	 background-color: #73cece;
	}
 div.container{
    background-color: #73cece;
    width:auto;		
}
.login {
	margin-right:90px;
	background-color: #337ab7;
	color: #fff;
	border-color: white;
	display: inline-block;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;	
	border: 1px solid transparent;
	border-radius: 4px;
	border: 8px solid transparent
}
</style>
</head>
<body>
<div class="jumbotron text-center" style="background-color:rgb(57, 65, 68)">
  <h1>Library Management Program</h1>
</div>
<div class="container text-center"> 
  <div class="col-sm-12 text-center"><h2>Login to your account</h2></div>
	<form action='<c:url value="/checkLogin"></c:url>' method="get">
		Email:    <input type="text" name="username"  size="30" style="margin-left:51px"><br></br>
		Password: <input type="password" name="password" size="30"style="margin-left:22px">
		<div class="checkbox" style="margin-left: 103px">
			<div style="margin-right:65px"><label><input type="checkbox"> Remember me for 30 days</label></div>
		</div>
		<button type="submit" class="login">Login</button>
		<div class="a" style="margin-top:180px; margin-bottom:  30px;"><a href="">Forgot Password?</a></div>
		</form>
		
</div>
</body>
</html>