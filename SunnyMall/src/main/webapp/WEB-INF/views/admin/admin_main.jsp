<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <script>
    	if("${msg}" == "LOGIN_SUCCESS"){
    	 	alert("로그인 되었습니다.");
    	}else if("${msg}" == "LOGIN_FAIL"){
    		alert("아이디와 비밀번호를 확인해 주세요.");
    	}
    </script>
</head>
	<!-- REQUIRED JS SCRIPTS -->
	<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
	<%@include file="/WEB-INF/views/include/admin_header.jsp" %>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@include file="/WEB-INF/views/include/header.jsp" %>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="/WEB-INF/views/include/admin_sidebar.jsp" %>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<ol class="breadcrumb">
					<li>
						<a href="#"><i class="fa fa-dashboard"></i> Level</a>
					</li>
					<li class="active">Here</li>
				</ol>
				<c:if test="${sessionScope.admin ==null}">
				<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">
					<form id="loginForm" class="form-signin" action="/admin/adminLogin" method="post" style="padding:50px 30px;">
						<h2 class="form-signin-heading">Please sign in</h2>
							<br><br>
							<label for="inputId" class="sr-only">Id</label> 
							<input type="text" id="admin_id" name="admin_id" class="form-control" style="margin-bottom: 15px"
									placeholder="Id" required autofocus> 
							<label for="inputPassword" class="sr-only">Password</label> 
							<input type="password" id="admin_pw" name="admin_pw" class="form-control"
									placeholder="Password" required>
							<br><br><br>
							<button id="btn_login" class="btn btn-lg btn-primary btn-block" 
									type="submit"  >Sign in</button>
					</form>
				</div>
				</c:if>
				<%-- 로그인 한 상태 --%>
			    <c:if test="${sessionScope.admin != null}">
					<sapn>로그인이 완료되었습니다. 메뉴를 선택해 주세요.</sapn>
				</c:if>
			</section>

			<!-- Main content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
		
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>
