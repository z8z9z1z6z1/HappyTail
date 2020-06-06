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
							<td style="text-align: center;"><img class="card" width='60'
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
				</div>
			</div>
		</header>

	</div>
	<script>
	$(".buy").click(function(){
		var pid=this.id;
//	 	alert(pid);
		$.ajax({
			method: "GET",
			url: "<c:url value='/addProductToCart'/>",
			dataType : "json", 
			data:{
				"productId":pid
			},
			success:function(res){
				alert("成功加入購物車");
				
			},
			error:function(res){
				alert("失敗")
			}
		})
	
	})
	</script>
	
</body>
</html>