<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>

<script src="<c:url value='/js/memberCenter.js'/>"></script>
<link href="<c:url value="/css/memberCenter.css"/>" rel="stylesheet">

<link href="<c:url value="/css/style28.css"/>" rel="stylesheet">
<style>

</style>
<script>

</script>
</head>
<body>

<%@include file="/HappytailHeader.jsp" %>

<div class="container-fluid">
   <div class="card info-card">
       <div class="card-body">
           <div class="row frame-body">
               <div class="col-2 side-bar">
                 <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                   <a class="nav-link active" id="v-pills-member-tab" data-toggle="pill" href="#v-pills-member" role="tab" aria-controls="v-pills-member" aria-selected="true">會員資料</a>
                   <a class="nav-link" id="v-pills-forum-tab" data-toggle="pill" href="#v-pills-forum" role="tab" aria-controls="v-pills-forum" aria-selected="false">寵物論壇</a>
                   <a class="nav-link" id="v-pills-reservation-tab" data-toggle="pill" href="#v-pills-reservation" role="tab" aria-controls="v-pills-reservation" aria-selected="false">美容服務預約紀錄</a>
<!--                    <a class="nav-link" id="v-pills-shopping-tab" data-toggle="pill" href="#v-pills-shopping" role="tab" aria-controls="v-pills-shopping" aria-selected="false">Shopping</a> -->
                 </div>
               </div>
               <div class="col-10">
                 <div class="tab-content" id="v-pills-tabContent">
                   <div class="tab-pane fade show active" id="v-pills-member" role="tabpanel" aria-labelledby="v-pills-member-tab">
                   		<%@include file="/WEB-INF/pages/include/memberUpdate.jsp" %>
                   </div>
                   <div class="tab-pane fade" id="v-pills-forum" role="tabpanel" aria-labelledby="v-pills-forum-tab">
                       <%@include file="/WEB-INF/pages/include/forumUpdate.jsp" %>
                   </div>
                   <div class="tab-pane fade" id="v-pills-reservation" role="tabpanel" aria-labelledby="v-pills-reservation-tab">
                   		<c:import  url="/queryMyReservaitionView">
    						<c:param name="Id" value="${petMembers.id}" />
   	 						<c:param name="pageNum" value="1" />
						</c:import >
<%--                    		<%@include file="/WEB-INF/pages/reservation/myReservation.jsp" %> --%>
                   </div>
<!--                    <div class="tab-pane fade" id="v-pills-shopping" role="tabpanel" aria-labelledby="v-pills-shopping-tab"> -->
<!--                    		商城用 -->
<!--                    </div> -->
                 </div>
               </div>
             </div>
       </div>
       </div>
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