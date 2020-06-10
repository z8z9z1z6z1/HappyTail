<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>

<html>
<head>
<%-- <c:set var="id" value="${product.getProductId()}" /> --%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>chose your best</title>
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
	href="${pageContext.request.contextPath}/shopCss/bootstrap2015.css">

<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/shopCss/bootstrap2015.css"> --%>


<!-- Flexslider  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/flexslider.css">


<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.theme.default.min.css">

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
<!-- Main -->
<script src="${pageContext.request.contextPath}/shopJs/main.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<jsp:include page="shopTop.jsp" />
		<br>
		<!-- ------------------------------------------------------------------------------------------------------- -->

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner" style="background-image: url(images/second.jpg);">
			<div class="overlay"></div>



			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc animate-box" data-animate-effect="fadeIn">
								<!-- 								<i class="icon-shopping-cart"></i> -->
								<h1>shop mall</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<!-- ------------------------------------------------------------------------------------------------------- -->


		<div id="fh5co-contact">	
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-md-push-1 animate-box">

						<div class="fh5co-contact-info">
							<h3 id="PetProduct">Pet Product</h3>
							<ul>
								<li class="icon-shopping-bag"><a href="<c:url value='/getOrderBean.do'/>" id='cate1'>過往訂單</a>
								<li class="icon-cake"><a href="<c:url value='/showProduct1'/>" id='cate1'>寵物食品</a></li>
								<li class="icon-image"><a href="<c:url value='showProduct2.do'/>" id='cate2'>寵物衣服</a></li>
								<li class="icon-game-controller"><a href="<c:url value='showProduct3.do'/>" id='cate3'>寵物玩具</a></li>
								<li class="icon-shopping-cart"><a href="<c:url value='/intoCart'/> ">購物車</a></li>
								<li class="icon-heart2"><a href="<c:url value='/getFavorite.do'/> ">我的最愛</a></li>
								<li class="icon-home"><a href="<c:url value='/intoCart'/> ">回首頁</a></li>
							</ul>
						</div>

					</div>


					<div class="col-md-9 animate-box">
						<div align="center">
							<h3>Get In Touch</h3>
						</div>

						<c:forEach var="product" items="${productList}">
							<div class="col-md-3 text-center animate-box  ">

								<div class="product ">
									<div class="product-grid ">
										<div class="card " align="center" >
											<img class="card-img-top" style="width: 80%; height: 150px ; "
												src="data:image/jpg;base64,${product.getBiPhoto()}"
												alt="Card image cap" >
											<div class="card-body">
												<h5 class="card-title">${product.getName()}</h5>
												<p class="card-text">${product.getDescriptrion()}</p>
												<p class="card-text">
												<fmt:formatNumber value="${product.getPrice()}" pattern="#,###" />
												元</p>

											</div>
											<div class="card-footer ">
												<input type="button" class="btn btn-primary toLove" id='f${product.getProductId()}' value='加入最愛'> <br>
<%-- 												<form action="<c:url value='/addProductToCart'/>"  method="post" enctype="multipart/form-data"> --%>
													<input type="submit" class="btn btn-primary toCart" id='${product.getProductId()}'  value="加入購物" >
													<Input class='pdId' type='hidden' name='productId' value='${product.getProductId()}'>

											</div>

										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>

		<div id="map" class="animate-box" data-animate-effect="fadeIn"></div>

		<div id="fh5co-started">
			<div class="container">
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
						<h2>Newsletter</h2>
						<p>Just stay tune for our latest Product. Now you can
							subscribe</p>
					</div>
				</div>
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2">
						<form class="form-inline">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label for="email" class="sr-only">Email</label> <input
										type="email" class="form-control" id="email"
										placeholder="Email">
								</div>
							</div>
							<div class="col-md-6 col-sm-6">
								<button type="submit" class="btn btn-default btn-block">Subscribe</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md">
					<div class="col-md-4 fh5co-widget">
						<h3>Shop.</h3>
						<p>Facilis ipsum reprehenderit nemo molestias. Aut cum
							mollitia reprehenderit. Eos cumque dicta adipisci architecto
							culpa amet.</p>
					</div>
					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">About</a></li>
							<li><a href="#">Help</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Terms</a></li>
							<li><a href="#">Meetups</a></li>
						</ul>
					</div>

					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">Shop</a></li>
							<li><a href="#">Privacy</a></li>
							<li><a href="#">Testimonials</a></li>
							<li><a href="#">Handbook</a></li>
							<li><a href="#">Held Desk</a></li>
						</ul>
					</div>

					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">Find Designers</a></li>
							<li><a href="#">Find Developers</a></li>
							<li><a href="#">Teams</a></li>
							<li><a href="#">Advertise</a></li>
							<li><a href="#">API</a></li>
						</ul>
					</div>
				</div>

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; 2016 Free HTML5. All Rights
								Reserved.</small> <small class="block">Designed by <a
								href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a>
								Demo Images: <a href="http://blog.gessato.com/" target="_blank">Gessato</a>
								&amp; <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
						</p>
						<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
						</p>
					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

<script type="text/javascript">
$(document).ready(function () {
// 	alert("123");
$("cate1").click(function(){
	alert("123");
})

$(".toCart").click(function(){
	var pid = this.id;

	$.ajax({
		method: "GET",
		url:"<c:url value='/addProductToCart'/>", //請求的url地址
		dataType : "json", //返回格式為json
		data:{
			"productId":pid,
		},
		success :function(res){
			alert("已經加入購物車");
			console.log(res[1]);
		}
		
	})
	
})

$(".toLove").click(function(){
	var fid = this.id;
	
// alert(fid);
// 		alert(fid.slice(1,fid.length));
$.ajax({
	method: "GET",
	url: "<c:url value='/addToLike'/>",
	dataType : "json", 
	data:{
		"productId":fid.slice(1,fid.length),
	},
	success:function(res){

		console.log(res);
			
		alert("加入收藏");
			
	},
	error: function(res){
		alert("已經加入過了");
	}
})




})
	
})
</script>

</body>
</html>
