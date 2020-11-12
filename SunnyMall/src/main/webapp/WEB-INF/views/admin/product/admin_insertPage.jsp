<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<!-- REQUIRED JS SCRIPTS -->
<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
<%@include file="/WEB-INF/views/include/header.jsp" %>
<head>
<title>Insert product</title>
<script src="/ckeditor/ckeditor.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<%--Handlebar Template --%>
<script id="subCGListTemplate" type="text/x-handlebars-template">
	<option value="default">2차 카테고리 선택</option>
	{{#each.}}
	<option value="{{cg_code}}">{{cg_name}} </option>
	{{/each}}
</script>

<%-- --%>
<script>
	$(function(){
		//CKEditor 작업
		var ckeditor_config={
		       
				resize_enabled : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				toolvarCanCollapse : true,
				removePlugins : "elementspath",
				filebrowserUploadUrl:'/admin/product/imgUpload'
		};
		CKEDITOR.replace("prd_detail",ckeditor_config);
		
		//1차 카테고리에 따른 2차카테고리 리스트 작업	
		$("#mainCategory").on("change",function(){
			var mainCGCode = $(this).val();
			var url = "/admin/product/subCGList/" + mainCGCode;
			
			$.getJSON(url,function(data){
				subCGList(data,$("#subCategory"),$("#subCGListTemplate"))
			});
		});
	
	});
</script>
<%-- 유효성 검사 --%>
<script type="text/javascript" src="/js/admin/insert_product.js"></script>

<%--2차 카테고리 템플릿 적용함수 --%>
<script>
 	var subCGList = function(subCGStr, target, templateObject){
 		
 		var template = Handlebars.compile(templateObject.html());
 		var options = template(subCGStr);
 		$("#subCategory option").remove();
 		target.append(options);
 	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Admin Header -->
		<%@include file="/WEB-INF/views/include/admin_header.jsp" %>
		<!-- Admin_sidebar -->
		<%@include file="/WEB-INF/views/include/admin_sidebar.jsp" %>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Main Header -->
			<!-- Left side column. contains the logo and sidebar -->
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						Admin Page <small>Product Insert</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 상품 관리</a></li>
						<li class="active">상품 등록</li>
					</ol>
				</section>


				<%-- MAIN CONTENT --%>
				<section class="content container-fluid">
	
					<!-- 상품등록 폼 -->
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header">
									<h3 class="box-title">ADD NEW PRODUCT</h3>
								</div>
								<!-- /.box-header -->
	
								<form id='registerForm' role="form" action="/admin/product/insert" method="post" enctype="multipart/form-data">
									<div class="box-body">
										<div class="form-group">
											<label for="exampleInputEmail1" style="width:30%; margin-right:20px;" >1차 카테고리</label>
											<label for="exampleInputEmail1" style="width:30%;" >2차 카테고리</label> <br />
											<select class="form-control" id="mainCategory" name="cg_parent" style="width:30%; margin-right:10px; display: inline-block;" >
											  <option value="default">1차 카테고리 선택</option>
											  <c:forEach items="${cateList}" var="vo">
											  	<option value="${vo.cg_code}">${vo.cg_name}</option>
											  </c:forEach>
											</select>
											<select class="form-control" id="subCategory" name="cg_code" style="width: 30%; display: inline-block;">
											 	<option value="default">2차 카테고리 선택</option>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Product Name</label> <input
												type="text" id="prd_name" name="prd_name" class="form-control"
												placeholder="Enter Product name">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Company</label> <input
												type="text" id="prd_company" name="prd_company" class="form-control"
												placeholder="Enter company">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1" style="width:30%; margin-right:10px;">Cost</label> 
											<label for="exampleInputEmail1" style="width:30%;">Price</label>
											<label for="exampleInputEmail1" style="width:30%;">Discount</label> 
											<input style="width:30%; display: inline-block;"
												type="text" id="prd_cost" name="prd_cost" class="form-control "
												placeholder="Enter cost" />
											<input style="width:30%; margin-right:10px; display: inline-block;"
												type="text" id="prd_price" name="prd_price" class="form-control" 
												placeholder="Enter price" />
											<input style="width:30%; display: inline-block;"
												type="text" id="prd_discount" name="prd_discount" class="form-control "
												placeholder="Enter discounted price" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Detail</label>
											<textarea class="form-control" id="prd_detail" name="prd_detail" rows="8"
												placeholder="Enter ..."></textarea>
										</div>
	
										<div class="form-group">
											<label for="exampleInputEmail1">Thumbnail Image</label> <input
												type="file" id="file1" name="file1" class="form-control" />
										</div>
										
										<div class="form-group">
											<label for="exampleInputEmail1" style="width:30%; margin-right:10px;">Amount</label> 
											<label for="exampleInputEmail1" style="width:15%;">Buy availability</label><br /> 
											<input style="width:30%; margin-right:10px; display: inline-block;"
												type="text" id="prd_stock" name='prd_stock' class="form-control" 
												placeholder="Enter Amount" />
											<select class="form-control" id="prd_buy" name="prd_buy" style="width: 15%; display: inline-block;">
											  <option>Y</option>
											  <option>N</option>
											</select>
										</div>
									</div>
	
									<!-- /.box-body -->
	
									<div class="box-footer">
										<div>
											<hr>
										</div>
	
										<ul class="mailbox-attachments clearfix uploadedList">
										</ul>
	
										<button id="btn_submit" type="button" class="btn btn-primary">Submit</button>
	
									</div>
								</form>
	
							</div>
							<!-- /.box -->	
						</div>
						<!--/.col (left) -->
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
	</div>
	
		<!-- Main Footer -->
		<%@include file="/WEB-INF/views/include/home_footer.jsp"%>
</body>
</html>