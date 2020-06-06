<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Animate.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/bootstrap.css">

<!-- Flexslider  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/flexslider.css">


<!-- Owl Carousel  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/owl.carousel.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/shopCss/style.css">

<!-- Modernizr JS -->
<script src="${pageContext.request.contextPath}/shopJs/modernizr-2.6.2.min.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="${pageContext.request.contextPath}/shopJs/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="${pageContext.request.contextPath}/shopJs/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="${pageContext.request.contextPath}/shopJs/jquery.countTo.js"></script>
<!-- Flexslider -->
<script src="${pageContext.request.contextPath}/shopJs/jquery.flexslider-min.js"></script>
<!-- Main -->
<script src="${pageContext.request.contextPath}/shopJs/main.js"></script>

<script type="text/javascript">
	
</script>


<!-- <div class="fh5co-loader"></div> -->


		<nav class="fh5co-nav" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-xs-2">
						<div id="fh5co-logo">
							<a class="navbar-brand" href="<c:url value='/HappyTailIndex.jsp'/> " style="display: block; margin: auto;">
			<img src="img/logo210_1905.png" width="100" 
			style="display: block;margin-left: 110px">
		</a>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center menu-1">
						<ul>
						<li><a href="<c:url value='/shopIndex'/>">關於商城</a></li>
							<li class="has-dropdown"><a href="<c:url value='/showProduct2'/> " >前往商城</a>
								<ul class="dropdown">
									<li><a href="single.html">飼料</a></li>
									<li><a href="single.html">衣服</a></li>
									<li><a href="single.html">玩具</a></li>
								</ul></li>
							
							<li class="has-dropdown"><a href="<c:url value='/getOrderBean.do'/> ">我的訂單</a>
								<ul class="dropdown">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">eCommerce</a></li>
									<li><a href="#">Branding</a></li>
									<li><a href="#">API</a></li>
								</ul></li>
							<li><a href="<c:url value='/getFavorite.do'/>">我的最愛</a></li>
						</ul>
					</div>
			<div class="col-md-3 col-xs-4 text-right hidden-xs menu-2">
						<ul>
							<li class="search">
								<div class="input-group">
									<input type="text" placeholder="Search.."> <span
										class="input-group-btn">
										<button class="btn btn-primary" type="button">
											<i class="icon-search"></i>
										</button>
									</span>
								</div>
							</li>
							<li class="shopping-cart"><a href="<c:url value='/intoCart'/>" class="cart"><span><small>0</small><i
										class="icon-shopping-cart"></i></span></a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		
		
