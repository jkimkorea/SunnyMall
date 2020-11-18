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
<!-- Bootstrap core CSS -->
<%@ include file="/WEB-INF/views/include/shop_css.jsp" %>
<script type="text/javascript" src="/js/product/read_js.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id='template' type='text/x-handlebars-template'>
{{#each.}}	 
<br>
<li class='replyLi' data-rev_no={{rev_no}} style="list-style:none;">
	<div class= "card">
   		<div class="card-body">
	        <div class="row">
        	    <div class="col-md-2">
        	        <p class="text-secondary text-center">{{prettifyDate rev_Date}}</p>
        	    </div>

        	    <div class="col-md-10">
					<p style='float:right;'>작성자: {{mb_id}}</p> 
        	     	<h6>
					{{checkRating rev_score}}<p class='rev_score' style="display:none;">{{rev_score}}</p>
        	       </h6>
        	       <div class="clearfix"></div>
        	        <p id="rev_cont">{{rev_cont}}</p>
        	     
				<div class='timeline-footer' style='float:right;'>
					{{eqReplyer mb_id rev_no prd_no}}
				</div>
        	    </div>
	        </div>
		</div>
</li>
{{/each}}
</script>
<script id='qnaTemplate' type='text/x-handlebars-template'>
		<div class='qna'>
			  <label for="QnA">QnA 글쓰기</label><br>
			  <div class="form-group">
  				  	<label for="title">Title:</label>
				  	<input type="text" class="form-control" name="title">
			  </div>
			  <div class="form-group">
  					<label for="comment">Comment:</label>
  					<textarea class="form-control" rows="5" name="comment" id="comment"></textarea>
			  </div>
			  <button class="btn_writeQnaOk" id="btn_writeQnaOk" style="float:right;"><i class="fa fa-shopping-cart"></i> 확인</button>
			  <br><br>
		</div>
</script>
<script type="text/javascript">
	$(function(){
		//날짜형식 지정
		Handlebars.registerHelper('prettifyDate',function(timeValue){
			var dateObj= new Date(timeValue);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			return year + '/'+ month + '/' + date;
		});
		//별점 반환
		Handlebars.registerHelper('checkRating',function(rating){
			var stars = '';
			switch(rating){
			case 1:
				stars='★☆☆☆☆'
				break;
			case 2:
				stars='★★☆☆☆'
				break;
			case 3:
				stars='★★★☆☆'
				break;
			case 4:
				stars='★★★★☆'
				break;
			case 5:
				stars='★★★★★'
				break;
			default:
				stars='☆☆☆☆☆'
			}
			return stars;
		});
		Handlebars.registerHelper('eqReplyer',function(replyer,rev_no,prd_no){
			var btnHtml = '';
			var mb_id = '${sessionScope.user.mb_id}';
			if(replyer == mb_id){
				btnHtml = "<a class='btn btn-success btn-xs' data-toggle='modal' data-target='#modifyModal'>"
						+"EDIT</a>"
						+"<button class='btn btn-warning btn-xs' style='margin-left:5px;'"
						+"onclick='deleteReview("+rev_no+","+prd_no+");'"
						+"type='button'>DELETE</button>";
			}
			return new Handlebars.SafeString(btnHtml);
		});
	});
</script>
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
<%-- 스타일 --%>
<style>
     #star_grade a{
     	font-size:22px;
        text-decoration: none;
        color: lightgray;
    }
    #star_grade a.on{
        color: black;
    }
    
    #star_grade_modal a{
     	font-size:22px;
        text-decoration: none;
        color: lightgray;
    }
    #star_grade_modal a.on{
        color: black;
    }
    
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
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
      <br>
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
						  	</div>
				          
			          <div class="col-md-6">
			              <h4 class="pro-d-title">
			                  <strong style="font-size:20px;"><a href="#" class="">
			                      ${vo.prd_name}
			                  </a></strong>
			              </h4>
			              <p>
			                 
			              </p>
			              <div class="product_meta">
			                  <span class="posted_in"> <strong>Category:</strong> <a rel="tag" href="#">${cg_name}</a></span>
						      <span><strong>Company:</strong>${vo.prd_company}</span>
			              </div>
			              <div class="m-bot15"> <strong>Price : </strong> <span class="amount-old"><fmt:formatNumber value="${vo.prd_price}" pattern="###,###,###"/>원</span>  <span class="pro-price"><fmt:formatNumber value="${((vo.prd_price)-(vo.prd_discount))}" pattern="###,###,###"/>원</span></div>
			              <div class="form-group">
			                  <label>Quantity</label>
			                  <input type="quantiy" value="${vo.prd_stock}" class="form-control quantity">
			              <form action="/order/buy" method="get">
			              <input type="hidden" id="prd_no" name="prd_no" value="${vo.prd_no}">
			              <label>Order amount</label><br>
			              <input type="number" id="ord_amount" name="ord_amount" value="1" /><br><br>
			                  <button class="btn_addCart" id="btn_addCart" type="button"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
			              	  <button class="btn_buy" id="btn_buy" type="submit"><i class="fa fa-shopping-cart"></i> Buy</button>
			              </form>
			          </div>
			     </div>
			     <!-- 상품 상세 -->
				<label for="detail">Detail</label><br>
					<div contenteditable="false" style="border: 1px solid grey; padding: 20px;width:100%;">
					${vo.prd_detail }
					</div>
					<br>
		</section>
		</div>
		
		<Br>
			<div>
				<!-- 리뷰 작성부분-->
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
						
					<ul class="timeline">
						<li class="time-label" id="repliesDiv" style=" list-style:none;">
							<span class="btn btn-info" >
								리뷰 보기 <small id="replycntSmall">[${reviewCount}] </small>
							</span>
							<button class="btn btn-primary" id="btn_write_review" type="button">리뷰 작성</button>
						</li>
						<li id="noReview" style="display:none;">
							<div class="timeline-item" >
								 <p class="timeline-header">
									상품후기가 존재하지 않습니다.<br>
									상품후기를 입력해주세요.</p>
							</div>
						</li>
					</ul>
	    		  <!-- 리뷰 페이징위치 -->  
				  <ul id="pagination" class="pagination justify-content-center"></ul>
					
			  </div>
			  <div class="table-responsive">          
				  <label for="QnA">QnA[]</label><br>
				  <c:if test="${empty vo}">
		        		<span style="padding:30px 1px; ">등록된 게시글이 존재하지 않습니다.</span>
		     	  </c:if>
	  			  <table class="table">
						<thead>
						      <tr>
						        <th>No</th>
						        <th>Title</th>
						        <th style="text-align:right;">User</th>
						        <th style="text-align:right;">Date</th>
						        <th style="text-align:right;">조회수</th>
						      </tr>
						  <%--<c:forEach items="" var="">
						      <tr>
						        <td>Firstname</td>
						        <td>Lastname</td>
						        <td>Email</td>
						        <td>Email</td>
						      </tr>
						  	</c:forEach>--%>
						  </thead>
					 </table>
				  
				  <button class="btnSubmitFix" id="btn_write_qna" type="button" style="float:right;">글쓰기</button>
			  </div>
			  <br>
			  <!-- QnA글쓰기 위치 -->
			  <div id="writeQna_location" class="dropdown">
			  </div>
			  
					<%-- Modal : 상품후기 수정/삭제 팝업 --%>
					<div id="modifyModal" class="modal modal-primary fade" role="dialog">
					  <div class="modal-dialog">
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header" >
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
							        <div class="modal-title">
										<p id="star_grade_modal">
									        <a href="#">★</a>
									        <a href="#">★</a>
										    <a href="#">★</a>
										    <a href="#">★</a>
										    <a href="#">★</a>
										</p>
								     </div>
							  </div>
							  <div class="modal-body" data-rev_no>
					       		 <p><input type="text" id="replytext" class="form-control"></p>
						      </div>
							  <div class="modal-footer">
					   			<button type="button" class="btn btn-info" id="btn_modal_modify">MODIFY</button>
					  			<button type="button" class="btn btn-default" data-dismiss="modal">CLOSE</button>
							  </div>						
			 
			  				</div>
			 		 </div>
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