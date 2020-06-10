<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

<link href="css/style28.css" rel="stylesheet">

</head>
<body>
	<%@include file="/HappytailHeader.jsp" %>
	
<div class="divbig">
	<h3>會員登入</h3>
	<br>
		<form class="form" action="<c:url value="loginCheck" />" method="post">		
		<br>	
			<label class="lab">帳號 :</label>
				<input class="inpu" type="text" name="account"  value = "${param.account }" id='account'/>
				<font color='red' size="-1">${requestScope.ErrorMsg.accountError }</font>
			<br><br>
			<label class="lab">密碼 :</label> 	
				<input class="inpu" type="password" name="password"  value = "${param.password }" id='password'/>
				<font color='red' size="-1">${requestScope.ErrorMsg.passwordError }</font>			
			<br><font color='red' size="-1">${requestScope.ErrorMsg.LoginError }</font>
			<br>
			<a href="<c:url value='forgetPassword' />"><small>忘記密碼?</small></a><br>
			<a href="<c:url value='register' />"><small>還不是會員?</small></a><br><br>				
			

		<button class="btn btn-info" type="submit" name="login">登入</button>
		<input class="btn btn-info" type="button" value='一鍵新增' onclick='Send()'>

<!-- 		<button class="btn btn-info" type="submit" name="login">登入</button> -->

	</form>
</div>

	<%@include file="/HappytailFooter.jsp" %>

<script>
function Send() {
	document.getElementById("account").value='petProject113@gmail.com';
	document.getElementById("password").value='eeit11339';
	
}
</script>

</body>
</html>