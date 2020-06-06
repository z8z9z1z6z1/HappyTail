<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- CSS  -->
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
		$('.sidenav').sidenav({
			// 側邊導覽列從右邊展開
			edge : 'right',
			// 側邊導覽列打開時，頁面仍可滑動
			preventScrolling : false
		})
		$(".dropdown-trigger").dropdown({
			belowOrigin : false,
		});
		$('.tabs').tabs({
		// swipeable: true,
		});
	})
</script>
<header>
	<nav class="nav-extended white">
		<div class="nav-wrapper ffffff white" style="height: 210px;">
			<a href="#!" class="brand-logo center"><img src="<c:url value='/img/logo210_1905.png'/>"/></a> <a href="#"
				class="right sidenav-trigger show-on-medium-and-up"
				data-target="side-nav"> <i class="material-icons md-dark">menu</i>
			</a>
			<ul class="right hide-on-med-and-down">
				<!-- <ul class="right sidenav-trigger show-on-medium-and-up"> -->

				<li><a href=""><i class="material-icons md-dark">search</i></a></li>
				<li>
					<c:if test="${empty LoginOK}">
						<a href="<c:url value='login' />" title="登入"><i class="material-icons md-dark">person</i></a> 
					</c:if>
					<c:if test="${ !empty LoginOK }">
			   			<a href="<c:url value='logoutCheck' />" title="登出"><i class="material-icons md-dark">person</i></a>
					</c:if>							
					
				</li>
				<li><a class="dropdown-trigger" href="#!"
					data-target="dropdown1"><i class="material-icons md-dark">notifications</i></a></li>
			</ul>
		</div>

		<div class="nav-content grey lighten-4">
			<ul class="tabs tabs-transparent">
				<li class="tab"><a href="#Home"
					style="color: rgba(0, 0, 0, 0.54); font-size: 16px; font-family: Arial, Helvetica, sans-serif">Home</a>
				</li>
				<li class="tab"><a class="active" href="#Aboutus"
					style="color: rgba(0, 0, 0, 0.54); font-size: 16px; font-family: Arial, Helvetica, sans-serif">About
						us</a></li>
				<li class="tab"><a class='dropdown-trigger' href='OurServices'
					data-target='dropdown2'
					style="color: rgba(0, 0, 0, 0.54); font-size: 16px; font-family: Arial, Helvetica, sans-serif">Our
						Services</a></li>
				<li class="tab"><a href="#ContactUs"
					style="color: rgba(0, 0, 0, 0.54); font-size: 16px; font-family: Arial, Helvetica, sans-serif">Contact
						Us</a></li>
			</ul>
		</div>
	</nav>
	
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.sidenav').sidenav({
                // 側邊導覽列從右邊展開
                edge: 'right',
                // 側邊導覽列打開時，頁面仍可滑動
                preventScrolling: false
            })
            $(".dropdown-trigger").dropdown({
                belowOrigin: false,
            });
            $('.tabs').tabs({
                // swipeable: true,
            });
        })
    </script>

	<a class="dropdown-trigger" href="#!" data-target="dropdown2"></a>

	<ul class="sidenav grey lighten-1" id="side-nav">
		<li id="side-nav-logo"
			style="color: white; font-family: fantasy; font-size: 18px;"><img src="<c:url value='/img/logo_white3.png'/>"/>Happy Tail</li>
		<li><a class="sidenav-close grey-text text-darken-3 waves-effect"
			href="#home">Home</a></li>
		<li><a class="sidenav-close grey-text text-darken-3 waves-effect"
			href="#notice">Notice</a></li>
		<li>
			<c:if test="${!empty LoginOK}">
				<a class="sidenav-close grey-text text-darken-3 waves-effect"				
				href="<c:url value='memberCenter' /> ">Personal Profile</a>
			</c:if>
			<c:if test="${empty LoginOK}">
				<a class="sidenav-close grey-text text-darken-3 waves-effect"				
				href="<c:url value='login' />">Personal Profile</a>
			</c:if>	
		</li>
		<li><a class="sidenav-close grey-text text-darken-3 waves-effect"
			href="<c:url value='shopIndex' />">Online Shop</a></li>
		<li><a class="sidenav-close grey-text text-darken-3 waves-effect"
			href="#Reservation Service">Reservation Service</a></li>
		<li><a class="sidenav-close grey-text text-darken-3 waves-effect"
			href="#Pet Forum">Pet Forum</a></li>
		<li>
			<div class="divider"></div>
		</li>
		<li><a class="subheader">Learn More About Us</a></li>
	</ul>

	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">one</a></li>
		<li><a href="#!">two</a></li>
		<li class="divider"></li>
		<li><a href="<c:url value='pageBackView?pageNum=1' />">reservation</a></li>
		<li><a href="#!">three</a></li>
		<li><a href="#!">three</a></li>
		<li><a href="#!">three</a></li>
		<li><a href="#!">three</a></li>
	</ul>

	<!-- Dropdown Structure -->
	<ul id='dropdown2' class='dropdown-content'>
		<li><a href="<c:url value='ToShopIndex' />">Online Shop</a></li>
		<li class="divider"></li>
		<li><a href="<c:url value='/Evaluationlist' />">Reservation Service</a></li>
		<li class="divider"></li>
		<li><a href="#!">Pet Forum</a></li>
	</ul>
	
</header>