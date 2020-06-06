<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

</head>
<body>

   <%@include file="/HappytailHeader.jsp" %>
   
	
	
	
	
					<div style='border:#FFFFFF 1px double;height: 600px;background-color: #DEEBF7'>
					<img src='img/money2.jpg' width="70%" style='float:left;margin-right: 80px'>
					<div style='margin-top: 40px;'>
					<h1>Reservation</h1>
					<form method='post' action='insertSuccess' onSubmit="return CheckForm();" style='margin-top: 30px;'>
						選擇服務 : 
						<input type="radio" name='sortId' value="1"> 剪髮 
						<input type="radio" name='sortId' value="2"> 洗髮 
						<input type="radio" name='sortId' value="3"> 洗剪 
						<input type="radio" name='sortId' value="4"> SPA <br><br>
						寵物品種 : <input type="text" name='breed' id='breed' required="required"><br><br>
						 寵物名稱 : <input type="text" name='petName' id='petName' required="required"><br><br> 
						 寵物性別 : 
						 <input type="radio" name='petGenger' value="man">公 
						 <input type="radio" name='petGenger' value="girl">母 <br><br> 
						 寵物年紀 : <input type="number" min="1" name='petAge' id='petAge' required="required"><br><br>
						  預約日期 : <input type='date' min="2020-06-12" id='date'
						  max="2020-12-31" name='createDate' required="required"><br><br>
						時間 : <select name='availableDateTime'>
									<option value='13'>13:00</option>
									<option value='14'>14:00</option>
									<option value='15'>15:00</option>
									<option value='16'>16:00</option>
									<option value='17'>17:00</option>
									<option value='18'>18:00</option>
									<option value='19'>19:00</option>
									<option value='20'>20:00</option>
									<option value='21'>21:00</option>
							</select><br><br> 需求 : <input type="text" id='require' name='require'><br>
										<br> <input type="hidden" name='done' value='N'>
										<input type='hidden' name='evaluationStatus' value='未完成'>
										<input type="submit" name='statuss' value="預約" style="margin-left: 140px">
										<input type="button" value='一鍵新增' onclick='Send()'>
									</form>
									
									<a href="<c:url value='queryMyReservaitionView?Id=${petMembers.id}&pageNum=1' />">MyReservation</a>
								</div>	
							</div>
							
<script>
	function Send() {
		document.getElementById("petName").value='小馬';
		document.getElementById("breed").value='拉不拉多';
		document.getElementById("petAge").value=2;
		document.getElementById("date").value='2020-06-12';
		document.getElementById("require").value='要很乾淨我有潔癖';
	}

</script>
							
		<!-- ./experience -->
		<script>
			function CheckForm() {

				if (confirm("預約成功") == true)
					return true;
				else
					return false;
			}
		</script>
	
		
					<div style='border:#0000FF 1px double;width: 700px;height:600px;text-align: center;margin: 20px;margin-left: 40px;padding-top:30px'>
					<h1>Address</h1>
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!m12!1m3!1d3615.2719630701636!2d121.53986731495814!3d25.02484298397663!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442aa29379b8db9%3A0x6c7f37e71cce4568!2z6LOH562W5pyD!5e0!3m2!1szh-TW!2stw!4v1589437355016!5m2!1szh-TW!2stw" 
					width="450" height="450" aria-hidden="false" tabindex="0" >
					</iframe>
					</div>
					
		
			<div>
			<div style='margin-left: 200px;padding-top: 50px' >
				<h1 class="size-50" >Evaluation</h1><br>
			</div>

	
	
			<div style="margin-left:200px;margin-right:20px;float:left">
				<h2 id='score'>${scoreAvg}</h2>
			</div>

			
<script >

var score = document.getElementById("score").innerHTML;
if(score <=1.4){ 
document.write('<img src="img/StarCopy.gif">');
}else if ( score > 1.5 && 2.4 >= score){ 
for (i=1; i<=2; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 2.5 && 3.4 >= score){ 
for (i=1; i<=3; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 3.5 && 4.4 >= score){ 
for (i=1; i<=4; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 4.5  && 5 >= score){ 
for (i=1; i<=5; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}

</script>



			
			
			<div style='height:350px;white-space: nowrap;text-align: center;margin-top:50px;'>
			<marquee  direction="right" width="800px" >
			<c:forEach var="View" items="${Evaluation}" >
				
					<div style='border:2px #5B9BD5 solid;height:200px;width:300px;text-align: center;
					display: inline-block;white-space:normal;
					padding:20px;margin-right:20px;'>
						<h2 id='score2'>${View.score}分</h2>
						<hr style="width:150px;">
						<p>${View.content}</p>
					</div> 				
			</c:forEach>
			</marquee>
			</div>
			</div>
		
		<%@include file="/HappytailFooter.jsp" %>
</body>
</html>