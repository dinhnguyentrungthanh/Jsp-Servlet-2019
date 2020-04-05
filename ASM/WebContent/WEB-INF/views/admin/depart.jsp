<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if (request.getSession().getAttribute("USER") == null) {
        response.sendRedirect("../login.htm");
    }
%>  
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta name="description" content="Responsive Admin Template">
<meta name="author" content="SmartUniversity">
<title>Depart |</title>
<link
	href=" <c:url value="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"/>"
	rel="stylesheet" type="text/css">
<!-- icons -->
<link
	href=" <c:url value="/assets/plugins/simple-line-icons/simple-line-icons.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href=" <c:url value="/fonts/font-awesome/css/font-awesome.min.css"  />"
	rel="stylesheet" type="text/css">
<link
	href=" <c:url value="/fonts/material-design-icons/material-icon.css"  />"
	rel="stylesheet" type="text/css">
<!--bootstrap -->
<link
	href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" media="screen">
<link
	href="<c:url value="/assets/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />"
	rel="stylesheet" media="screen">
<link
	href=" <c:url value="/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" />"
	rel="stylesheet" media="screen">
<!-- Material Design Lite CSS -->
<link rel="stylesheet"
	href="<c:url value="/assets/plugins/material/material.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/css/material_style.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/plugins/sweet-alert/sweetalert.min.css" />">
<!-- animation -->
<link href="<c:url value="/assets/css/pages/animate_page.css"/>"
	rel="stylesheet">
<!-- Theme Styles -->
<link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/assets/css/plugins.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/assets/css/pages/formlayout.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/assets/css/responsive.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/assets/css/theme-color.css"/>"
	rel="stylesheet" type="text/css">
<!-- dropzone -->
<link href="<c:url value="/assets/plugins/dropzone/dropzone.css" />"
	rel="stylesheet" media="screen">
<!--tagsinput-->
<link
	href="<c:url value="/assets/plugins/jquery-tags-input/jquery-tags-input.css"/>"
	rel="stylesheet">
<!--select2-->
<link href="<c:url value="/assets/plugins/select2/css/select2.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/assets/plugins/select2/css/select2-bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<!-- favicon -->
<link rel="shortcut icon"
	href="<c:url value="/assets/img/favicon.ico"/>">
