<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- Cart Header -->
  <title>shop cart</title>
  <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>
  <script type="text/javascript" src="/js/cart/cartList.js"></script>
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
<!-- 
  Bootstrap docs: https://getbootstrap.com/docs
  Get more snippet on https://bootstraptor.com/snippets
-->
<section class="pt-5 pb-5">
  <div class="container">
	<form method="post" action="/order/orderPage">
     <div class="row w-100">
        <div class="col-lg-12 col-md-12 col-12">
            <h3 class="display-5 mb-2 text-center">Shopping Cart</h3>
            <p class="mb-5 text-center">
                <i class="text-info font-weight-bold">${countCart}</i> items in your cart</p>
				<div class="btn-container" style="display: inline-block; float: right; margin:20px 10px 5px 5px;">
							<button id="btn_delete_check"  class="btn btn-info" >선택 상품 삭제</button>
				</div>
	            <table id="shoppingCart" class="table table-condensed table-responsive">
	                <thead>
	                    <tr>
	                    	<th><input type="checkbox" id="checkAll" checked="checked" /></th>
	                        <th style="width:60%">Product</th>
	                        <th style="width:12%">Price</th>
	                        <th style="width:12%">Discount</th>
	                        <th style="width:10%">Quantity</th>
	                        <th style="width:16%"></th>
	                    </tr>
	                </thead>
	                <tbody>
	         			<c:forEach items="${cartProList }" var="vo">
		                    <tr>
		                    	<td>
		                    		<input type="checkbox" name="check" class="check" checked="checked" value="${vo.cart_code }">
		                    		<input type="hidden"  name="cart_code" value="${vo.cart_code}">
		                            <input type="hidden" name="prd_no" value="${vo.prd_no }">
		                            <input type="hidden" name="cart_amount" value="${vo.cart_amount}">
		                    	</td>
		                        <td data-th="Product">
		                            <div class="row">
		                                <div class="col-md-3 text-left">
		                                    <a href="/product/readProduct?prd_no=${vo.prd_no}&cg_code=${cg_code}">
		                                    <img src="/product/displayFile?fileName=${vo.prd_img}" alt="" class="img-fluid d-none d-md-block rounded mb-2 shadow ">
		                                    </a>
		                                </div>
		                                <div class="col-md-9 text-left mt-sm-2">
		                                	<h4>
		                                		<a href="/product/readProduct?prd_no=${vo.prd_no}&cg_code=${cg_code}">
		                                    	${vo.prd_name}
		                                    	</a>
		                                    </h4>
		                                    <p class="font-weight-light">${vo.prd_company}</p>
		                                </div>
		                            </div>
		                        </td>
		                        <td id="prd_price" data-th="Price">${vo.prd_price}
		                        	<input type="hidden" name="price_${vo.cart_code}" value="${vo.prd_price}" />
		                        </td>
		                        <td id="prd_discount" data-th="Discount">${vo.prd_discount}
		                        	<input type="hidden" name="discount_${vo.cart_code}" value="${vo.prd_discount}" />
		                        </td>
		                        <td data-th="Quantity">
		                            <input id="cart_amount" type="number" name="cart_amount_${vo.cart_code}" class="form-control form-control-lg text-center" 
		                            style="width: 70px;" value="${vo.cart_amount}">
		                        </td>
		                        <td class="actions" data-th="">
		                            <div class="text-right">
		                               <input type="hidden" id="cart_code" value="${vo.cart_code}">
		                                <button class="btn btn-white border-secondary bg-white btn-md mb-2" type="button" id="deleteCart">
		                                    <i class="fas fa-trash">del</i>
		                                </button>
		                            </div>
		                        </td>
		                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
        	
            <div class="float-left text-left">
                Total:
               <p id="totalPrice"></p>
            </div>
             <div class="float-center textc-center" style=" padding-left:200px;">
                Discount:<p id="totalDiscount" ></p>
            </div><br>
            <div class="float-right text-right">
                <h5>SubTotal:</h5>
               <h5 id="subTotal"></h5>
            </div>
            
        </div>
    </div>
    <div class="row mt-4 d-flex align-items-center">
        <div class="col-sm-6 order-md-2 text-right">
         	<button id="checkout" type="submit" class="btn btn-primary mb-4 btn-lg pl-5 pr-5">Checkout</button>
        </div>
        <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">
            <a href="/">
                <i class="fas fa-arrow-left mr-2"></i> Continue Shopping</a>
        </div>
    </div>
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