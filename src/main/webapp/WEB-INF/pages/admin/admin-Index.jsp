<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>後臺管理系統</title>
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
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-info">
								<div class="inner">
									<h3>${countProjects}</h3>


									<p>總商品數</p>
								</div>
								<div class="icon">
									<i class="ion ion-bag"></i>
								</div>
								<a href="admin-AllProjects" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-warning">
								<div class="inner">
									<h3>${count}</h3>
									<p>註冊人數</p>
								</div>
								<div class="icon">
									<i class="ion ion-person-add"></i>
								</div>
								<a href="admin-AllMembers" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>

						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-success">
								<div class="inner">
									<h3>${unchickOrders}</h3>

									<p>未處理訂單</p>
								</div>
								<div class="icon">
									<i class="fas fa-cart-arrow-down"></i>
								</div>
								<a href="admin-uncheckOrders" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-danger">
								<div class="inner">
									<h3>${sumPrice}</h3>
									<p>總銷售金額</p>
								</div>
								<div class="icon">
									<i class="fas fa-dollar-sign"></i>
								</div>
								<a href="admin-AllOrders" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
					</div>
				</div>
				<!-- LINE CHART -->
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">每月銷售金額</h3>

						<div class="card-tools">
							<button type="button" class="btn btn-tool" data-card-widget="collapse">
								<i class="fas fa-minus"></i>
							</button>
							<button type="button" class="btn btn-tool" data-card-widget="remove">
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div>
					<div class="card-body">
						<div class="chart">
							<canvas id="lineChart"
								style="min-height: 250px; height: 450px; max-height: 450px; max-width: 100%;"></canvas>
						</div>
					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->

				<div class="card card-dark">
					<div class="card-header">
						<h3 class="card-title">熱銷商品前三名</h3>
						<div class="card-tools">
							<a href="#" class="btn btn-tool btn-sm">
								<i class="fas fa-download"></i>
							</a>
							<a href="#" class="btn btn-tool btn-sm">
								<i class="fas fa-bars"></i>
							</a>
						</div>
					</div>
					<div class="card-body table-responsive p-0">
						<table class="table table-striped table-valign-middle">
							<thead>
								<tr>
									<th>商品編號</th>
									<th>商品名稱</th>
									<th>商品價格</th>
									<th>銷售量</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${top3[0][0]}</td>
									<td>${top3[0][1]}&emsp;<span class="badge bg-danger">HOT</span></td>
									<td>${top3[0][2]}</td>
									<td>${top3[0][3]}</td>
								</tr>
								<tr>
									<td>${top3[1][0]}</td>
									<td>${top3[1][1]}</td>
									<td>${top3[1][2]}</td>
									<td>${top3[1][3]}</td>
								</tr>
								<tr>
									<td>${top3[2][0]}</td>
									<td>${top3[2][1]}</td>
									<td>${top3[2][2]}</td>
									<td>${top3[2][3]}</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
				<!-- /.card -->

				<!-- PIE CHART -->
				<div class="row">
					<div class="col-md-6">
						<div class="card card-danger">
							<div class="card-header">
								<h3 class="card-title">男女比例</h3>

								<div class="card-tools">
									<button type="button" class="btn btn-tool" data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<button type="button" class="btn btn-tool" data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
							<div class="card-body">
								<canvas id="pieChart"
									style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
							</div>
							<!-- /.card-body -->
						</div>
					</div>
					<!-- /.card -->
					<div class="col-md-6">
						<!-- BAR CHART -->

						<div class="card card-success">
							<div class="card-header">
								<h3 class="card-title">會員年齡分布</h3>

								<div class="card-tools">
									<button type="button" class="btn btn-tool" data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<button type="button" class="btn btn-tool" data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
							<div class="card-body">
								<div class="chart">
									<canvas id="barChart"
										style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
								</div>
							</div>
							<!-- /.card-body -->

						</div>
						<!-- /.card -->
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

	//圓餅圖
	<script>
		$(function() {
			var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
			var pieData = {
				labels: [
			          '女性', 
			          '男性',
			      ],
			      datasets: [
			        {
			          data: [${female},${male}],
			          backgroundColor : ['#f56954','#00c0ef'],
			        }
			      ]
				}
			var pieOptions = {
				maintainAspectRatio : false,
				responsive : true,
			}
			var pieChart = new Chart(pieChartCanvas, {
				type : 'pie',
				data : pieData,
				options : pieOptions
			})
		})
	</script>

	//年齡分布
	<script>
	$(function() {
		var ctx = $('#barChart')
		var barChart = new Chart(ctx, {
			type: 'bar',
			data: {
			  labels: ['10-19', '20-29', '30-39', '40-49', '50-59', '60-69'],
			  datasets: [{
			   borderWidth: 1,
			     label: '人數',
			     data: [${list[0]}, ${list[1]}, ${list[2]}, ${list[3]}, ${list[4]}, ${list[5]}],
			  	 backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	             ],
	             borderColor: [
	                'rgba(255,99,132,1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	             ],
	             
	             borderWidth: 1
			  }]
			  },
			  options: {
				  scales: {
					  yAxes: [{
						  ticks: {
							  beginAtZero: true,
							  precision: 0
							  }
						  }]
					  }
				  }
		  
		    
			});
	})
	</script>

	//每月銷售金額
	<script>
	var lineChartCanvas = $('#lineChart').get(0).getContext('2d')


	
	var lineChart = new Chart(lineChartCanvas, { 
	      type: 'line',
	      data: {
	    	  labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	    	  datasets: [{
	    		  label: "金額",
	              lineTension: 0.1,
	              backgroundColor: "rgba(75,192,192,0.4)",
	              borderColor: "rgba(75,192,192,1)",
	              borderCapStyle: 'butt',
	              borderDash: [],
	              borderDashOffset: 0.0,
	              borderJoinStyle: 'miter',
	              pointBorderColor: "rgba(75,192,192,1)",
	              pointBackgroundColor: "#fff",
	              pointBorderWidth: 1,
	              pointHoverRadius: 5,
	              pointHoverBackgroundColor: "rgba(75,192,192,1)",
	              pointHoverBorderColor: "rgba(220,220,220,1)",
	              pointHoverBorderWidth: 2,
	              pointRadius: 5,
	              pointHitRadius: 10,         
	    		  data: [${list2[0]},${list2[1]},${list2[2]},${list2[3]},${list2[4]},${list2[5]},${list2[6]},${list2[7]},${list2[8]},${list2[9]},${list2[10]},${list2[11]}],
    			  borderWidth: 5
		    	  }  
	 		  ]
		      },
		      
		      options: {
		          scales: {
		              yAxes: [{
		                  ticks: {
		                	  fontSize: 20
		                  }
		              }],
		              xAxes: [{
		                  ticks: {
		                	  fontSize: 20
		                  }
		              }]
		          }
		      }
	    })
	</script>
</body>
</html>