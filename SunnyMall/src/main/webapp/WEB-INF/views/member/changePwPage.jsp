<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>user login</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <script type="text/javascript" src="/js/member/changePw.js"></script>
 
  <!-- Bootstrap core CSS -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>
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
			
	    <%-- MAIN CONTENT --%> 
			<section class="content container-fluid">
				<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">
					<form id="changePwForm" method="post" action="/member/changePw">
						<h2 class="form-changepw-heading">비밀 번호 변경</h2>
						<br><br>
							<input type= "hidden" name="mb_id" value="${sessionScope.user.mb_id}" />
							<input type="password" class="form-control" id="mb_pw" class="form-control"
								placeholder="현재 비밀번호를 입력해주세요" style="max-width: 630px;">
							<input type="password" class="form-control" id="mb_pw_change" name="mb_pw" class="form-control"
								placeholder="변경할 비밀번호를 입력해주세요" style="max-width: 630px; margin: 7px 0px;">
							<input type="password" class="form-control" id="mb_pw_check" class="form-control"
								placeholder="변경할 비밀번호를 다시 입력해주세요" style="max-width: 630px;">
						<br><br><br>
						<div class="form-group">
							<input type="button" id="btn_submit" class="btn btn-primary" value="확인">
						</div>
					</form>
				</div>
			</section>
		<!-- /.content -->
	
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

   			
		