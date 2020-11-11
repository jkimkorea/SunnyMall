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
   
      
	<div class="col-lg-9">
      <section class="pt-5 pb-5">
	      <div class="row w-100">
	        <div class="col-lg-12 col-md-12 col-12">
	            <h3 class="display-5 mb-2 text-center">Order List</h3>
	            <p class="mb-5 text-center">
	                
    		<!-- /.col-lg-9 -->
            <br><br>
            <%--상품 주문정보 리스트 --%>
            <table id="ordertbl" class="table table-condensed table-responsive">
	              <c:forEach items="${orderList}" var="orderVO" varStatus="status">
	                <thead id="thead">
						<c:if test="${status.index==0 || orderVO.ord_no != code}">
						<tr style="background-color: aliceBlue;" >
							<td colspan="5" style="text-align:left;">
								<b>주문날짜: <fmt:formatDate value="${orderVO.ord_date}" pattern="yyyy/MM/dd HH:mm:ss"/>
								(주문번호: ${orderVO.ord_no} ) </b>
							</td>
							<td> 
								<button class="btn btn-primary" onclick="location.href='/order/order_read?ord_no=${orderVO.ord_no}';">
								주문 상세보기</button> 
							</td>
						<tr>
	                    <tr>
	                    	<th style="width:18%">Image</th>
	                        <th style="width:18%">Name</th>
	                        <th style="width:15%">Price</th>
	                        <th style="width:15%">Quantity</th>
	                        <th style="width:15%">Total</th>
	                        <th style="width:70%">Review</th>
	                    </tr>
	      				</c:if>
	                </thead>
	                <tbody>
	         			
		                    <tr id="productVO_${vo.prd_no}" class="productRow">
		                    	<td>
		                    		<a href="/product/read?pdt_num=${orderVO.prd_no}">
										<img src="/product/displayFile?fileName=${orderVO.prd_img}" style="width:100px;">
									</a>
		                    	</td>
		                    	<td>
		                        	<a href="/product/read?pdt_num=${orderVO.prd_no}"
										style="color: black;"> ${orderVO.prd_name} </a>
		                    	</td>
		                        <td data-th="Product_pri">
		                           <fmt:formatNumber value="${orderVO.ord_price-orderVO.prd_discount}" pattern="###,###,###" />
		                        </td>
		                        <td data-th="amount">
		                        <p>${orderVO.ord_amount}</p>
		                        </td>
		                        <td id="" data-th="price">
		                        	<fmt:formatNumber value="${(orderVO.ord_price-orderVO.prd_discount) * orderVO.ord_amount}" pattern="###,###,###" />
		                        </td>
		                        <td data-th="btn">
		                        	<button type="button" class="btn btn-info" 
												onclick="location.href='/product/readProduct?prd_no=${orderVO.prd_no}&cg_code=${cg_code}';" value="${orderVO.prd_no}" >상품후기 쓰기</button>
		                        </td>
		                    </tr>
	                </tbody>
	               </c:forEach>
	          </table>
	            
	            <hr>
				
				<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
				</div>
				<!-- /.col-lg-9 -->
				</div>
			</section>
			</div>
		</div>
	</div>
    <!-- /.container -->
  

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>

 
</body>

</html>