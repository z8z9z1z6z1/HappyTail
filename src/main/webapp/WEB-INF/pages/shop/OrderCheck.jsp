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

<script>
	
</script>
</head>
<body>
	<div id="page">
		<jsp:include page="shopTop.jsp" />
		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner" style="background-image: url(images/third.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-12  text-center">
						<div class="display-t">
							<div class="display-tc animate-box" data-animate-effect="fadeIn">
								<h1>Orders</h1>
								<h2>
									
								</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<div id="fh5co-contact">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-md-push-1 animate-box">
					
					<div class="fh5co-contact-info">
							<h3 id="PetProduct">Pet Product</h3>
							<ul>
								<li class="icon-shopping-bag"><a href="#" id='cate1'>過往訂單</a>
								<li class="icon-cake"><a href="<c:url value='/showProduct2'/>" id='cate1'>寵物食品</a></li>
								<li class="icon-image"><a href="#" id='cate2'>寵物衣服</a></li>
								<li class="icon-game-controller"><a href="#" id='cate3'>寵物玩具</a></li>
								<li class="icon-shopping-cart"><a href="<c:url value='/intoCart'/> ">購物車</a></li>
								<li class="icon-heart2"><a href="<c:url value='/getFavorite.do'/> ">我的最愛</a></li>
								<li class="icon-home"><a href="<c:url value='/intoCart'/> ">回首頁</a></li>
							</ul>
						</div>

				</div>
				<div class="col-md-7 animate-box " style='border: 2px solid #4d4d4d'>
					<h3 align="center">Order Details</h3>
					<form action="<c:url value='/OrderSure'/> " method="post">
					
					
						<div class="row form-group" style='text-align: center ; font-family:微軟正黑體'>			
							<div class="col-md-4">
								<!-- <label for="fname">First Name</label> -->
								<div class="form-control" style='text-align: center'>
								會員編號:${LoginOK.getId()}
								</div>
							</div>
							<div class="col-md-4">
								<!-- <label for="lname">Last Name</label> -->
								<div class="form-control">
								${LoginOK.getUsername()}
								</div>
							</div>
							<div class="col-md-4">
								<!-- <label for="lname">Last Name</label> -->
								<div class="form-control">
								${LoginOK.getPhone()}
								</div>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="email">Email</label> -->
								<div class="form-control">
								${LoginOK.getAddress()}
								</div>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="email">Email</label> -->
								<input type="text" name='address' id="address" class="form-control" placeholder="出貨地址">
							</div>
						</div>
						

<!-- 						<div class="row form-group"> -->
<!-- 							<div class="col-md-12"> -->
<!-- 								<label for="subject">Subject</label> -->
<!-- 								<input type="text" id="subject" class="form-control" placeholder="統一編號"> -->
<!-- 							</div> -->
<!-- 						</div> -->
						
						
						<div class="row form-group text-center">
							<div class="col-md-3">								
								<div class="form-control">
								商品名稱
								</div>
							</div>
							<div class="col-md-3">								
								<div class="form-control">
								單價
								</div>
							</div>
							<div class="col-md-3">								
								<div class="form-control">
								數量
								</div>
							</div>
							<div class="col-md-3">								
								<div class="form-control">
								小記
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
							<table class='table ' style='text-align: center'>

							<c:forEach varStatus="vs" var="anEntry" items="${cart.content}">
								<tr>
								<td>${anEntry.value.name}</td>								
								<td>${anEntry.value.unitPrice}</td>
								<td><fmt:formatNumber value="${anEntry.value.quantity}" /></td>
								<td><fmt:formatNumber value="${anEntry.value.unitPrice * anEntry.value.quantity }" pattern="#,###" />元</td>
								</tr>
							</c:forEach>
							<tfoot>
								<TR height='16'>
								<TD colspan='3' align='right' class="th-sm">合計金額：</TD>
								<TD align='center' class="th-sm"><fmt:formatNumber value="${cart.subtotal}" pattern="#,###,###" />元</TD>
								</TR>												
							</table>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="message">Message</label> -->
								<textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="備註"></textarea>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" value="送出訂單" class="btn btn-primary">
							<input type="submit" value="取消訂單" class="btn btn-primary">
						</div>
					
					</form>		
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
					<p>Just stay tune for our latest Product. Now you can subscribe</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-inline">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<label for="email" class="sr-only">Email</label>
								<input type="email" class="form-control" id="email" placeholder="Email">
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
					<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit. Eos cumque dicta adipisci architecto culpa amet.</p>
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
						<small class="block">&copy; 2016 Free HTML5. All Rights Reserved.</small> 
						<small class="block">Designed by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a> Demo Images: <a href="http://blog.gessato.com/" target="_blank">Gessato</a> &amp; <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
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
</body>
</html>