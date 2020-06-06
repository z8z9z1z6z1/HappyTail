<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>該帳號已遭停用</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

<link href="css/style28.css" rel="stylesheet">
<style>
	.spe{color: red;}
</style>
</head>
<body>
<%@include file="/HappytailHeader.jsp" %>

<div class="divbig spe">
<br><br>
	<h3>帳號目前已被停權</h3><br>
	<p>親愛的會員 您好，<p>
	<p>您的會員帳號因被發現有違反本網站相關規定的行為，目前已被停權。如有任何疑問，請洽本網站管理員了解詳情。</p>
	
<br><br>
</div>	
	<%@include file="/HappytailFooter.jsp" %>
<script>
	
</script>

</body>
</html>