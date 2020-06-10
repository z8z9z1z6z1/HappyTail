<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>更新商品</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" data-widget="pushmenu" href="#" role="button">
						<i class="fas fa-bars"></i>
					</a>
				</li>
				<li class="nav-item d-none d-sm-inline-block">
					<a href="admin-Index" class="nav-link">Home</a>
				</li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
				<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="admin-Index" class="brand-link">
<%-- 				<img src="${pageContext.request.contextPath}/admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" --%>
<!-- 					class="brand-image img-circle elevation-3" style="opacity: .8"> -->
				<span class="brand-text font-weight-light">後臺管理</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
						data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item">
							<a href="admin-Index" class="nav-link">
								<i class="nav-icon fas fa-tachometer-alt"></i>
								<p>後台首頁</p>
							</a>
						</li>

						<li class="nav-item">
							<a href="admin-AllMembers" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>會員資料管理</p>
							</a>
						</li>

						<li class="nav-item has-treeview">
							<a href="#" class="nav-link active">
								<i class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									線上商城
									<i class="right fas fa-angle-left"></i>
								</p>
							</a>
							<ul class="nav nav-treeview">

								<li class="nav-item">
									<a href="admin-InsertProject" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>新增商品</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-AllProjects" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>商品列表</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-AllOrders" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>訂單列表</p>
									</a>
								</li>
							</ul>
						</li>

						<li class="nav-item">
							<a href="<c:url value='/pageBackView?pageNum=1' />" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>預約管理</p>
							</a>
						</li>

						<li class="nav-item">
							<a href="admin-forum" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>討論區管理</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="admin-happyTail" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>回首頁</p>
							</a>
						</li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6"></div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>
			<section class="content">
				<!-- general form elements -->
				<div class="container-fluid">
					<div class="card card-info">
						<div class="card-header">
							<h3 class="card-title">更新商品</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<c:url var="formAction" value="/update-product"/>
						<form:form method="POST" modelAttribute="productBean" action="${formAction}" enctype='multipart/form-data'>
							<div class="card-body">
								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<label for="exampleInputEmail1">商品名稱</label>
											<form:input path='name' class="form-control" />
											<form:hidden path='productId'/>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="exampleInputPassword1">商品價格</label>
											<form:input path='price' class="form-control" />
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="exampleInputPassword1">商品庫存</label>
											<form:input path='amount' class="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
								<div class="col-sm-6">
								<div class="form-group">
									<label for="exampleInputPassword1">商品種類</label>
									<form:select path='categoryId' class="form-control">
										<option>選擇商品種類</option>
										<option value='1'>飼料</option>
										<option value='2'>衣服</option>
										<option value='3'>玩具</option>
									</form:select>
								</div>
								</div>
								<div class="col-sm-6">
								<div class="form-group">
									<label for="exampleInputPassword1">商品狀態</label>
									<form:select path='status' class="form-control">
										<option>選擇狀態</option>
										<option value='1'>上架</option>
										<option value='2'>下架</option>
									</form:select>
								</div>
								</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">商品描述</label>
									<form:input path='descriptrion' class="form-control" />
								</div>
								<div class="form-group">
									<label for="exampleInputFile">照片</label>
									<div class="input-group">
										<div class="custom-file">
											<form:input path='productImage' type='file'/>
										</div>

									</div>
								</div>
							</div>
							<!-- /.card-body -->

							<div class="card-footer">
								<button type="submit" class="btn btn-primary float-right">送出</button>
								<button type="reset" class="btn btn-default float-right">取消</button>
							</div>
						</form:form>
					</div>
				</div>

			</section>
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<strong>
				Copyright &copy; 2014-2019
				<a href="http://adminlte.io">AdminLTE.io</a>
				.
			</strong>
			All rights reserved.
			<div class="float-right d-none d-sm-inline-block">
				<b>Version</b>
				3.0.5
			</div>
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${pageContext.request.contextPath}/admin/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="${pageContext.request.contextPath}/admin/plugins/sparklines/sparkline.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/demo.js"></script>
</body>
</html>