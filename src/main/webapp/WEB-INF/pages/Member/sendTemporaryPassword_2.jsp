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
	<form action="<c:url value="temporaryPasswordloginCheck" />" method="post">
	<br><br>
		<h5>請輸入您收到的臨時密碼 : </h5>
			<label class="lab">TemporaryPassword :</label>
			<input class="inpu" type="text" name="temporaryPassword"  value = "${param.temporaryPassword }"/>
			<br>
			<font color='red' size="-1">${requestScope.ErrorMsg.temporaryPasswordError }</font>			
		<br>
		<button class="btn btn-info" type="submit" name="sendTemporaryPassword">登入</button>		
	</form>
		<br>				
		<form action="<c:url value="sendTemporaryPassword" />" method="post">
		<small><span>沒收到臨時密碼嗎? </span></small>
			<input type="hidden" name="temporaryPasswordAccount" value = "${sessionScope.temporaryPasswordAccount }" />
			<small><input type="submit" id="reSend" value="重新發送密碼"  
				style="background-color:transparent; border:0; color:#00AEAE"></small>
		</form>		
</div>
	<%@include file="/HappytailFooter.jsp" %>

<script type="text/javascript">
	$("#reSend").click(function(){		
		alert("已重新寄送臨時密碼");	
	});
</script>
</body>
</html>