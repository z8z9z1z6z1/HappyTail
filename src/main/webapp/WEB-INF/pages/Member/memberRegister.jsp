<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

<link href="css/style28.css" rel="stylesheet">
</head>
<body >
	<%@include file="/HappytailHeader.jsp" %>

<div class="divbig" style="width:1000px;">
	<h3>會員註冊</h3><br>
	<form class="form" action="<c:url value="registerInsert" />" method="post" enctype="multipart/form-data">
<br>
	<table style="width: 100%;">
		<tr>
			<td style="height: 70px; vertical-align:top;">
				<label class="lab">Account :</label>
				<input class="inpu" name="account" placeholder="請輸入你的email" value="${param.account }"/>
			<br><font color='red' size="-1">${errorMsg.accountformatError}${errorMsg.accountIsExist}${errorMsg.accountError}</font>
			</td>	
			<td>
				<label class="lab">Username :</label>
				<input class="inpu" type="text" name="username" value="${param.username }"/>
			<br><font color='red' size="-1">${errorMsg.usernameError}</font>
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">
				<label class="lab">Password :</label>
				<input class="inpu" type="password" name="password" value="${param.password }"/>
				<br><small>*密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>
				<br><font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>				
			</td>				
			<td>										
				<label class="lab">Gender : </label>		
				<label class="lab"><input type="radio" name="gender" value="M" checked="checked"
				<c:if test="${gender == true}">checked="checked"</c:if>					
				/><span>  Man  </span></label>
					
				<label class="lab"><input type="radio" name="gender" value="F" 
				<c:if test="${gender == false}">checked="checked"</c:if>
				/><span>  Woman  </span></label>
			</td>
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">
				<label class="lab">Birthday :</label>
				<input class="inpu" type="date" name="bday"  value="${param.bday }"/>
				<br><font color='red' size="-1">${errorMsg.mBbday}</font>
			</td>				
			<td>
				<label class="lab">Age :</label>
				<input class="inpu" type="text" name="age"  value="${param.age }"/>
<%-- 			<font color='red' size="-1">${errorMsg.mAge}</font> --%>
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">		
				<label class="lab">Address :</label>
				<input class="inpu" type="text" name="address"  value="${param.address }"/>
			</td>				
			<td>
				<label class="lab">Phone :	</label>
				<input class="inpu" type="text" name="phone"  value="${param.phone }"/>
			</td>	
		</tr>
		<tr>
			<td style="height:70px; vertical-align:top;">
				<label class="lab">MemberImage</label>
				<input class="inpu" type="file" id="memberImage" name="memberImage" />
			<br><p id="p"></p>
			</td>
		<tr>
	</table>
			
		<input class="btn btn-info" type="submit" name="Submit" />
		
	</form>
</div>		
	<%@include file="/HappytailFooter.jsp" %>

<script type="text/javascript">
$("#memberImage").change(function(){
	  readURL(this);
	});

function readURL(input){
	if(input.files && input.files[0]){
		let theP = document.getElementById("p");
		let theImg = document.createElement("img");
		theImg.style.width="300px";
		theImg.setAttribute("id", "imgPreview");
		theImg.setAttribute("src", "");
		theP.appendChild(theImg);
		
	    var reader = new FileReader();
	    reader.onload = function (e) {
	       $("#imgPreview").attr('src', e.target.result);
	    }
	    reader.readAsDataURL(input.files[0]);
	  }else{
		document.getElementById("p").innerHTML="";  
	  }
}
</script>	
</body>
</html>