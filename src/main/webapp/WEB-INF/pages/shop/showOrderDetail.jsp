<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

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

</head>
<body>
	<div id="page">
		<jsp:include page="shopTop.jsp" />
		<br>
		<header id="fh5co-header"
			class="fh5co-cover fh5co-cover-sm text-center" role="banner"
			style="background-image: url(images/order.jpg);">
			<div class="overlay "></div>
			<div class="container">
				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-center">

						<div class="display-t">

							<div class="display-tc animate-box " data-animate-effect="fadeIn">

								<h1>Order Detail</h1>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			
			

		</header>
		<div id="fh5co-product">
			<div class="container">

				<div class="row">

					<table class="table table-striped table-bordered display animate-box"
						style="text-align: center; vertical-align: middle;" >
						<thead>
							<tr>
								<th>商品編號</th>
								<th>商品名稱</th>
								<th>商品描述</th>
								<th>商品數量</th>
								<th>商品單價</th>
								<th>商品圖片</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="vs" var="li" items="${dlist}">
								<tr>
									<td>${li.pBean.getProductId()}</td>
									<td>${li.pBean.getName()}</td>
									<td>${li.getDescription()}</td>
									<td>${li.getQuantity()}</td>
									<td><fmt:formatNumber value='${li.pBean.getPrice()}'
											pattern="#,###" />元</td>
									<td><img
										width="40"
										src="data:image/jpg;base64,${li.pBean.getBiPhoto()}"
										alt="Card image cap"></td>

								</tr>
							</c:forEach>					
						</tbody>
						<tfoot>
							<tr>
							<td colspan="6">
							<a href="<c:url value='/getOrderBean.do'/>" class="btn btn-primary ">回訂單查詢</a>
							</td>
							</tr>
						</tfoot>
						
					</table>
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

					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<script>
		
	</script>
</body>
</html>