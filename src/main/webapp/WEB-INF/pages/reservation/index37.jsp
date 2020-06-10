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
					<img src='img/money33.jpg' width="70%" style='float:left;margin-right: 50px'>
					<div style='margin-top: 25px;'>
					<h1 style='margin-bottom: 20px;margin-left: 1220px;margin'>預約服務</h1>
					<form method='post' action='insertSuccess' onsubmit="return check()" style='font-size: 18px'>
						選擇服務 : 
						<input type="radio" name='sortId' value="1"> 剪髮 
						<input type="radio" name='sortId' value="2"> 洗髮 
						<input type="radio" name='sortId' value="3"> 洗剪 
						<input type="radio" name='sortId' value="4"> SPA <br><br>
						寵物品種 : <input type="text" name='breed' id='breed' onblur="checkbreed()" onkeyup="checkbreed(this)">
								<span id="str1" style='color: red;'></span><br><br>
						 寵物名稱 : <input type="text" name='petName' id='petName' onblur="checkpetname()" onkeyup="checkpetname(this)">
						 		<span id="str2" style='color: red'></span><br><br> 
						 寵物性別 : 
						 <input type="radio" name='petGenger' value="man">公 
						 <input type="radio" name='petGenger' value="girl">母 <br><br> 
						 寵物年紀 : <input type="number" min="1" name='petAge' id='petAge' onblur="checkpetAge()" onkeyup="checkpetAge(this)">
						 		<span id="str3" style='color: red'></span><br><br>
						  預約日期 : <input type='date' min="2020-06-12" id='date' onblur="checkdate()" onkeyup="checkdate(this)"
						  max="2020-12-31" name='createDate' >
						  <span id="str4" style='color: red'></span><br><br>
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
							</select><br><br> 需求 : <input type="text" id='require' name='require' style='margin-bottom: 10px'><br>
										<input type="hidden" name='done' value='N'>
										<input type='hidden' name='evaluationStatus' value='未完成'>
										<input class="btn btn-success" type="submit" name='statuss' value="預約" style="margin-left: 110px;">
										<input class="btn btn-success" type="button" value='一鍵新增' onclick='Send()'>
									</form>
									<div>
									</div>
<%-- 									<a href="<c:url value='queryMyReservaitionView?Id=${petMembers.id}&pageNum=1' />">MyReservation</a> --%>
								</div>	
							</div>
							
<script>
	function Send() {
		document.getElementById("petName").value='小馬';
		document.getElementById("breed").value='拉不拉多';
		document.getElementById("petAge").value=2;
		document.getElementById("date").value='2020-06-15';
		document.getElementById("require").value='舒服的';
	}

</script>
							
		<!-- ./experience -->
<script>
function checkbreed(){
	let i = document.getElementById("breed").value.length;
	let p = document.getElementById("breed").value;
	var check = false;
	if(i==0){ 
		document.getElementById("str1").innerHTML = "不可空白";
		check = false;
	} else{
		document.getElementById("str1").innerHTML = "";
		check = true
	} 
	return check;
}

function checkpetname(){
	let i = document.getElementById("petName").value.length;
	let p = document.getElementById("petName").value;
	var check = false;
	if(i==0){ 
		document.getElementById("str2").innerHTML = "不可空白";
		check = false;
	} else{
		document.getElementById("str2").innerHTML = "";
		check = true
	} 
	return check;
}

function checkpetAge(){
	let i = document.getElementById("petAge").value.length;
	let p = document.getElementById("petAge").value;
	var check = false;
	if(i==0){ 
		document.getElementById("str3").innerHTML = "不可空白";
		check = false;
	} else{
		document.getElementById("str3").innerHTML = "";
		check = true
	} 
	return check;
}

function checkdate(){
	let i = document.getElementById("date").value.length;
	let p = document.getElementById("date").value;
	var check = false;
	if(i==0){ 
		document.getElementById("str4").innerHTML = "不可空白";
		check = false;
	} else{
		document.getElementById("str4").innerHTML = "";
		check = true
	} 
	return check;
}

