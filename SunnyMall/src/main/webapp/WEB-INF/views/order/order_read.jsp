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
	         	
	            <h3 class="display-5 mb-2 text-center">Order Detail</h3>
	            <p class="mb-5 text-center">
	         
	    		<!-- /.col-lg-9 -->
	            <br><br>
	            <%--상품 정보리스트 --%>
	            <table id="ordertbl" class="table table-condensed table-responsive">
	                <thead id="thead">
	                	<tr style="background-color: aliceBlue;" >
							<td colspan="7" style="text-align:left;">
	                			<b>주문날짜: <fmt:formatDate value="${customerInfo.ord_date}" pattern="yyyy/MM/dd HH:mm:ss"/>
	                			(주문번호: ${customerInfo.ord_no})</b>
	                		</td>
	                	</tr>
	                    <tr>
	                        <th style="width:30%">IMAGE</th>
	                        <th style="width:12%">NAME</th>
	                        <th style="width:12%">PRICE</th>
	                        <th style="width:10%">DISCOUNT</th>
	                        <th style="width:16%">AMOUNT</th>
	                        <th style="width:16%">TOTAL</th>
	                        <th style="width:56%">REVIEW</th>
	                    </tr>
	                  
	                </thead>
	                <tbody>
 						<c:forEach items="${orderVO}" var="vo" varStatus="i">
		                    <tr id="productVO_${vo.prd_no}" class="productRow">
		                    
		                        <td data-th="Product">
		                             <a href="/product/readProduct?prd_no=${vo.prd_no}&cg_code=${cg_code}">
		                                    <img src="/product/displayFile?fileName=${vo.prd_img}" alt="" class="img-fluid d-none d-md-block rounded mb-2 shadow ">
		                             </a>
		                        </td>
		                        <td id="prd_name" data-th="name">
		                             <a href="/product/readProduct?prd_no=${vo.prd_no}&cg_code=${cg_code}">
		                                    ${vo.prd_name}
		                             </a>
		                        </td>
		                        <td id="prd_price" data-th="Price"><fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###"/>
		                        </td>
		                        <td id="prd_dicount" data-th="Discount"><fmt:formatNumber value="${vo.prd_discount}" pattern="###,###,###"/>
		                        </td>
		                        <td>
									<p>${vo.ord_amount}</p>
								</td>
		                       	<td class="col-md-1">
									<p ><fmt:formatNumber value="${(vo.ord_price - vo.prd_discount)*vo.ord_amount}"  pattern="###,###,###" /></p>
								</td>
								<td class="col-md-1">
									<button type="button" name="btn_review" class="btn btn-info" 
										onclick="location.href='/product/readProduct?prd_no=${vo.prd_no}&cg_code=${cg_code}';" value="${vo.prd_no}" >상품후기 쓰기</button>
								</td>
		                    </tr>
				       </c:forEach>
	                </tbody>
	            </table>
	            <hr>
					<%--주문자 정보란 --%>
					<div class="orderInfo" style="min-width:700px;" > 
						<span>[주문 정보]</span>
						<div class="form-group">
							<label for="inputName">이름</label> <input type="text"
								class="form-control" id="ord_name" name="ord_name"
								 value="${customerInfo.ord_name}">
						</div>			
						<div class="form-group">
							<label for="inputMobile">휴대폰 번호</label> <input type="tel"
								class="form-control" id="ord_phone" name="ord_phone"
								value="${customerInfo.ord_phone }">
						</div>
						<div class="form-group">
							<label for="inputAddr">상품 수령 주소</label> <br>
							우편번호:<input type="text" id="sample2_postcode" name="ord_zipcode" class="form-control" 
								style="max-width: 510px; width:70px; margin-right: 5px; display: inline-block;" placeholder="우편번호" readonly value="${customerInfo.ord_zipcode}">
							<br>
							주소:<br>
							<input type="text" id="sample2_address" name="ord_add" class="form-control" 
								placeholder="주소" style="max-width: 630px; margin:3px 0px;" readonly value="${customerInfo.ord_add}">
							<input type="text" id="sample2_detailAddress" name="ord_add_d" class="form-control" 
								placeholder="상세주소" style="max-width: 630px;" value="${customerInfo.ord_add_d }">
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
				<%-- 주문 금액 --%>
				<div style="width: 500px;">
						<span>[결제 금액]</span>
						<table class="table text-center" style="margin-top:15px;" >
							<tr>
								<td class="col-md-2">총 결제 금액</td>
								<td class="col-md-2" style="height:30px; text-align: center;">
								<fmt:formatNumber value="${customerInfo.ord_total_price}" pattern="###,###,###"/>
								</td>
							</tr>
						</table>
				</div>
		</div>
	</div>
    <!-- /.container -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
 
</body>

</html>