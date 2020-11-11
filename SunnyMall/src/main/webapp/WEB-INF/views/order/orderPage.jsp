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

  <script type="text/javascript" src="/js/order/orderPage.js"></script>
</head>

<body>

  <!-- Navigation -->
  <%@ include file="/WEB-INF/views/include/home_header.jsp" %>

  <!-- Page Content -->
  <div class="container">

 <form id="orderForm" method="post" action="/order/orderFromCart">
    <div class="row">

      <div class="col-lg-3">

	  <!-- sidebar -->
      <%@ include file="/WEB-INF/views/include/home_sidebar.jsp" %>
      </div>
      <!-- /.col-lg-3 -->
     
      <div class="col-lg-9">
      <section class="pt-5 pb-5">
	      <div class="row w-100">
	        <div class="col-lg-12 col-md-12 col-12">
	            <h3 class="display-5 mb-2 text-center">Checkout</h3>
	            <p class="mb-5 text-center">
	                
			  <div class="btn-container" style="display: inline-block; float: right; margin:20px 10px 5px 5px;">
					<button id="btn_delete_check"  class="btn btn-info" type="button">선택 상품 삭제</button>
			  </div>
    		<!-- /.col-lg-9 -->
            <br><br>
            <%--상품 정보리스트 --%>
            <table id="ordertbl" class="table table-condensed table-responsive">
	                <thead id="thead">
	                    <tr>
	                    	<th><input type="checkbox" id="checkAll" checked="checked"/></th>
	                        <th style="width:60%">Product</th>
	                        <th style="width:12%">Price</th>
	                        <th style="width:12%">Discount</th>
	                        <th style="width:10%">Quantity</th>
	                        <th style="width:16%"></th>
	                    </tr>
	                    <tr>
	                    	<c:if test ="${empty productList}">
	                    		<span>구매하실 상품이 존재하지 않습니다.</span>
	                    	</c:if>
	                    </tr>
	                </thead>
	                <tbody>
	         			<c:forEach items="${productList }" var="vo" varStatus="i">
		                    <tr id="productVO_${vo.prd_no}" class="productRow">
		                    	<td>
		                        	<input type="checkbox" name="check" class="check" value="${vo.prd_no}" checked="checked" >
									<input type="hidden" id="amount_${vo.prd_no}" name="orderDetailVOList[${i.index}].ord_amount" value="${amountList[i.index]}"/>
		                    		<input type="hidden" name="orderDetailVOList[${i.index}].prd_no" value="${vo.prd_no}"/>
		                    		<input type="hidden" name="orderDetailVOList[${i.index}].ord_price" value="${vo.prd_price}"/>
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
		                        <td id="prd_price" data-th="Price"><fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###"/>
		                        	<input type="hidden" name="price" value="${vo.prd_price}" />
		                        </td>
		                        <td id="prd_discount" data-th="Discount"><fmt:formatNumber value="${vo.prd_discount}" pattern="###,###,###"/>
		                        	<input type="hidden" name="discount" value="${vo.prd_discount}" />
		                        </td>
		                        <td data-th="Quantity">
		                        	<p>${amountList[i.index]}</p>
		                            <input id="cart_amount" type="hidden" name="cart_amount" 
		                            class="form-control form-control-lg text-center" value="${amountList[i.index]}">
		                        </td>
		                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	            
	            <hr>
					<%--주문자 정보란 --%>
					<div class="container" style="width: 800px; padding: 5% 5%;">
						<h5>[주문정보]</h5>
							* 아래 항목을 작성해주세요.<br><br>
						<div>
							<input type="hidden" class="form-control" id="mb_id" name="mb_id" value="${user.mb_id}">
						</div>
						<div class="form-group">
							<label for="inputName">*받는사람 이름</label> <input type="text"
								class="form-control" id="ord_name" name="ord_name"
								placeholder="이름을 입력해 주세요" style="max-width: 630px;" value="${user.mb_name}">
						</div>			
						<div class="form-group">
							<label for="inputMobile">* 휴대폰 번호</label> <input type="tel"
								class="form-control" id="ord_phone" name="ord_phone"
								placeholder="휴대폰 번호를 입력해 주세요" style="max-width: 630px;" value="${user.mb_phone }">
						</div>
						<div class="form-group">
							<label for="inputAddr">* 주소</label> <br />
							<input type="text" id="sample2_postcode" name="ord_zipcode" class="form-control" 
								style="max-width: 510px; width:calc(100% - 128px); margin-right: 5px; display: inline-block;" placeholder="우편번호" readonly value="${user.mb_zipcode}">
							<input type="button" onclick="sample2_execDaumPostcode()" id="btn_postCode" class="btn btn-info" value="우편번호 찾기"><br>
							<input type="text" id="sample2_address" name="ord_add" class="form-control" 
								placeholder="주소" style="max-width: 630px; margin:3px 0px;" readonly value="${user.mb_add}">
							<input type="text" id="sample2_detailAddress" name="ord_add_d" class="form-control" 
								placeholder="상세주소" style="max-width: 630px;" value="${user.mb_add_d }">
							<input type="hidden" id="sample2_extraAddress" class="form-control" 
								placeholder="참고항목">
						</div>
					</div>
				
				
				<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
				</div>
				<!-- /.col-lg-9 -->
				</div>
			</section>
			</div>
		</div>
				<%-- 우편번호API 동작코드 --%>
			    <%@ include file="/WEB-INF/views/include/plugins.jsp" %>
		
   
      <!-- /.row -->
      <div class="row">
         <div class="col-lg-3">
     	 </div>
		 <%-- 결제 방식 선택  및 주문 금액 확인 --%>
		 <div class="orderConfirm" style="display:inline-block; width:20%; margin: 0px 5%;">
				<%-- 결제 방식 --%>
				<div>
						<h5>[결제 방식]</h5><br>
							<div class="payment" style="margin-top:10px;">
								<input type="radio" name="payment" value="card" checked="checked">카드 결제
								<input type="radio" name="payment" value="tcash">실시간 계좌이체<br>
								<input type="radio" name="payment" value="phone">휴대폰 결제
								<input type="radio" name="payment" value="cash">무통장 입금
							</div>
				</div>
				<br>
									
				<%-- 주문 금액 --%>
				<div style="width: 500px;">
						<span>[결제 금액]</span>
						<table class="table text-center" style="margin-top:15px;" >
							<tr>
									<td class="col-md-2">총 상품금액</td>
									<td class="col-md-2" style="height:30px; text-align: center;"><p id="totalPrice" style="text-align:right; width:100px;">0</p></td>
							</tr>
							<tr>
									<td class="col-md-1">할인 금액</td>
									<td class="col-md-1" style="height:30px; text-align: center;"><p id="totalDiscount" style="text-align:right; width:100px;">0</p></td>
							</tr>
							<tr>
									<td class="col-md-1"><label>결제 예정 금액</label></td>
									<td class="col-md-1" style="height:30px; text-align: center;">
										<p id="ord_total_price" style="text-align:right; width:100px;">0</p>
										<input type="hidden" id="ord_totalprice" name="ord_total_price" value="0"/>
									</td>
							</tr>
							<tr>
									<td class="col-md-1" colspan="2" >
										<button id="btn_submit" class="btn btn-flat" type="button" style="padding: 10px 40px; background-color: grey; color:white;">결제하기</button>
									</td>
							</tr>
						</table>
				</div>
		</div>
		</div>
  </form>
     
	</div>
    <!-- /.container -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>

 
</body>

</html>