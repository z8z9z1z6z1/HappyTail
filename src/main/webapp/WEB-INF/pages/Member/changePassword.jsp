<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>變更密碼</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
<link href="css/style28.css" rel="stylesheet">
</head>
<body>
<%@include file="/HappytailHeader.jsp" %>
<div class="divbig">
	<h5>請重新設定您的密碼 :</h5>
	<br><br>
	<form action="<c:url value="changePassword" />" method="post">
		<input class="inpu" type="hidden" name="id" value = "${sessionScope.LoginOK.id }" />		
		
		<label class="lab">Password :</label>
		<input class="inpu" type="password" name="password"  value = "${param.password }" />
		<br>
		<font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>
		<br><br>
		<button class="btn btn-info" type="submit" name="changePassword">變更密碼</button>
	</form>
</div>	
	<%@include file="/HappytailFooter.jsp" %>
</body>
</html>