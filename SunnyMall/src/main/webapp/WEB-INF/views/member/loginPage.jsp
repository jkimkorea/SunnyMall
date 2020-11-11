<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>user login</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <script type="text/javascript" src="/js/member/member_login.js"></script>
 
  <!-- Bootstrap core CSS -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>

<script type="text/javascript">
	if("${msg}"== "LOGIN_FAIL"){
		alert("로그인에 실패했습니다.\n 아이디와 비밀번호를 확인해 주세요.");
	}else{
		
	}
</script>
</head>

<body>
  <!-- Navigation -->
  <%@ include file="/WEB-INF/views/include/home_header.jsp" %>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
 	  <div class="col-lg-3">
      	<!-- sidebar -->
 		<%@ include file="/WEB-INF/views/include/home_sidebar.jsp" %>
      </div>
      
      <!-- /.col-lg-3 -->
      <div class="col-lg-9">
    	<section class="content-header">
			<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">
				<form id="loginForm" class="form-signin" action="/member/login" method="post" style="padding:50px 30px;">
						<h2 class="form-signin-heading">Please sign in</h2>
						<br><br>
						<label for="inputId" class="sr-only">Id</label> 
						<input type="text" id="mb_id" name="mb_id" class="form-control" style="margin-bottom: 15px"
							placeholder="Id" required autofocus> 
						<label for="inputPassword" class="sr-only">Password</label> 
						<input type="password" id="mb_pw" name="mb_pw" class="form-control"placeholder="Password" required>
						<div class="checkbox">
							<label> <input type="checkbox" name="useCookie" />
								Remember me
							</label>
						</div>
						<br><br><br>
						<button id="btn_login" class="btn btn-lg btn-primary btn-block" type="submit"  >
							Sign in
						</button>
				</form>
			 </div>
		 </section>
		</div>
    	<!-- /.col-lg-9 -->
      </div>
      <!-- /.row -->
    </div>
    <!-- /.container -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>

</body>
</html>