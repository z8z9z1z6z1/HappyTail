<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>訂單管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>

<body class="hold-transition sidebar-mini">
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
				<img src="admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
					class="brand-image img-circle elevation-3" style="opacity: .8">
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
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>訂單資料</h1>
<%-- 							<a href='<c:url value='admin-changeOrderStatus-json/1' />'>Json</a> --%>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<div class="card">
								<!-- /.card-header -->
								<div class="card-body">
									<table id="allOrders" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>訂單編號</th>
												<th>會員姓名</th>
												<th>購買價格</th>
												<th>購買時間</th>
												<th>地址</th>
												<th>備註</th>
												<th>狀態</th>
												<th>修改</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>訂單編號</th>
												<th>會員姓名</th>
												<th>購買價格</th>
												<th>購買時間</th>
												<th>地址</th>
												<th>備註</th>
												<th>狀態</th>
												<th>修改</th>
											</tr>
										</tfoot>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b>
				3.0.5
			</div>
			<strong>
				Copyright &copy; 2014-2019
				<a href="http://adminlte.io">AdminLTE.io</a>
				.
			</strong>
			All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	
	<div class="modal fade" id="Topic">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">訂單明細</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="detail">
					<h4>總金額：</h4>
					<p id="totalPrice"></p> 
					<h4>購買時間：</h4>
					<p id="orderDate"></p>
					<table class="table table-striped" id="tbale">
                    	<thead>
                    		<tr>
                      			<th>編號</th>
                      			<th>商品名稱</th>
                      			<th>商品數量</th>
                      			<th>購買價格</th>
                   			</tr>
                  		</thead>
                  		<tbody id="tbody"></tbody>
                  </table>					
				</div>
				<div class="modal-footer justify-content-between">
					<button type="button" id="close" class="btn btn-default"data-dismiss="modal">關閉</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>





	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables -->
	<script src="${pageContext.request.contextPath}/admin/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/demo.js"></script>
	<!-- page script -->
	//所有訂單
	<script>
	$(document)
	.ready(
			function() {
				$('#allOrders')
						.DataTable(
								{
									searching : false,
									"ajax" : {
										"url" : "<c:url value='admin-UnchickOrdersList-json' />",
										"dataSrc" : ""
									},
									"columns" : [
											{
												"data" : "orderId"
											},
											{
												"data" : "memberId"
											},
											{
												"data" : "totalPrice"
											},
											{
												"data" : "orderDate"
											},
											{
												"data" : "shippingAddress"
											},
											{
												"data" : "text"
											},
											{
												"data" : "state",
												"render" : function(
														data, type,
														full, meta) {
													if (data == "完成") {
														return data = '<span class="badge badge-success">完成</span>';
													} else if (data == "未付款") {
														return data = '<span class="badge badge-secondary">未付款</span>';
													} else if (data == "已付款") {
														return data = '<span class="badge badge-warning">已付款</span>';
													} else if (data == "失敗") {
														return data = '<span class="badge badge-danger">失敗</span>';
													}
												}

											}

									],
									columnDefs : [ {
										//最後一行加上修改按鈕
										"data" : "orderId",
										targets : 7,
										orderable : false,
										render : function(data,
												type, row, meta) {
											return "<button type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#Topic' id='" + data + "'><i class='fas fa-eye'></i>查看訂單</button>&emsp;"
												+ "<a class='btn btn-default btn-sm' data-test='" + data + "'><i class='fas fa-pencil-alt'></i>出貨</a>";
										}
									} ]
								});
				$("#allOrders tbody").on("click", ".btn", function () {
					var id = $(this).data("test");
					$.ajax({
						async:false,
						type: "POST",
						url: "<c:url value='admin-changeOrderStatus-json/" + id + "' />",
						data: {},
						dataType: 'json',
						success: function() {
							alert("修改成功");
							$('#allOrders').DataTable().ajax.reload();
							}													
						})							              
	            });
			});
	</script>
	<script type="text/javascript">
		$(document).on('click', '.btn', function() {
			var id = $(this).attr("id");

			$.ajax({
				url : "<c:url value='admin-getOrderItem-json/" + id + "' />",
				method : "GET",
				async : false,
				data : {},
				dataType : "json",
				success : function(data) {
					var i=0;
					$.each(data, function() {
						$("#name").append(data[i]['description']);
						$("#unitPrice").append(data[i]['unitPrice']);
						$("#quantity").append(data[i]['quantity']);
						$("#totalPrice").empty().append(data[i]['orderBean']['totalPrice']);
						$("#orderDate").empty().append(data[i]['orderBean']['orderDate']);

						var tr="<tr>";
						tr += "<td>" + data[i]['seqno'] + "</td>";
						tr += "<td>" + data[i]['description'] + "</td>";
						tr += "<td>" + data[i]['quantity'] + "</td>";
						tr += "<td>" + data[i]['unitPrice'] + "</td>";
						tr += "</tr>";
						$('#tbody').append(tr);
						i++;
						})
				}
			})
		})
	</script>
	<script>
		$('#close').click(function() {
			$('#name').empty();
			$('#unitPrice').empty();
			$('#quantity').empty();
			$('#totalPrice').empty();
			$('#tbody').empty();
			})
	</script>
</body>

</html>