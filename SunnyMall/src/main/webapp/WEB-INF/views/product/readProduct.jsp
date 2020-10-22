<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>user login</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <script type="text/javascript" src="/js/member/login.js"></script>
 
  <!-- Bootstrap core CSS -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>

<style type="text/css">
body{margin-top:20px;
background:#eee;
}

/*panel*/
.panel {
    border: none;
    box-shadow: none;
}

.panel-heading {
    border-color:#eff2f7 ;
    font-size: 16px;
    font-weight: 300;
}

.panel-title {
    color: #2A3542;
    font-size: 14px;
    font-weight: 400;
    margin-bottom: 0;
    margin-top: 0;
    font-family: 'Open Sans', sans-serif;
}

/*product list*/

.prod-cat li a{
    border-bottom: 1px dashed #d9d9d9;
}

.prod-cat li a {
    color: #3b3b3b;
}

.prod-cat li ul {
    margin-left: 30px;
}

.prod-cat li ul li a{
    border-bottom:none;
}
.prod-cat li ul li a:hover,.prod-cat li ul li a:focus, .prod-cat li ul li.active a , .prod-cat li a:hover,.prod-cat li a:focus, .prod-cat li a.active{
    background: none;
    color: #ff7261;
}

.pro-lab{
    margin-right: 0px;
    font-weight: normal;
}

.pro-sort {
    padding-right: 0px;
    float: left;
}

.pro-page-list {
    margin: 5px 0 0 0;
}

.product-list img{
    width: 100%;
    border-radius: 4px 4px 0 0;
    -webkit-border-radius: 4px 4px 0 0;
}

.product-list .pro-img-box {
    position: relative;
}
.adtocart {
    background: #fc5959;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    -webkit-border-radius: 50%;
    color: #fff;
    display: inline-block;
    text-align: center;
    border: 3px solid #fff;
    left: 45%;
    bottom: -25px;
    position: absolute;
}

.adtocart i{
    color: #fff;
    font-size: 25px;
    line-height: 42px;
}

.pro-title {
    color: #5A5A5A;
    display: inline-block;
    margin-top: 20px;
    font-size: 16px;
}

.product-list .price {
    color:#fc5959 ;
    font-size: 15px;
}

.pro-img-details {
    margin-left: -15px;
}

.pro-img-details img {
    width: 100%;
}

.pro-d-title {
    font-size: 16px;
    margin-top: 0;
}

.product_meta {
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
    padding: 10px 0;
    margin: 15px 0;
}

.product_meta span {
    display: block;
    margin-bottom: 10px;
}
.product_meta a, .pro-price{
    color:#fc5959 ;
}

.pro-price, .amount-old {
    font-size: 18px;
    padding: 0 10px;
}

.amount-old {
    text-decoration: line-through;
}

.quantity {
    width: 120px;
}

.pro-img-list {
    margin: 10px 0 0 -15px;
    width: 100%;
    display: inline-block;
}

.pro-img-list a {
    float: left;
    margin-right: 10px;
    margin-bottom: 10px;
}

.pro-d-head {
    font-size: 18px;
    font-weight: 300;
}
</style>
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
      <section class="content-header" style="font-size:14px;">
				<h3>
					Product Detail 
				</h3>
			</section>
    	<section class="content-header">
			<div class="container bootdey">
<div class="col-md-12">
<section >
<div class="row">
          <div class="col-md-6">
              <div class="pro-img-details">
                  <img src="/product/displayFile?fileName=${vo.prd_img }" style="display: inline; width:90%;">
              </div>
              <div class="pro-img-list">
                  <a href="#">
                      <img src="https://via.placeholder.com/110x100/87CEFA/000000" alt="">
                  </a>
                  <a href="#">
                      <img src="https://via.placeholder.com/110x100/FF7F50/000000" alt="">
                  </a>
                  <a href="#">
                      <img src="https://via.placeholder.com/110x100/FF7F50/000000" alt="">
                  </a>
                 
          </div>
          </div>
          <div class="col-md-6">
              <h4 class="pro-d-title">
                  <a href="#" class="">
                      ${vo.prd_name}
                  </a>
              </h4>
              <p>
                 
              </p>
              <div class="product_meta">
                  <span class="posted_in"> <strong>Categories:</strong> <a rel="tag" href="#">Jackets</a>,.</span>
                  <span class="tagged_as"><strong>Tags:</strong> <a rel="tag" href="#">mens</a>, <a rel="tag" href="#">womens</a>.</span>
              </div>
              <div class="m-bot15"> <strong>Price : </strong> <span class="amount-old"><fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###"/>원</span>  <span class="pro-price"><fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###"/>원</span></div>
              <div class="form-group">
                  <label>Quantity</label>
                  <input type="quantiy" value="${vo.prd_stock}" class="form-control quantity">
              </div>
              <form action="/order/buy" method="post">
              <p>
              <input type="hidden" id="prd_no" value="${prd_no}">
                  <button class="btn_addCart" type="button"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
              	  <button class="btn_buy" type="submit"><i class="fa fa-shopping-cart"></i> Buy</button>
              </p>
              </form>
          </div>
     </div>
     <!-- 상품 상세 -->
	<label for="detail">Detail</label><br>
		<div contenteditable="false" style="border: 1px solid grey; padding: 20px;">
		${vo.prd_detail }
		</div>
		<br>
	<label for="review">Review</label><br>
		<div class="rating">
			<p id="star_grade">
		        <a href="#">★</a>
		        <a href="#">★</a>
		        <a href="#">★</a>
		        <a href="#">★</a>
		        <a href="#">★</a>
			</p>
		</div>
			<textarea id="reviewContent" rows="3" style="width:100%;"></textarea><br>
		<div class="modal-footer">
		   <button type="button" class="btn btn-info" id="btn_modal_modify">MODIFY</button>
		   <button type="button" class="btn btn-default" data-dismiss="modal">CLOSE</button>
		</div>						
  </section>
  </div>
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