<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shop</title>
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
	href="${pageContext.request.contextPath}/shopCss/bootstrap2015.css">

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
<script src="${pageContext.request.contextPath}/shopJs/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script>
<!-- Waypoints -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="${pageContext.request.contextPath}/shopJs/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="${pageContext.request.contextPath}/shopJs/jquery.countTo.js"></script>
<!-- Flexslider -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.flexslider-min.js"></script>
<!-- Main -->
<script src="${pageContext.request.contextPath}/shopJs/main.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<script type="text/javascript">
	$(document).ready(function() {
		$(section1).click(function() {

			$("html, body").animate({
				scrollTop : $(product).offset().top
			}, "show");
			return false;
			// 			alert("123");
		})

	})
</script>

</head>
<body>

	<div class="fh5co-loader"></div>


		<jsp:include page="/shopTop.jsp" />
	<div id="page">
		
		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm text-center"
			role="banner" style="background-image: url(images/first.jpg);">
			<div class="overlay "></div>
			<div class="container">
				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-center">


						<div class="display-t">

							<div class="display-tc animate-box " data-animate-effect="fadeIn">

								<h1>shopping</h1>

							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<div id="fh5co-product">
			<div class="container">
				<div class="row animate-box" id="product">
					<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
						<span>Cool Stuff</span>
						<h2>Products.</h2>
						<p>Dignissimos asperiores vitae velit veniam totam fuga
							molestias accusamus alias autem provident. Odit ab aliquam dolor
							eius.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 text-center animate-box">
						<div class="product">
							<div class="product-grid"
								style="background-image: url(images/food.jpg);">
								<div class="inner">
									<p>
										<a href="<c:url value='/intoCart'/> " class="icon"><i
											class="icon-shopping-cart"></i></a> <a
											href="<c:url value='showProduct.do'/>" class="icon"><i
											class="icon-eye"></i></a>
									</p>
								</div>
							</div>
							<div class="desc">
								<h3>
									<a href="single.html">Hauteville Concrete Rocking Chair</a>
								</h3>
<!-- 								<span class="price">$350</span> -->
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="product">
							<div class="product-grid"
								style="background-image: url(images/cloth2.jpg);">
								<div class="inner">
									<p>
										<a href="<c:url value='/intoCart'/> " class="icon" onclick=><i
											class="icon-shopping-cart"></i></a> <a href="#" class="icon"
											onclick="document.getElementById('myform').submit();"><i
											class="icon-eye"></i></a>
									</p>
<!-- 									<form action="/showProduct" method="POST" -->
									<form action="<c:url value='/showProduct.do'/>" method="POST"
										id='myform'>
										<Input type='hidden' name='categoryId' value='1'>
									</form>
								</div>
							</div>
							<div class="desc">
								<h3>
									<a href="<c:url value='/intoCart'/> ">Pavilion Speaker</a>
								</h3>
<!-- 								<span class="price">$600</span> -->
							</div>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="product">
							<div class="product-grid"
								style="background-image: url(images/toys.jpg);">
								<div class="inner">
									<p>
										<a href="single.html" class="icon"><i
											class="icon-shopping-cart"></i></a> <a
											href="<c:url value='/showProduct'/>" class="icon"><i
											class="icon-eye"></i></a>
									</p>
								</div>
							</div>
							<div class="desc">
								<h3>
									<a href="single.html">Ligomancer</a>
								</h3>
								<span class="price">$780</span>
							</div>
						</div>
					</div>
				</div>

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
	</div>
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
</body>
</html>