function checkpetname(){
	let i = document.getElementById("petAge").value.length;
	let p = document.getElementById("petAge").value;
	var check = false;
	if(i==0){ 
		document.getElementById("str2").innerHTML = "不可空白";
		check = false;
	} else{
		document.getElementById("str2").innerHTML = "";
		check = true
	} 
	return check;
}

function check(){
    var check = checkbreed() ;

    if (check != true){
        alert("輸入錯誤");
    }else {
        alert("新增成功");
        
    }

    return check;
}
</script>		
		
		
		
		
	
		
			
			
			<br>
			
			<h1 style='margin-left: 210px'>我的評論</h1>
			<div style='height:500px;width:470Px;overflow: auto;float: left;margin-left: 80px'>
			<c:forEach var="View" items="${Evaluation2}" >
					<div style='border:1px #5B9BD5 solid;width:450px;padding:20px;'>
						<h2>${View.username}</h2>
						<h2 class='datalist'>${View.score}</h2>
						<hr>
						<p>${View.content}</p>
						
						<form method="post" action="queryByEvaluationId" style='float: left;margin-right: 10px'>
						<input type="hidden" value='${View.evaluationId}' name='evaluationId'>
						<input class="btn btn-info" type='submit' value='修改評論'>
						</form>
						
						<form method="post" action="deleteByEvaluationId" >
						<input type="hidden" value='${View.evaluationId}' name='evaluationId'>
						<input class="btn btn-danger" type='submit' value='刪除評論'>
						</form>
						
					</div> 				
			</c:forEach>
			</div>
		
			
			<div style='margin-left: 630px;'>
			<h1 class="size-50" >所有評論</h1>
			
			<span id='score' style='font-size: 100px;'>${scoreAvg}</span>
			
			

			
<script >

var score = document.getElementById("score").innerHTML;
if(score <=1.4){ 
document.write('<img src="img/StarCopy.gif">');
}else if ( score >= 1.5 && 2.4 >= score){ 
for (i=1; i<=2; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score >= 2.5 && 3.4 >= score){ 
for (i=1; i<=3; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score >= 3.5 && 4.4 >= score){ 
for (i=1; i<=4; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score >= 4.5  && 5 >= score){ 
for (i=1; i<=5; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}

</script>


			
			
			<div style='height:500px;width:667px;overflow: auto;'>
			<c:forEach var="View" items="${Evaluation}" >
					<div style='border:1px #5B9BD5 solid;width:650px;padding:20px;'>
						<h2>${View.username}</h2>
						<h2 class='datalist'>${View.score}</h2>
						<hr>
						<p>${View.content}</p>
					</div> 				
			</c:forEach>
			</div>
			<img src='img/1234.jpg' width="350" style='float: left'>
			<img src='img/11111.jpg' width="300" >
			</div>
			
			
			

<script>
var score = document.getElementsByClassName("datalist");
console.log(score[0]);

for(var i = 0 ; i < score.length ; i++){
	console.log(score[i].innerHTML);
	if (score[i].innerHTML == 5.0){
		score[i].innerHTML = '<img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif">';
	} else if (score[i].innerHTML == 4.0) {
		score[i].innerHTML = '<img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif">';
	} else if (score[i].innerHTML == 3.0) {
		score[i].innerHTML = '<img src="img/starNew.gif"><img src="img/starNew.gif"><img src="img/starNew.gif">';
	} else if (score[i].innerHTML == 2.0) {
		score[i].innerHTML = '<img src="img/starNew.gif"><img src="img/starNew.gif">';
	} else if (score[i].innerHTML == 1.0) {
		score[i].innerHTML = '<img src="img/starNew.gif">';
	}
	
}


</script>


		<%@include file="/HappytailFooter.jsp" %>
</body>
</html>