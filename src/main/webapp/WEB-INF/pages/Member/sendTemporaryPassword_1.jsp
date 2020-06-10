<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員臨時登入頁面</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
<link href="css/style28.css" rel="stylesheet">
</head>
<body>

<%@include file="/HappytailHeader.jsp" %>
<div class="divbig">
<h3>會員臨時登入頁面</h3>
	<form action="<c:url value="sendTemporaryPassword" />" method="post">
	<br><br>
		<h5>請輸入您的 HappyTail 會員帳號 (您的email) : </h5>
		
			<label class="lab">帳號 :</label>
			<input class="inpu" type="text" name="temporaryPasswordAccount"  value = "${param.temporaryPasswordAccount }"/>
		<br>
			<font color='red' size="-1">${errorMsg.temporaryPasswordAccountError }</font>
		<br><br>
		<button class="btn btn-info" type="submit" name="sendTemporaryPassword">寄送臨時密碼</button>
	</form>
</div>
	<%@include file="/HappytailFooter.jsp" %>
</body>
</html>