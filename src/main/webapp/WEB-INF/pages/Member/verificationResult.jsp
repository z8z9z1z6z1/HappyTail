<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="3; url= http://localhost:8080/happytail/HappyTailIndex.jsp">
<title>驗證結果通知</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

<link href="css/style28.css" rel="stylesheet">
<style>
	.spe{text-align: center;}
</style>
</head>
<body>
<%@include file="/HappytailHeader.jsp" %>

<div class="divbig spe">
<br><br>
	<c:if test="${verificationResult == true}">
		<h2>驗證成功，會員帳號已啟用</h2>
	</c:if>	
	<c:if test="${verificationResult == false}">
		<h2>驗證失敗，請重新註冊會員</h2>
	</c:if>	
<br><br>
</div>	
	<%@include file="/HappytailFooter.jsp" %>
<script>
	
</script>

</body>
</html>