<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>

	<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
	
</head>
<body>
	<%@include file="/HappytailHeader.jsp" %>
<%-- 	<jsp:include page="/HappytailHeader.jsp" /> --%>
	
	

	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-ride="carousel" style='z-index: 0'>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/first.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/second.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
			<div class="carousel-item" >
				<img src="img/third.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<h3
				style="font-family: Arial, Helvetica, sans-serif; color: rgb(123, 183, 243); margin: auto;">We
				Have Everything Your Pet Needs.</h3>
		</div>
	</div>
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-sm">
				<div style="width: 80px; margin: auto;">
					<div
						style="stroke-width: 0; fill-opacity: 1; stroke: rgba(143, 211, 232, 1); stroke-opacity: 1; fill: rgba(143, 211, 232, 1)"
						class="style-imm05wai_comp-imm05np1 style-imm05wai_non-scaling-stroke style-imm05waisvg"
						id="comp-imm05np1svg">
						<svg preserveAspectRatio="xMidYMid meet"
							id="comp-imm05np1svgcontent" data-bbox="18 29.5 163.901 141"
							xmlns="http://www.w3.org/2000/svg" viewBox="18 29.5 163.901 141"
							role="img">
                            <g>
                                <path
								d="M157.8 48c-15.5-11.9-36-18.5-57.8-18.5-21.8 0-42.3 6.6-57.8 18.5C26.6 60.1 18 76.1 18 93.3c0 17.1 8.6 33.2 24.2 45.2 15.5 11.9 36 18.5 57.8 18.5h.9c10.6-.2 13.9-.1 14.9 0 12.5 12.8 17.8 13.5 18.7 13.5h1.6l6.4-22.8c11.6-5.5 21.4-13.2 28.2-22.3 7.3-9.7 11.2-20.8 11.2-32.2.1-17.1-8.5-33.1-24.1-45.2zM140 144.4l-.9.4-5.9 21c-2.2-1-6.9-3.9-14.8-12.1-.6-.6-1-1-8.1-1-2.3 0-5.4 0-9.5.1h-.9C57 152.8 22 126 22 93.2c0-32.9 34.9-59.6 77.9-59.6 42.9 0 77.9 26.8 77.9 59.6.1 20.9-14.4 40.5-37.8 51.2z">
                                </path>
                                <path
								d="M126.2 65.8c-13.5-5.8-22.2.2-26.5 6.3-3.5-5.3-11.1-12.5-25.6-6.3-7 3-11 8.8-11.4 16.3-.3 7.1 2.8 15.4 8.7 23.2 6.4 8.4 15.7 16.1 27 22.1l1 .5 1-.5c26.2-14 37.3-33.2 36.8-46-.3-7.1-4.2-12.7-11-15.6zm-26.7 57.5c-23.2-12.7-33.1-29.7-32.6-41 .3-5.9 3.3-10.3 8.9-12.7 3.3-1.4 6.2-2 8.7-2 8.1 0 12 6.3 13.4 9.6l1.9 4.3 1.9-4.3c.3-.8 2.3-4.8 6.4-7.4 4.5-2.8 10.1-2.9 16.6-.1 5.3 2.3 8.3 6.4 8.5 12.1.4 10.9-9.9 28.5-33.7 41.5z">
                                </path>
                            </g>
                        </svg>
					</div>
				</div>

				<div
					style="margin: auto; text-align: center; margin-top: 30px; color: rgba(143, 211, 232, 1); margin-bottom: 80px;">
					<h3>Our Story</h3>
					<button class="btn btn-primary" type="submit">Read More>></button>
				</div>
			</div>
			<div class="col-sm">
				<div style="width: 80px; margin: auto;">
					<div
						style="stroke-width: 0; fill-opacity: 1; stroke: rgba(143, 211, 232, 1); stroke-opacity: 1; fill: rgba(143, 211, 232, 1)"
						class="style-imm05wai_comp-imm4hbw6 style-imm05wai_non-scaling-stroke style-imm05waisvg"
						id="comp-imm4hbw6svg">
						<svg preserveAspectRatio="xMidYMid meet"
							id="comp-imm4hbw6svgcontent"
							data-bbox="4.999 13.89 190.045 172.11"
							xmlns="http://www.w3.org/2000/svg"
							viewBox="4.999 13.89 190.045 172.11" role="img">
                            <g>
                                <path
								d="M144.8 72c-17.7-7.5-29.9-3.8-37.1.7-5.9 3.7-9.7 8.6-12 12.2C90 75.3 76.1 60.1 48.2 72c-12.7 5.4-19.9 15.9-20.5 29.5-.6 13.1 5.1 28.2 16.1 42.7C55.6 159.9 73 174.1 94 185.3l1.2.7 1.2-.7c21.4-11.4 39.2-25.9 51.4-41.8 11.4-14.8 17.4-30.1 16.8-43.2-.5-13-7.6-23.1-19.8-28.3zm-1.1 68.3c-11.6 15-28.3 28.8-48.5 39.7-19.8-10.8-36.1-24.3-47.3-39-10.2-13.5-15.6-27.5-15-39.3.5-11.7 6.5-20.3 17.4-24.9 6.5-2.8 12.1-3.9 16.9-3.9 15.9 0 23.3 12.3 26.1 18.7l2.4 5.5 2.4-5.5c1.3-2.9 13.4-28.2 44.7-14.8 10.4 4.5 16.2 12.7 16.7 23.7.5 11.9-5.1 26-15.8 39.8z">
                                </path>
                                <path
								d="M54.8 64c3.9 0 9.1-.9 15.8-2.1l.4-.1c3.1-.5 8.3-3.2 7.7-14.7-.3-6.1-2.2-13.9-5.1-20.8-3.3-8-6.7-12.1-9.9-12.4-8.7-.5-19.1 17.1-20 29.8-.6 8.7-.3 14.7 3.3 17.9 1.9 1.7 4.4 2.4 7.8 2.4zm-5.9-19.9c.4-5.2 2.7-11.8 6.1-17.2 3.6-5.7 6.7-7.7 8.1-7.7 1 .5 3.8 4.1 6.7 12.2 2.7 7.5 4 15 3.5 19.9-.5 4.9-2.6 5.3-3.3 5.4l-.4.1c-10.2 1.8-17 3-19.3.9-1.5-1.5-1.9-5.5-1.4-13.6z">
                                </path>
                                <path
								d="M41 67.3c4.4-6-3.3-21.9-4.9-25-2.8-5.4-8.2-14.5-13.4-14.5C14.1 27.8 4.9 46 5 58.9c.1 13.5 3.3 21.5 9.7 23.5 1.1.4 2.2.5 3.3.5 9.4 0 19.5-10.9 23-15.6zM16.3 77.4c-3.9-1.3-6-7.9-6.1-18.6 0-5.2 1.8-11.9 4.8-17.6 3.2-6 6.3-8.3 7.6-8.3 1.6.3 6.8 6.3 11.2 16.9 3.5 8.5 3.7 13.3 2.9 14.3-4.9 6.8-14.7 15.1-20.4 13.3z">
                                </path>
                                <path
								d="M128.9 61.4l.4.1c8.2 2.8 13.9 4.7 18.2 4.7 2 0 3.8-.4 5.3-1.4 4-2.6 5.2-8.5 5.9-17.2 1-12.8-6.6-31.7-15.2-32.4-3.3-.3-7.2 3.3-11.7 10.7-3.9 6.4-7 13.8-8.2 19.8-2.4 11.3 2.3 14.7 5.3 15.7zm14.1-41zm-14.8 30.2c.2-5 2.6-12.1 6.4-19.1 4.1-7.6 7.5-10.7 8.5-11 1.4.2 4.2 2.7 6.9 8.8 2.5 5.8 3.9 12.7 3.4 17.9-.7 8.1-1.7 12-3.6 13.2-2.6 1.7-9.1-.5-18.9-3.8l-.4-.1c-.6-.3-2.5-.9-2.3-5.9z">
                                </path>
                                <path
								d="M181.9 35c-5.2-.8-11.9 7.4-15.5 12.3-2 2.8-12.1 17.4-8.6 24 2.9 5.5 12.2 19 22 19 .6 0 1.1 0 1.7-.1 6.6-1.1 11-8.4 13.2-21.8 1.9-12.7-4.3-32.1-12.8-33.4zm-.8 5.1zm8.4 27.5c-1.7 10.6-4.8 16.8-8.8 17.5-5.9 1-14.3-8.8-18.2-16.1-.6-1.1.3-5.8 5-13.7 6-9.8 12-15 13.6-15 1.3.2 4 2.9 6.3 9.3 2.1 5.9 2.9 12.8 2.1 18z">
                                </path>
                            </g>
                        </svg>
					</div>
				</div>
				<div
					style="margin: auto; text-align: center; margin-top: 30px; color: rgba(143, 211, 232, 1); margin-bottom: 80px;">
					<h3>What We Do</h3>
					<button class="btn btn-primary" type="submit">Read More>></button>
				</div>
			</div>
			<div class="col-sm">
				<div style="width: 80px; margin: auto;">
					<div
						style="stroke-width: 0; fill-opacity: 1; stroke: rgba(143, 211, 232, 1); stroke-opacity: 1; fill: rgba(143, 211, 232, 1)"
						class="style-imm05wai_comp-imm4hb8l style-imm05wai_non-scaling-stroke style-imm05waisvg"
						id="comp-imm4hb8lsvg">
						<svg preserveAspectRatio="xMidYMid meet"
							id="comp-imm4hb8lsvgcontent" data-bbox="20 20 160 160"
							xmlns="http://www.w3.org/2000/svg" viewBox="20 20 160 160"
							role="img">
                            <g>
                                <path
								d="M100 20c-44.1 0-80 35.9-80 80s35.9 80 80 80 80-35.9 80-80-35.9-80-80-80zm0 155.3c-41.5 0-75.3-33.8-75.3-75.3S58.5 24.7 100 24.7s75.3 33.8 75.3 75.3-33.8 75.3-75.3 75.3z">
                                </path>
                                <path
								d="M152.7 96.5h-39.1v-1c-.1-2.9-1.8-5.3-4.5-6.5-1.2-.5-2.4-.8-3.4-.9V56.3c0-3.9-3.1-7-7-7h-.3c-3.9 0-7 3.1-7 7v32.6c-.1 0-.1 0-.2.1-2.8 1.2-4.5 3.6-4.6 6.7-.2 5.6 4.6 11.9 12.3 16.1l1.1.6 1.1-.6c.5-.3 1.1-.6 1.6-.9h50.1c3.9 0 7-3.1 7-7v-.3c-.1-4-3.3-7.1-7.1-7.1zM95.9 56.3c0-1.3 1-2.3 2.3-2.3h.3c1.3 0 2.3 1 2.3 2.3v33c-.3.2-.6.4-.9.7-1.1-1-2.4-1.7-4-1.9V56.3zm3.9 50.6c-6.1-3.6-8.8-8.2-8.7-11.1.1-1.2.6-2.1 1.8-2.6.6-.3 1.4-.5 2.1-.5 1 0 2 .5 2.7 2.1l2.1 4.9 2.1-4.9c.4-.9 1.7-3 5.1-1.5 1.1.5 1.6 1.2 1.7 2.4.3 2.9-2.8 7.6-8.9 11.2zm55.2-3.2c0 1.3-1 2.3-2.3 2.3h-44.2c1.5-1.6 2.8-3.3 3.6-4.9h40.5c1.3 0 2.3 1 2.3 2.3v.3z">
                                </path>
                            </g>
                        </svg>
					</div>
				</div>
				<div
					style="margin: auto; text-align: center; margin-top: 30px; color: rgba(143, 211, 232, 1); margin-bottom: 80px;">
					<h3>Opening Hours!</h3>
					<button class="btn btn-primary" type="submit">Read More>></button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<%@include file="/HappytailFooter.jsp" %>
	
<%-- 	<jsp:include page="/HappytailFooter.jsp" /> --%>
	
	
</body>
</html>