<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
</head>
<!-- END HEAD -->
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
		<!-- start header -->
		<%@include file="/blocks/header.jsp"%>
		<!-- end header -->

		<!-- start page container -->
		<div class="page-container">
			<!-- start sidebar menu -->
			<%@include file="/blocks/sidebar.jsp"%>
			<!-- end sidebar menu -->
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Depart</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.jsp">Trang Chủ</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li><a class="parent-item" href="">Depart</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Depart</li>
							</ol>
						</div>
					</div>
					<div class="row" style="margin-top: 70px;">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-12">
									<div class="card-head">
										<header>Depart</header>
										<div class="tools">
											<a class="fa fa-repeat btn-color box-refresh"
												href="javascript:;"></a> <a
												class="t-collapse btn-color fa fa-chevron-down"
												href="javascript:;"></a> <a
												class="t-close btn-color fa fa-times" href="javascript:;"></a>
										</div>
									</div>
									<div class="card-body ">
									<div class="alert label-success alert-dismissible" role="alert">
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										${message}${message1}
									</div>
										<div class="table-responsive">
											<table
												class="table table-striped table-bordered custom-table table-hover">
												<thead>
													<tr>
														<th class="text-center">Mã Phòng Ban</th>
														<th class="text-center">Tên Phòng Ban</th>
														<th class="text-center">Thao Tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="d" items="${departs}">
														<tr>
															<td class="text-center">${d.id}</td>
															<td class="text-center">${d.name}</td>
															<td class="text-center">
																<button class="btn btn-primary btn-xs">
																	<a href='./update-depart.htm?id=${d.id}'><i class="fa fa-pencil"></i>
																	</a>
																</button>
																<button class="btn btn-danger btn-xs remove-item">
																	<a href="./delete-depart.htm?id=${d.id}"><i class="fa fa-trash-o "></i></a>
																</button>
															</td>
														</tr>
													</c:forEach>
												</tbody>
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
		<!-- end page content -->
		<!-- start chat sidebar -->
		<div class="chat-sidebar-container" data-close-on-body-click="false">
			<div class="chat-sidebar">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a href="#quick_sidebar_tab_1"
						class="nav-link active tab-icon" data-toggle="tab"> <i
							class="material-icons">chat</i>Chat <span
							class="badge badge-danger">4</span>
					</a></li>
					<li class="nav-item"><a href="#quick_sidebar_tab_3"
						class="nav-link tab-icon" data-toggle="tab"> <i
							class="material-icons">settings</i> Settings
					</a></li>
				</ul>
				<div class="tab-content">
					<!-- Start User Chat -->
					<div
						class="tab-pane active chat-sidebar-chat in active show animated slideInRight"
						role="tabpanel" id="quick_sidebar_tab_1">
						<div class="chat-sidebar-list">
							<div class="chat-sidebar-chat-users slimscroll-style"
								data-rail-color="#ddd" data-wrapper-class="chat-sidebar-list">
								<div class="chat-header">
									<h5 class="list-heading">Online</h5>
								</div>
								<ul class="media-list list-items">
									<li class="media"><img class="media-object"
										src="assets\img\user\user3.jpg" width="35" height="35"
										alt="..."> <i class="online dot"></i>
										<div class="media-body">
											<h5 class="media-heading">John Deo</h5>
											<div class="media-heading-sub">Spine Surgeon</div>
										</div></li>
									<li class="media">
										<div class="media-status">
											<span class="badge badge-success">5</span>
										</div> <img class="media-object" src="assets\img\user\user1.jpg"
										width="35" height="35" alt="..."> <i class="busy dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Rajesh</h5>
											<div class="media-heading-sub">Director</div>
										</div>
									</li>
									<li class="media"><img class="media-object"
										src="assets\img\user\user5.jpg" width="35" height="35"
										alt="..."> <i class="away dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Jacob Ryan</h5>
											<div class="media-heading-sub">Ortho Surgeon</div>
										</div></li>
									<li class="media">
										<div class="media-status">
											<span class="badge badge-danger">8</span>
										</div> <img class="media-object" src="assets\img\user\user4.jpg"
										width="35" height="35" alt="..."> <i class="online dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Kehn Anderson</h5>
											<div class="media-heading-sub">CEO</div>
										</div>
									</li>
									<li class="media"><img class="media-object"
										src="assets\img\user\user2.jpg" width="35" height="35"
										alt="..."> <i class="busy dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Sarah Smith</h5>
											<div class="media-heading-sub">Anaesthetics</div>
										</div></li>
									<li class="media"><img class="media-object"
										src="assets\img\user\user7.jpg" width="35" height="35"
										alt="..."> <i class="online dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Vlad Cardella</h5>
											<div class="media-heading-sub">Cardiologist</div>
										</div></li>
								</ul>
								<div class="chat-header">
									<h5 class="list-heading">Offline</h5>
								</div>
								<ul class="media-list list-items">
									<li class="media">
										<div class="media-status">
											<span class="badge badge-warning">4</span>
										</div> <img class="media-object" src="assets\img\user\user6.jpg"
										width="35" height="35" alt="..."> <i class="offline dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Jennifer Maklen</h5>
											<div class="media-heading-sub">Nurse</div>
											<div class="media-heading-small">Last seen 01:20 AM</div>
										</div>
									</li>
									<li class="media"><img class="media-object"
										src="assets\img\user\user8.jpg" width="35" height="35"
										alt="..."> <i class="offline dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Lina Smith</h5>
											<div class="media-heading-sub">Ortho Surgeon</div>
											<div class="media-heading-small">Last seen 11:14 PM</div>
										</div></li>
									<li class="media">
										<div class="media-status">
											<span class="badge badge-success">9</span>
										</div> <img class="media-object" src="assets\img\user\user9.jpg"
										width="35" height="35" alt="..."> <i class="offline dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Jeff Adam</h5>
											<div class="media-heading-sub">Compounder</div>
											<div class="media-heading-small">Last seen 3:31 PM</div>
										</div>
									</li>
									<li class="media"><img class="media-object"
										src="assets\img\user\user10.jpg" width="35" height="35"
										alt="..."> <i class="offline dot"></i>
										<div class="media-body">
											<h5 class="media-heading">Anjelina Cardella</h5>
											<div class="media-heading-sub">Physiotherapist</div>
											<div class="media-heading-small">Last seen 7:45 PM</div>
										</div></li>
								</ul>
							</div>
						</div>
						<div class="chat-sidebar-item">
							<div class="chat-sidebar-chat-user">
								<div class="page-quick-sidemenu">
									<a href="javascript:;" class="chat-sidebar-back-to-list"> <i
										class="fa fa-angle-double-left"></i>Back
									</a>
								</div>
								<div class="chat-sidebar-chat-user-messages">
									<div class="post out">
										<img class="avatar" alt="" src="assets\img\dp.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Kiran Patel</a> <span class="datetime">9:10</span>
											<span class="body-out"> could you send me menu icons ?
											</span>
										</div>
									</div>
									<div class="post in">
										<img class="avatar" alt="" src="assets\img\user\user5.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Jacob Ryan</a> <span class="datetime">9:10</span>
											<span class="body"> please give me 10 minutes. </span>
										</div>
									</div>
									<div class="post out">
										<img class="avatar" alt="" src="assets\img\dp.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Kiran Patel</a> <span class="datetime">9:11</span>
											<span class="body-out"> ok fine :) </span>
										</div>
									</div>
									<div class="post in">
										<img class="avatar" alt="" src="assets\img\user\user5.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Jacob Ryan</a> <span class="datetime">9:22</span>
											<span class="body">Sorry for the delay. i sent mail to
												you. let me know if it is ok or not.</span>
										</div>
									</div>
									<div class="post out">
										<img class="avatar" alt="" src="assets\img\dp.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Kiran Patel</a> <span class="datetime">9:26</span>
											<span class="body-out"> it is perfect! :) </span>
										</div>
									</div>
									<div class="post out">
										<img class="avatar" alt="" src="assets\img\dp.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Kiran Patel</a> <span class="datetime">9:26</span>
											<span class="body-out"> Great! Thanks. </span>
										</div>
									</div>
									<div class="post in">
										<img class="avatar" alt="" src="assets\img\user\user5.jpg">
										<div class="message">
											<span class="arrow"></span> <a href="javascript:;"
												class="name">Jacob Ryan</a> <span class="datetime">9:27</span>
											<span class="body"> it is my pleasure :) </span>
										</div>
									</div>
								</div>
								<div class="chat-sidebar-chat-user-form">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="Type a message here...">
										<div class="input-group-btn">
											<button type="button" class="btn deepPink-bgcolor">
												<i class="fa fa-arrow-right"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End User Chat -->
					<!-- Start Setting Panel -->
					<div class="tab-pane chat-sidebar-settings animated slideInUp"
						role="tabpanel" id="quick_sidebar_tab_3">
						<div class="chat-sidebar-settings-list slimscroll-style">
							<div class="chat-header">
								<h5 class="list-heading">Layout Settings</h5>
							</div>
							<div class="chatpane inner-content ">
								<div class="settings-list">
									<div class="setting-item">
										<div class="setting-text">Sidebar Position</div>
										<div class="setting-set">
											<select
												class="sidebar-pos-option form-control input-inline input-sm input-small ">
												<option value="left" selected="selected">Left</option>
												<option value="right">Right</option>
											</select>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Header</div>
										<div class="setting-set">
											<select
												class="page-header-option form-control input-inline input-sm input-small ">
												<option value="fixed" selected="selected">Fixed</option>
												<option value="default">Default</option>
											</select>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Sidebar Menu</div>
										<div class="setting-set">
											<select
												class="sidebar-menu-option form-control input-inline input-sm input-small ">
												<option value="accordion" selected="selected">Accordion</option>
												<option value="hover">Hover</option>
											</select>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Footer</div>
										<div class="setting-set">
											<select
												class="page-footer-option form-control input-inline input-sm input-small ">
												<option value="fixed">Fixed</option>
												<option value="default" selected="selected">Default</option>
											</select>
										</div>
									</div>
								</div>
								<div class="chat-header">
									<h5 class="list-heading">Account Settings</h5>
								</div>
								<div class="settings-list">
									<div class="setting-item">
										<div class="setting-text">Notifications</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-1"> <input type="checkbox"
													id="switch-1" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Show Online</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-7"> <input type="checkbox"
													id="switch-7" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Status</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-2"> <input type="checkbox"
													id="switch-2" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">2 Steps Verification</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-3"> <input type="checkbox"
													id="switch-3" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="chat-header">
									<h5 class="list-heading">General Settings</h5>
								</div>
								<div class="settings-list">
									<div class="setting-item">
										<div class="setting-text">Location</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-4"> <input type="checkbox"
													id="switch-4" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Save Histry</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-5"> <input type="checkbox"
													id="switch-5" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
									<div class="setting-item">
										<div class="setting-text">Auto Updates</div>
										<div class="setting-set">
											<div class="switch">
												<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
													for="switch-6"> <input type="checkbox"
													id="switch-6" class="mdl-switch__input" checked="">
												</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end chat sidebar -->
	</div>
	<!-- end page container -->
	<!-- start footer -->
	<%@include file="/blocks/footer.jsp"%>
	<!-- end footer -->
	</div>
	<!-- start js include path -->
	<script src="<c:url value="/assets/plugins/jquery/jquery.min.js" />"></script>
	<script src="<c:url value="/assets/plugins/popper/popper.min.js"/>"></script>
	<script
		src="<c:url value="/assets/plugins/jquery-blockui/jquery.blockui.min.js"/>"></script>
	<script
		src="<c:url value="/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"/>"></script>
	<!-- bootstrap -->
	<script
		src="<c:url value="/assets/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/assets/plugins/bootstrap-inputmask/bootstrap-inputmask.min.js"/>"></script>
	<script
		src="<c:url value="/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"/>"
		charset="UTF-8"></script>
	<script
		src="<c:url value="/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker-init.js"/>"
		charset="UTF-8"></script>
	<script
		src="<c:url value="/assets/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"/>"
		charset="UTF-8"></script>
	<script
		src="<c:url value="/assets/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker-init.js"/>"
		charset="UTF-8"></script>
	<!-- Common js-->
	<script src="<c:url value="/assets/js/app.js"/>"></script>
	<script src="<c:url value="/assets/js/layout.js"/>"></script>
	<script src="<c:url value="/assets/js/theme-color.js"/>"></script>
	<!-- Material -->
	<script src="<c:url value="/assets/plugins/material/material.min.js"/>"></script>
	<!-- animation -->
	<script src="<c:url value="/assets/js/pages/ui/animations.js"/>"></script>
	<!-- Sweet Alert -->
	<script
		src="<c:url value="/assets/plugins/sweet-alert/sweetalert.min.js"/>"></script>
	<!--tags input-->
	<script
		src="<c:url value="/assets/plugins/jquery-tags-input/jquery-tags-input.js"/>"></script>
	<script
		src="<c:url value="/assets/plugins/jquery-tags-input/jquery-tags-input-init.js"/>"></script>
	<!--select2-->
	<script src="<c:url value="/assets/plugins/select2/js/select2.js"/>"></script>
	<script src="<c:url value="/assets/js/pages/select2/select2-init.js"/>"></script>

</body>
</html>
