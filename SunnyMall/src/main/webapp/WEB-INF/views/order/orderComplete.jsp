<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <title>user login</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>

  <script type="text/javascript" src="/js/order/order_Complete.js"></script>
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
			 	<form id="orderForm" method="post" action="/order/orderFromCart">
					<div class="box" style="border: none; padding:200px 50px; text-align: center;">
						<div class="box-body"  >
							<h3>해당 상품의 주문이 완료되었습니다.</h3><br>
							<button type="button" id="btn_orderList" class="btn btn-info">주문내역 확인</button>
							<button type="button" id="btn_main" class="btn btn-primary">쇼핑 계속하기</button>
						</div>
					</div>
			  	</form>
				</section>
		
			</div>
		</div>
   
	</div>
    <!-- /.container -->
  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
 
</body>

</html>