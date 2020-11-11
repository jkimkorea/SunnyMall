<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Homepage - Start Bootstrap Template</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>

  <script type="text/javascript">
  	var cart_click = function(prd_no){
  		$.ajax({
  			url:'/cart/add',
  			type:'post',
  			dataType:'text',
  			data:{prd_no:prd_no},
  			success:function(data){
	  				var result = confirm("장바구니에 추가되었습니다.\n지금 확인 하시겠습니까?");
	  					if(result){
	  				location.href="/cart/cartList";
	  				}else{}
  			}
  		});
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

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
		<div class="content-header">
				<h1>
					Product List 
				</h1>
				<%-- realPath 주석 
				<%= application.getRealPath("/") %>
				--%>
				<ol class="breadcrumb">
					<li>
						<a href="#">${cg_name}</a>
					</li>
				</ol>
		</div>
        <div class="row">
       		<div class="col-lg-4 col-md-6 mb-4">
		            <c:if test="${empty productList}">
		            	<span style="padding:30px 1px; ">등록된 상품이 존재하지 않습니다.</span>
		            </c:if>
		    </div>
		    <c:forEach items="${productList}" var="vo">
       		<div class="col-lg-4 col-md-6 mb-4">
		      	<div class="card h-100">
		              <a href="/product/readProduct${pm.makeQuery(pm.cri.page)}&prd_no=${vo.prd_no}&cg_code=${cg_code}">
		              	<img src="/product/displayFile?fileName=${vo.prd_img}" class="card-img-top" src="http://placehold.it/700x400" alt="">
		              </a>
		              <div class="card-body">
		                <h4 class="card-title">
		                  <a href="/product/readProduct${pm.makeQuery(pm.cri.page)}&prd_no=${vo.prd_no}&cg_code=${cg_code}">${vo.prd_name}</a>
		                </h4>
		                <p>가격: <fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###" />원<br>
						      할인가: <fmt:formatNumber value="${vo.prd_discount}" pattern="###,###,###" />원</p>
			          		<div class="btnContainer">
								<button class="btn btn-primary" id="btn_buy" type="button" 
									onclick="location.href = '/order/buy?pdt_num=${vo.prd_no}&ord_amount=1';">구매</button>
								<button class="btn btn-info" id="btn_cart" type="button" 
									onclick="cart_click(${vo.prd_no})">장바구니</button>
							</div>
		              </div>
		              <div class="card-footer">
						 <small class="text-muted">리뷰 [${vo.rev_count}]</small>
		              </div>
          	</div>
            	</div>
		    </c:forEach>
        </div>
        <!-- /.row -->
		
			<!-- 페이징 기능 -->
			<ul class="pagination justify-content-center">
			    <c:if test="${pm.prev}">
					<li><a class="page-link" href="${pm.makeQuery(pm.startPage-1)}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="idx">
				    <li class="page-item"<c:out value="${pm.cri.page == idx?'class:active':''}"/>>
					    <a class="page-link" href="${pm.makeQuery(idx)} ">${idx}</a>
				    </li>
			    </c:forEach>
			  	<c:if test="${pm.next && pm.endPage>0}">
					<li><a class="page-link" href="${pm.makeQuery(pm.endPage+1)}">&raquo;</a></li>
				</c:if>
			</ul>

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

