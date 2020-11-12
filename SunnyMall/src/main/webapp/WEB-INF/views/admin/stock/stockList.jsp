<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<!-- REQUIRED JS SCRIPTS -->
<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
<%@include file="/WEB-INF/views/include/admin_header.jsp"%>
<script>
$(function(){
	//검색버튼 클릭시
	$("#btn_search").click(function(){
		self.location="stockList"
						+'${pm.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$("#keyword").val();
	});
});
</script>
<script>
	if("${msg}"=="EDIT_SUCCESS"){
		 alert("상품 수정이 완료되었습니다.");
	 }else if("${msg}"=="DELETE_SUCCESS"){
		 alert("상품 삭제가 완료되었습니다.");
	 }else{}
</script>

<script>
	var clickEdit = function(prd_no){
		var url = '/admin/product/edit${pm.makeSearch(pm.cri.page)}&prd_no='+prd_no;
		location.href=url;
	}
</script>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@include file="/WEB-INF/views/include/header.jsp" %>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="/WEB-INF/views/include/admin_sidebar.jsp" %>
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Admin Page <small>Product List</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 주문 관리</a></li>
					<li class="active">재고 관리</li>
				</ol>
			</section>
			<%-- MAIN CONTENT --%>
			<!-- Main content -->
			<section class="content container-fluid">
    			<div class="row">
        			<div class="col-md-12">
				        <div class="row text-center">
							<div style="display: inline-block; float: left; margin-left:15px;">
								<select name="searchType" style="width:180px; height:26px;">
									<option value="null" 
										<c:out value="${cri.searchType == null?'selected':''}"/>>검색조건 선택</option>
									<option value="prd_no"
										<c:out value="${cri.searchType == 'prd_no'?'selected':''}"/>>품번</option>
									<option value="name"
										<c:out value="${cri.searchType == 'name'?'selected':''}"/>>상품명</option>
									<option value="company"
										<c:out value="${cri.searchType == 'company'?'selected':''}"/>>제조사</option>
								</select>
								
								<input type="text" name='keyword' id="keyword" style="width:250px; padding-left:5px;" value='${cri.keyword}' />
								<button id="btn_search" class="btn btn-default">검색</button>
							</div>
						</div>
			        <h4>Product Amount List</h4>
			         <div class="table-responsive">

                
		              <table id="mytable" class="table table-bordred table-striped">
		                   
		                <thead>
		                   <tr>
		                   		<th>품번</th>
		                    	<th>품명</th>
		                    	<th>단가</th>
		                     	<th>판매가</th>
		                     	<th>할인액</th>
		                     	<th>제조사</th>
		                     	<th>재고</th>
		                     	<th>누적 판매량</th>
		                     	<th>품절 유/무</th>
		                      	<th>Edit / Delete</th>
		                        
		                   </tr>
		                </thead>
					    <tbody>
		                <c:if test="${empty list}">
					    	<tr>
								<td colspan="10"> 
									<p style="padding:50px 0px; text-align: center;"></p>
								</td>
								<td colspan="10">
									<p style="padding:50px 0px; text-align: center;">등록된 상품이 존재하지 않습니다.</p>
								</td>
							</tr>
					    </c:if>
					    
					    <c:forEach items="${list}" var="list">
							    <tr>
								    <td class="col-md-1">${list.prd_no}</td>
								    <td class="col-md-2">${list.prd_name}</td>
								    <td class="col-md-1"><fmt:formatNumber value="${list.prd_cost}" pattern="###,###,###"/></td>
								    <td class="col-md-1"><fmt:formatNumber value="${list.prd_price}" pattern="###,###,###"/></td>
								    <td class="col-md-1"><fmt:formatNumber value="${list.prd_discount}" pattern="###,###,###"/></td>
								    <td class="col-md-1">${list.prd_company}</td>
								    <td class="col-md-1"><input name="amount_${list.prd_no}" type="number" style="width:80px; height:34px; padding-left:5px;" value="${list.prd_stock}"/></td>
								    <td class="col-md-1">${list.prd_total_sales}</td>
								    <td class="col-md-1">
								    	<select>
								    		<option>판매중</option>
								    		<option>품절</option>
								    	</select>
								    </td>
									<td class="col-md-2">
										<form class="deleteForm" method="post"
											action="/admin/product/delete${pm.makeSearch(pm.cri.page)}">
											<!-- 상품 코드 -->
											<input type="hidden" name="prd_no"
												value="${list.prd_no}">
											<!-- 수정기능 -->
											<button type="button" name="btn_edit" class="btn btn-default" onclick="clickEdit(${list.prd_no});">Edit</button>
											<!-- 삭제기능 -->
											<button type="button" name="btn_delete" class="btn btn-danger">Del</button>
										</form>
									</td>
							    </tr>
					    	</c:forEach>
					  	  </tbody>
		        
						</table>
	
						<div class="clearfix">
						<ul class="pagination pull-right">
							<c:if test="${pm.prev}">
						  		<li><a href="list${pm.makeSearch(pm.startPage-1)}"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
						  	</c:if>
						  	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="idx">
							  	<li <c:out value="${pm.cri.page == idx?'class=active':'' }"/>>
							  	<a href="list${pm.makeSearch(idx)}">${idx}</a>
							  	</li>
							 </c:forEach>
							 <c:if test="${pm.next && pm.endPage >0}">
						  		<li><a href="list${pm.makeSearch(pm.endPage+1)}"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
							 </c:if>
						</ul>
                		</div>
          			 </div>
            
        		</div>
			</div>
			</section>
		</div>


		<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
		      <div class="modal-dialog">
			    <div class="modal-content">
			          <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
			        <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
			      </div>
			          <div class="modal-body">
			          <div class="form-group">
			        <input class="form-control " type="text" placeholder="Mohsin">
			        </div>
			        <div class="form-group">
			        
			        <input class="form-control " type="text" placeholder="Irshad">
			        </div>
			        <div class="form-group">
			        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>
			    
			        
			        </div>
			      </div>
			          <div class="modal-footer ">
			        <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
			      </div>
			        </div>
		    <!-- /.modal-content --> 
		    </div>
		<!-- /.modal-dialog --> 
	    </div>
    
    
    
	    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
	      <div class="modal-dialog">
		    <div class="modal-content">
		          <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
		        <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
		      </div>
		          <div class="modal-body">
		       
		       <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
		       
		      </div>
		        <div class="modal-footer ">
		        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
		      </div>
	        </div>
	     <!-- /.modal-content --> 
	  	 </div>
	   <!-- /.modal-dialog --> 
	   </div>
			<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
		<!-- Control Sidebar -->
	

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>