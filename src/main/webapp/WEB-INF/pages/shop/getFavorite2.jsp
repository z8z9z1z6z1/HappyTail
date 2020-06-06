<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<meta charset="UTF-8">
<title>Happy Tail</title>
<!-- CSS  -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/icomoon.css">

<link href="<c:url value='/css/style.css'/>" type="text/css"
	rel="stylesheet" media="screen,projection" />
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!--Let browser know website is optimized for mobile-->

<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/style.css">
<!--jQuery-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<!--JavaScript at end of body for optimized loading-->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
	$(document).ready(function() {
		$('.slider').slider({
			// 不顯示操控圓鈕
			indicators : false,
			// 每張照片播五秒
			interval : 2000
		})
	})
</script>
<body>
<%-- 	<%@ include file="top.jsp"%> --%>
	<jsp:include page="/top.jsp"></jsp:include>
	
	
	<div class="container">
			<div class="row">
				<div class='col-8'>
				<table class='table' style="text-align: center;">
						<tr>
							<td colspan='5'>我的最愛</td>
						</tr>
						<tr>
						<th style="text-align: center;">我的最愛</th>
						<th style="text-align: center;">商品名稱</th>
						<th style="text-align: center;">商品價格</th>						
						<th style="text-align: center;" >加入購物</th>						
						<th style="text-align: center;" >移除收藏</th>						
						</tr>
					<c:forEach var="pL" items="${pLike}">
						<tr >
							<td style="text-align: center;"><img class="card-img-top" width='80'
												src="data:image/jpg;base64,${pL.bean.getBiPhoto()}"></td>
							<td style="text-align: center;margin: auto; ">${pL.bean.getName()}</td>
							<td style="text-align: center;">
							<fmt:formatNumber value="${pL.bean.getPrice()}" pattern="#,###" />元</td>
							<td style="text-align: center;"><button class="btn btn-primary buy" id='${pL.bean.getProductId()}' type="button">購買</button></td>
							<td style="text-align: center;"> <a href="${pageContext.request.contextPath}/remove.do/${pL.bean.getProductId()}" id="${pL.bean.getProductId()}" class="delete"><button class="btn btn-primary "  type="button">刪除</button></a></td>
							
						</tr>
					</c:forEach>
			</table>
				</div>
	
		</div>
	</div>
	
	<%@ include file="footer.jsp"%>

</body>

<script>

$(".buy").click(function(){
	var pid=this.id;
// 	alert(pid);
	$.ajax({
		method: "GET",
		url: "<c:url value='/addProductToCart'/>",
		dataType : "json", 
		data:{
			"productId":pid
		},
		success:function(res){
			alert("成功加入購物車")
			
		},
		error:function(res){
			alert("失敗")
		}
	})
	
	
})





</script>


</html>