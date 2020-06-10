<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="divbig" style="width:1000px;">
	<h3>會員資料</h3><br>
	
	<form class="form" action="<c:url value="memberUpdate" />" method="post" enctype="multipart/form-data">

	<table style="width: 100%;">
	<p><small style="color: red; font-weight: bold;">有*號的欄位為必填</small></p>
		<tr><td><input type="hidden" name="id" value = "${petMember.id }" /></td></tr>			
		<tr>
			<td style="height: 70px; vertical-align:top;">		
				<label class="lab">*姓名 :</label>
				<input class="inpu" type="text" name="username" value = "${petMember.username }${param.username }" />
				<br><font color='red' size="-1">${errorMsg.usernameError}</font>
			</td>	
			<td>
				<label class="lab">*密碼 :</label>
				<input class="inpu" type="text" name="password" value= "${petMember.password }${param.password }" />
				<br><small style="font-style: italic;">密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>		
				<br><font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>
<!-- 				<tr> -->
<!-- 					<td>Email :	</td> -->
<%-- 					<td><input type="text" name="email"  value= ${petMember.email } /></td> --%>
<!-- 				</tr> -->
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">		
				<label class="lab">性別</label>				
				<input type="radio" name="gender" value="M" 
					<c:if test="${gender == true}">checked="checked"</c:if>					
				/>男 					
				<input type="radio" name="gender" value="F" 
					<c:if test="${gender == false}">checked="checked"</c:if>
				/>女
			</td>	
			<td>		
				<label class="lab">生日 :</label>	
				<input class="inpu" type="date" name="bday"  value= "${petMember.bday }${param.bday  }" />
<%-- 			<font color='red' size="-1">${errorMsg.mBbday}</font> --%>
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">					
				<label class="lab">年齡 :</label>
				<input class="inpu" type="text" name="age"  value= "${petMember.age }${param.age }" />
<%-- 			<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
			</td>	
			<td>	
				<label class="lab">地址 :</label>
				<input class="inpu" type="text" name="address" value= "${petMember.address }${param.address }" />
			</td>	
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">
				<label class="lab">電話 :</label>
				<input class="inpu" type="text" name="phone" value="${petMember.phone }${param.phone }" />
			</td>
		</tr>
		<tr>
			<td style="height: 70px; vertical-align:top;">	
				<label class="lab">會員照片</label>
				<input class="inpu" type="file" id="memberImage" name="memberImage" />
				<p id="p"></p>		
				<p id="p0"><img id="mi" width='300' src="memberImage/${sessionScope.LoginOK.id}" /></p>
			</td>
		</tr>

	</table>
		<input class="btn btn-info" type="submit" name="modify" value="修改會員資料">
	
	</form>
</div>