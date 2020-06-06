<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>shoppingCart</title>
<!-- &mdash;  這個是斜線-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by gettemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="gettemplates.co" />




<!-- Animate.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/2018css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/bootstrap.css">

<!-- Flexslider  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/flexslider.css">


<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.theme.default.min.css">

<!-- MDBootstrap Datatables  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/addons/datatables.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/style.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/shopJs/modernizr-2.6.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/shopJs/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery-3.4.1.js"></script>
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script> --%>
<!-- Waypoints -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script
	src="${pageContext.request.contextPath}/shopJs/owl.carousel.min.js"></script>
<!-- countTo -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.countTo.js"></script>
<!-- Flexslider -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.flexslider-min.js"></script>

<!-- MDBootstrap Datatables  -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/shopJs/addons/datatables.min.js"></script>

<!-- Main -->
<script src="${pageContext.request.contextPath}/shopJs/main.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<div id="page">
		<jsp:include page="shopTop.jsp" />
		<header id="fh5co-header"
			class="fh5co-cover fh5co-cover-sm text-center" role="banner">
			<div class='fh5co-contact'>
				<div class="container">
					<div class="row">

						<div class="col-md-3 col-md-push-1 animate-box">

							<div class="fh5co-contact-info">
								<h3 id="PetProduct">Pet Product</h3>
								<ul>
									<li class="icon-shopping-bag"><a href="<c:url value='/getOrderBean.do'/>" id='cate1'>我的訂單</a></li>									
									<li class="icon-heart2"><a href="<c:url value='/getFavorite.do'/> ">我的最愛</a></li>
									<li class="icon-home"><a href="<c:url value='/intoCart'/> ">回首頁</a></li>
									<li class="icon-game-controller"><a href="<c:url value='/showProduct2'/>"  id='cate4'>回到商城</a></li>
									
								</ul>
							</div>

						</div>


						<div class="col-8">
							<div align="center">
								<table id='dtBasicExample'
									class='table table-striped table-bordered  display'
									style="text-align: center">

									<thead>
										<tr>
											<th id='test' class="th-sm">商品名稱</th>
											<th class="th-sm">商品價格</th>
											<th class="th-sm">商品數量</th>
											<th class="borderA">價格小記</th>
											<th class="th-sm">修改/刪除</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="vs" var="anEntry"
											items="${cart.content}">

											<TR height='16'>
												<td style="text-align: center;">${anEntry.value.name}</td>
												<td style="text-align: center;">${anEntry.value.unitPrice}</td>
												<td style="text-align: center;"><Input
													id="${anEntry.value.productId}"
													style="width: 28px; text-align: right" name="newAmount"
													 
													type="text"
													class="qt"
													value="${anEntry.value.quantity}" /></td>
												<td style="text-align: right;"
												id="${anEntry.value.productId}v"
												class="qtv"
												 ><fmt:formatNumber
														value="${anEntry.value.unitPrice * anEntry.value.quantity }"
														pattern="#,###" 														
														/>元</td>
												<td style="text-align: center;">
													<a href='<c:url value='/remove.do/${anEntry.value.productId}'/> ' class='btn btn-primary' >刪除</a></td>
											</TR>



										</c:forEach>
									</tbody>
									<tfoot>
										<TR height='16'>
											<TD colspan='4' align='right' class="th-sm">合計金額：</TD>
											<TD align='center' class="th-sm" id='total'><fmt:formatNumber
													value="${cart.subtotal}" pattern="#,###,###" />元</TD>
										</TR>
										<tr>
											<TD colspan='5' style="text-align: center;" class="th-sm">
												<a href="<c:url value='/OrderCheck'/>"  class='btn btn-primary'>確認訂單</a>
											</TD>
										</tr>
									</tfoot>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

	</div>
	<script type="text/javascript">
	$(document).ready(function () {
		$(".qt").change(function(){
		var pid = this.id; 	 //編號
		var m = this.value;  //數量
		
// 		alert(m);
// 		alert("test")
		$.ajax({
			method : "Post",
			url : "<c:url value='/UpateProduct'/> ", 
			dataType : "json", //返回格式為json
			data : {
				"quantity":m , "pid":pid,
			}, //引數值
			success : function(req) {
				 console.log(req);      
				 

				 
				 subtotal=req[0];
				 priceTotal=req[1];
				 productId=req[2]
				 console.log(subtotal);
				 
// 				alert(priceTotal);
				total = document.getElementById("total");
				price=document.getElementById(productId+"v");
				console.log(price);
				total.innerHTML=subtotal+"元";
				price.innerHTML=priceTotal+"元";
				

			}
			
			
		})
		
		
	})
	
	$("#test").click(function(){
		alert("Yes123");
	})
	
	})
	</script>
	
</body>
</html>