<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
<link href="css/style28.css" rel="stylesheet">
</head>
<body>

<%@include file="/HappytailHeader.jsp" %>
<div class="divbig" style="width:1000px;">
	<h3>會員資料</h3><br>
	
	<form class="form" action="<c:url value="memberUpdate" />" method="post" enctype="multipart/form-data">
<br>
	<table style="width: 100%;">
		<tr><td><input type="hidden" name="id" value = "${petMember.id }" /></td></tr>			
		<tr>
			<td style="height: 70px; vertical-align:top;">		
				<label class="lab">Username :</label>
				<input class="inpu" type="text" name="username" value = "${petMember.username }${param.username }" />
				<br><font color='red' size="-1">${errorMsg.usernameError}</font>
			</td>	
			<td>
				<label class="lab">Passwor :</label>
				<input class="inpu" type="text" name="password" value= "${petMember.password }${param.password }" />
				<br><small style="font">*密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>		
				<br><font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>
<!-- 				<tr> -->
<!-- 					<td>Email :	</td> -->
<%-- 					<td><input type="text" name="email"  value= ${petMember.email } /></td> --%>
<!-- 				</tr> -->
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">		
				<label class="lab">Gender</label>				
				<input type="radio" name="gender" value="M" 
					<c:if test="${gender == true}">checked="checked"</c:if>					
				/>Man 					
				<input type="radio" name="gender" value="F" 
					<c:if test="${gender == false}">checked="checked"</c:if>
				/>Woman
			</td>	
			<td>		
				<label class="lab">Birthday :</label>	
				<input class="inpu" type="date" name="bday"  value= "${petMember.bday }${param.bday  }" />
<%-- 			<font color='red' size="-1">${errorMsg.mBbday}</font> --%>
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">					
				<label class="lab">Age :</label>
				<input class="inpu" type="text" name="age"  value= "${petMember.age }${param.age }" />
<%-- 			<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
			</td>	
			<td>	
				<label class="lab">Address :</label>
				<input class="inpu" type="text" name="address" value= "${petMember.address }${param.address }" />
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">
				<label class="lab">Phone :</label>
				<input class="inpu" type="text" name="phone" value="${petMember.phone }${param.phone }" />
			</td>
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">	
				<label class="lab">MemberImage</label>
				<input class="inpu" type="file" id="memberImage" name="memberImage" />
				<p id="p"></p>		
				<p id="p0"><img id="mi" width='300' src="memberImage/${sessionScope.LoginOK.id}" /></p>
			</td>
		</tr>

	</table>
		<input class="btn btn-info" type="submit" name="modify" value="修改會員資料">
	
	</form>
</div>
	
	<%@include file="/HappytailFooter.jsp" %>

<script type="text/javascript">
$("#memberImage").change(function(){
	  readURL(this);
	});

function readURL(input){
	if(input.files && input.files[0]){
		document.getElementById("p0").innerHTML=""; 
		
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
		document.getElementById("p0").innerHTML="";  
	  }
}
</script>	
</body>
</html>