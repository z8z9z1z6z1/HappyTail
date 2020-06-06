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

								<h1>show order</h1>

							</div>
						</div>
					</div>
				</div>
			</div>




		</header>
		<div id="fh5co-product">
			<div class="container">

				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="fh5co-tabs animate-box">
							<ul class="fh5co-tab-nav ">
								<li class="active"><a href="#" data-tab="1"> <!-- 									<span class="icon visible-xs"> -->
										<span class="hidden-xs">全部訂單</span>
								</a></li>
								<li><a href="#" data-tab="2"><span class="hidden-xs">未付款訂單</span></a></li>
								<li><a href="#" data-tab="3"><span class="hidden-xs">已失效訂單</span></a></li>
							</ul>


							<div class="fh5co-tab-content-wrap">

								<div class="fh5co-tab-content tab-content active"
									data-tab-content="1">
									<div class="col-md-10 col-md-offset-1">

										<div class="row">

											<table id="example" class="display" style="width: 100%">
												<thead>
													<tr>
														<th>訂單編號</th>
														<th>訂單備註</th>
														<th>訂單總價</th>
														<th>訂單日期</th>
														<th>訂單狀態</th>
														<th>查看明細</th>
													</tr>
												</thead>
												<c:forEach varStatus="vs" var="ol" items="${orderList}">
													<tr>
														<td>${ol.getOrderId()}</td>
														<td>${ol.getText()}</td>
														<td><fmt:formatNumber value='${ol.getTotalPrice()}'
																pattern="#,###" />元</td>
														<td>${ol.getOrderDate()}</td>
														<td>${ol.getState()}</td>
														<td><input type="button" class='btn btn-primary '
															value='查看'
															onclick="document.getElementById('${ol.getOrderId()}').submit();">
															<form
																action="<c:url value='/getOrderDtail.do${ol.getOrderId()}'/>"
																method="post" id='${ol.getOrderId()}'>
																<Input type='hidden' value='${ol.getOrderId()}'>
															</form></td>
													</tr>
												</c:forEach>

											</table>
										</div>

									</div>
								</div>

								<div class="fh5co-tab-content tab-content " data-tab-content="2">
									<div class="col-md-10 col-md-offset-1">
										<div class="row">

											<table id="example" class="display" style="width: 100%">
												<thead>
													<tr>
														<th>訂單編號</th>
														<th>訂單備註</th>
														<th>訂單總價</th>
														<th>訂單日期</th>
														<th>訂單狀態</th>
														<th>查看明細</th>
														<th>前往付款</th>
													</tr>
												</thead>
												<c:forEach varStatus="vs" var="ol2" items="${orderList2}">
													<tr>
														<td>${ol2.getOrderId()}</td>
														<td>${ol2.getText()}</td>
														<td><fmt:formatNumber value='${ol2.getTotalPrice()}'
																pattern="#,###" />元</td>
														<td>${ol2.getOrderDate()}</td>
														<td>${ol2.getState()}</td>
														<td><input type="button" class='btn btn-primary '
															value='查看'
															onclick="document.getElementById('m${ol2.getOrderId()}').submit();">
															<form
																action="<c:url value='/getOrderDtail.do${ol2.getOrderId()}'/>"
																method="POST" id='m${ol2.getOrderId()}'>
																<Input type='hidden' value='${ol2.getOrderId()}'>
															</form></td>
														<td>													
															<input type="button" class='btn btn-primary '
															value='付款'
															onclick="document.getElementById('g${ol2.getOrderId()}').submit();">
															<form
																action="<c:url value='/getGreen.do${ol2.getOrderId()}'/>"
																method="POST" id='g${ol2.getOrderId()}'>
																<Input type='hidden' value='${ol2.getOrderId()}'>
															</form>
															
															</td>
													</tr>
												</c:forEach>

											</table>

										</div>
									</div>
								</div>
								<div class="fh5co-tab-content tab-content " data-tab-content="3">
									<div class="col-md-10 col-md-offset-1">
										<div class="row">

											<table id="example" class="display" style="width: 100%">
												<thead>
													<tr>
														<th>訂單編號</th>
														<th>訂單備註</th>
														<th>訂單總價</th>
														<th>訂單日期</th>
														<th>訂單狀態</th>
														<th>查看明細</th>
													</tr>
												</thead>
												<c:forEach varStatus="vs" var="ol3" items="${orderList3}">
													<tr>
														<td>${ol3.getOrderId()}</td>
														<td>${ol3.getText()}</td>
														<td><fmt:formatNumber value='${ol3.getTotalPrice()}'
																pattern="#,###" />元</td>
														<td>${ol3.getOrderDate()}</td>
														<td>${ol3.getState()}</td>
														<td><input type="button" class='btn btn-primary '
															value='查看'
															onclick="document.getElementById('my${ol3.getOrderId()}').submit();">
															<form
																action="<c:url value='/getOrderDtail.do/getOrderDtail.do${ol3.getOrderId()}'/>"
																method="POST" id='my${ol3.getOrderId()}'>
																<Input type='hidden' value='${ol3.getOrderId()}'>
															</form></td>
													</tr>
												</c:forEach>

											</table>

										</div>
									</div>

								</div>
							</div>

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