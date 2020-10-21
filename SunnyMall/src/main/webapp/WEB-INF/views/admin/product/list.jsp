<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- REQUIRED JS SCRIPTS -->
<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
<%@include file="/WEB-INF/views/include/admin_header.jsp"%>
<script>
	 if("${msg}"=="INSERT_SUCCESS"){
		 alert("상품등록이 완료되었습니다.");
	 }else if("${msg}"=="EDIT_SUCCESS"){
		 alert("상품 수정이 완료되었습니다.");
	 }else if("${msg}"=="DELETE_SUCCESS"){
		 alert("상품 삭제가 완료되었습니다.");
	 }else{}
</script>
<script>
$(function(){
	//검색버튼 클릭시
	$("#btn_search").click(function(){
		self.location="list"
						+'${pm.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$("#keyword").val();
	});
	//전체 선택 체크박스 클릭시
	$("#checkall").click(function(){
		$(".check").prop('checked',this.checked);
	});
	//체크박스 중 선택안된 체크박스 존재 시 전체선택 해제
	$(".check").click(function(){
		$("#checkAll").prop('checked',false);
	});
	//선택 상품 삭제 버튼 클릭시
	$("#btn_delete_check").click(function(){
		if($("input[name='check']:checked").length==0){
			alert("삭제할 상품을 선택해주세요.");
			return;
		}
		var result = confirm("선택한 상품을 삭제하시겠습니까?");
		if(result){
			var checkArr=[];
			var imgArr=[];
			
			$("input[name='check']:checked").each(function(i){
				var prd_num = $(this).val();
				var prd_img = $("input[name='img_"+prd_img+"']").val();
				
				checkArr.push(prd_num);
				imgArr.push(prd_img);
			});
			
			$.ajax({
				url:'/admin/product/deleteChecked',
				type:'post',
				dataType:'text',
				data:{
					 checkArr:checkArr,
					 imgArr:imgArr
					 },
				success:function(data){
					alert("삭제가 완료되었습니다.");
					location.href='/admin/product/list${pm.makeSearch(pm.cri.page)}';
				}
			});
		}else{}
	});
	//선택 상품 삭제 버튼 클릭시
	$("button[name='btn_delete']").click(function(){
		
		var result = confirm("이 상품을 삭제하시겠습니까?")
		if(result){
			$(".deleteForm").submit();
		}else{}
	});
	//선택 상품 수정 버튼 클릭시
	$("#btn_edit_check").click(function(){
		alert("");
		if($("input[name='check']:checked").length==0){
			alert("수정할 상품을 선택해주세요.");
			return;
		}
		var checkArr=[];
		var stockArr=[];
		var buyArr=[];
		
		$("input[name='check']:checked").each(function(){
			var prd_no=$(this).val();
			var prd_stock=$("input[name='amount_"+prd_no+"']").val();
			var prd_buy=$("select[name='buy_"+prd_no+"']").val();
			
			checkArr.push(prd_no);
			stockArr.push(prd_stock);
			buyArr.push(prd_buy);
		});
		$.ajax({
			url:'/admin/product/editChecked',
			type:'post',
			dataType:'text',
			data:{
				checkArr:checkArr,
				stockArr:stockArr,
				buyArr:buyArr
				},
			success:function(data){
				if(data=="SUCCESS"){
				alert("수정이 완료되었습니다.");
				location.href="/admin/product/list${pm.makeSearch(pm.cri.page)}";
				}
			}
		});
	});
});
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
					<li><a href="#"><i class="fa fa-dashboard"></i> 상품 관리</a></li>
					<li class="active">상품 목록</li>
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
									<option value="name"
										<c:out value="${cri.searchType == 'name'?'selected':''}"/>>상품명</option>
									<option value="detail"
										<c:out value="${cri.searchType == 'detail'?'selected':''}"/>>내용</option>
									<option value="company"
										<c:out value="${cri.searchType == 'company'?'selected':''}"/>>제조사</option>
									<option value="name_detail"
										<c:out value="${cri.searchType == 'name_detail'?'selected':''}"/>>상품명+내용</option>
									<option value="name_company"
										<c:out value="${cri.searchType == 'name_company'?'selected':''}"/>>상품명+제조사</option>
									<option value="all"
										<c:out value="${cri.searchType == 'all'?'selected':''}"/>>사품명+내용+제조사</option>
								</select>
								
								<input type="text" name='keyword' id="keyword" style="width:250px; padding-left:5px;" value='${cri.keyword}' />
								<button id="btn_search" class="btn btn-default">검색</button>
							</div>
							<div style="display: inline-block; float: right; margin-right:15px;">
								<button id="btn_edit_check"  class="btn btn-default" >선택 상품 수정</button>
								<button id="btn_delete_check"  class="btn btn-default" >선택 상품 삭제</button>
								<button class="btn btn-primary"	onClick="location.href='/admin/product/admin_insertPage'">상품 등록</button>
							</div>	
						</div>
			        <h4>Product List</h4>
			        <div class="box" style="border: none;">

                
		              <table id="mytable" class="table table-bordred table-striped">
		                   
		                <thead>
		                   <tr>
		                  	 	<th><input type="checkbox" id="checkall" /></th>
		                   		<th>No</th>
		                    	<th>Image</th>
		                    	<th>Name</th>
		                     	<th>Price</th>
		                     	<th>Discount</th>
		                     	<th>Company</th>
		                     	<th>Amount</th>
		                     	<th>Selling</th>
		                      	<th>Edit / Delete</th>
		                        
		                   </tr>
		                </thead>
					    <tbody>
		                <c:if test="${empty productList}">
					    	<tr>
								<td colspan="10"> 
									<p style="padding:50px 0px; text-align: center;"></p>
								</td>
								<td colspan="10">
									<p style="padding:50px 0px; text-align: center;">등록된 상품이 존재하지 않습니다.</p>
								</td>
							</tr>
					    </c:if>
					    
					    <c:forEach items="${productList}" var="productVO">
							    <tr>
								    <td><input type="checkbox" name="check" class="check" value="${productVO.prd_no}" } /></td>
								    <td class="col-md-1">${productVO.prd_no}</td>
								    <td class="col-md-2">
								    	<img src="/admin/product/displayFile?fileName=${productVO.prd_img}" style="width:80px;">
								   		<input type="hidden" name="img_${productVO.prd_no}" value="${productVO.prd_img }">
								    </td>
								    <td class="col-md-2">
								   		 <a href="/admin/product/read${pm.makeSearch(pm.cri.page)}&prd_no=${productVO.prd_no}"
								   			 style="color: black;">${productVO.prd_name}</a>
								    </td>
								    <td class="col-md-1">${productVO.prd_price}</td>
								    <td class="col-md-1">${productVO.prd_discount}</td>
								    <td class="col-md-2">${productVO.prd_company}</td>
								    <td class="col-md-1"><input name="amount_${productVO.prd_no}" type="number" style="width:80px; height:34px; padding-left:5px;" value="${productVO.prd_stock}"/></td>
								 	<td>
								 		<select class="form-control" name="buy_${productVO.prd_no}" style="width: 60px; displayL inline-block;">
								 			<option <c:out value="${productVO.prd_buy == 'Y'?'selected':''}"/>>Y</option>
								 			<option <c:out value="${productVO.prd_buy == 'N'?'selected':''}"/>>N</option>
										</select>
									</td>
											<td class="col-md-2">
												<form class="deleteForm" method="post"
													action="/admin/product/delete${pm.makeSearch(pm.cri.page)}">
													<!-- 상품 코드 -->
													<input type="hidden" name="prd_no"
														value="${productVO.prd_no}">
													<!-- 파일 이미지명 -->
													<input type="hidden" name="prd_img"
														value="${productVO.prd_img}">
													<!-- 수정기능 -->
													<button type="button" name="btn_edit" class="btn btn-default" onclick="clickEdit(${productVO.prd_no});">Edit</button>
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
							  	<li <c:out value="${pm.cri.page == idx? 'class=active':''}"/>><a href="list${pm.makeSearch(idx)}">${idx}</a></li>
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

			<!-- Main content -->
			<section class="content container-fluid">

				<!--------------------------
        | Your Page Content Here |
        -------------------------->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
		<!-- Control Sidebar -->
	
	
	
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>