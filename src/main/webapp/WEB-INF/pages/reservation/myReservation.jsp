<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyReservation</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
</head>
<body>


	  
	  
	  
	<img src='img/02.jpg' width="350" style='float: left;' >
	<H2 style='margin-top: 70px'>${petMembers.username}的預約 , 共 ${page.totalNum}筆 <br>
	帳號 : ${petMembers.email}</H2>
	
	<table border="1" class="table table-striped">
	 <tr style="text-align:center">
	 	<td>寵物名稱</td>
	 	<td>服務項目</td>
	 	<td>需求</td>
	 	<td>預約日期</td>
	 	<td>預約時間</td>
	 	<td>金額</td>
	 	<td>預約狀態</td>
	 	<td>評分</td>
	 	<td></td>
	<c:forEach varStatus="star" var="View" items="${page.records}">
	 <tr style="text-align:center" class='datalist'>
			<td>${View.petName}</td>
			<td>${View.serviceItem}</td>
			<td>${View.require}</td>
			<td>${View.createDate}</td>
			<td>${View.availableDateTime}:00</td>
			<td>${View.amount}</td>
			<td class='statuss'>${View.statuss}</td>
			<td class='evaluationStatus'>${View.evaluationStatus}</td>
			
			
			<td>
				<form style='float:left' method='post' action='update'>
				<input type='hidden' name='Id' value='${petMembers.id}'>
				<input type='hidden' name='pageNum' value='${page.currentPage}'>
				<input type="hidden" name='reservationId' value='${View.reservationId}'>
				<input class="btn btn-danger"  type="submit" name='statuss' value="取消預約">
				</form>
				
				<form style='float:left' method='post' action='updateEvaluationStatus' >
				<input type="hidden" name="reservationId" value="${View.reservationId}">
				<input type='hidden' name='evaluationStatus' value='完成'>
				<input class="btn btn-info"  type='submit' value='評分'  >
				</form>
			</td>
	</tr>
	</c:forEach>
	</tr>
	</table>

	
	<form method="get" action="queryMyReservaitionView" style='float: left;margin-right: 10px; '>
	<td>
		<input type='hidden' name='Id' value='${petMembers.id}'>
		<input type='hidden' name='pageNum' value='${page.currentPage-1}'>
		<input type='submit' value='上一頁' class="btn btn-primary" >
	</td>
	</form>

	<p style='float: left;margin-right: 10px;margin-top: 10px'>第  ${page.currentPage} 頁 , 共 ${page.totalPages}頁</p>

	<form method="get" action="queryMyReservaitionView" >
	<td>
		<input type='hidden' name='Id' value='${petMembers.id}'>
		<input type='hidden' name='pageNum' value='${page.currentPage+1}'>
		<input type='submit' value='下一頁' class="btn btn-primary" >
	</td>
	</form>
	
<script>
$(document).ready(function(){
	console.log(hello3);
	getmyReservation();
	
});

function getmyReservation(){
	console.log(hello);
	var url=contextRoot + "/queryMyReservaitionView?Id=" + ${petMembers.id} + "&pageNum=1";
	
	$.ajax({
		url : url,
		type : "get",
		async : false,
		success : function(data){
			
		}
	
	});
	console.log(hello2);
}

</script>
	




<script type="text/javascript">
var datalist = document.getElementsByClassName("datalist");
console.log(datalist);

for(var i = 0 ; i < datalist.length ; i++){
	var evaluationStatus = datalist[i].getElementsByClassName("evaluationStatus")[0].innerHTML;
	var statuss = datalist[i].getElementsByClassName("statuss")[0].innerHTML;
	
	if(statuss == "取消預約"){
		datalist[i].getElementsByClassName("btn btn-info")[0].setAttribute("type","hidden");
		datalist[i].getElementsByClassName("btn btn-danger")[0].setAttribute("type","hidden");
	} else if ( evaluationStatus == "完成" ) {
		datalist[i].getElementsByClassName("btn btn-info")[0].setAttribute("type","hidden");
	}
	
}
</script>



	
	


</body>
</html>