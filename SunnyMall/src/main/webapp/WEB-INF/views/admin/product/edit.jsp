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
<%-- 수정 버튼 클릭 시 유효성 검사 --%>
<script type="text/javascript" src="/js/admin/edit.js"></script>
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
		//List 버튼 클릭시 
		$("#btn_list").click(function(){
			var result = confirm("내용을 저장하지 않고, 목록으로 돌아가시겠습니까?");
			
			if(result){
				location.href="/admin/product/list${p.makeSearch(pm.cri.page)}";
			}else{}
		});
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
<%--2차 카테고리 템플릿 적용함수 --%>
<script>
 	var subCGList = function(subCGStr, target, templateObject){
 		
 		var template = Handlebars.compile(templateObject.html());
 		var options = template(subCGStr);
 		$("#subCategory option").remove();
 		target.append(options);
 	}
</script>
<script>
	var fileChange=function(file){
		var str = file.value;
		$("#fileName").html("파일이 변경됨");
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
						Admin Page <small>Product Edit</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 상품 관리</a></li>
						<li class="active">상품 수정</li>
					</ol>
				</section>


				<%-- MAIN CONTENT --%>
				<section class="content container-fluid">
	
					<!-- 상품수정 폼 -->
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header">
									<h3 class="box-title">EDIT THIS PRODUCT</h3>
								</div>
								<!-- /.box-header -->
	
								<form id='editForm' role="form" action="/admin/product/edit" method="post" enctype="multipart/form-data">
									<div class="box-body">
										<div class="form-group">
											<input type="hidden" name="page" value="${cri.page}"/>
											<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
											<input type="hidden" name="searchType" value="${cri.searchType}"/>
											<input type="hidden" name="keyword" value="${cri.keyword}"/>
										</div>
										<div class="form-group">
										<input type="hidden" name="prd_no" value="${vo.prd_no}"/>
											<label for="exampleInputEmail1" style="width:30%; margin-right:20px;" >1차 카테고리</label>
											<label for="exampleInputEmail1" style="width:30%;" >2차 카테고리</label> <br />
											<select class="form-control" id="mainCategory" name="cg_parent" style="width:30%; margin-right:10px; display: inline-block;" >
											  <option value="default">1차 카테고리 선택</option>
											  <c:forEach items="${cateList}" var="list">
											  	<option value="${list.cg_code}"<c:out value="${vo.cg_parent==list.cg_code? 'selected':'' }"/>>${list.cg_name}</option>
											  </c:forEach>
											</select>
											<select class="form-control" id="subCategory" name="cg_code" style="width: 30%; display: inline-block;">
											 	<option value="default">2차 카테고리 선택</option>
											 	<c:forEach items="${subCateList}" var="subList">
											 		<option value="${subList.cg_code}" <c:out value="${vo.cg_code==subList.cg_code? 'selected':''}"/>>${subList.cg_name}</option>
											 	</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Product Name</label> <input
												type="text" id="prd_name" name="prd_name" class="form-control"
												value="${vo.prd_name }">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Company</label> <input
												type="text" id="prd_company" name="prd_company" class="form-control"
												value="${vo.prd_company}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1" style="width:40%; margin-right:10px;">Price</label> 
											<label for="exampleInputEmail1" style="width:40%;">Discount</label> 
											<input style="width:40%; margin-right:10px; display: inline-block;"
												type="text" id="prd_price" name="prd_price" class="form-control" 
												value="${vo.prd_price}" />
											<input style="width:40%; display: inline-block;"
												type="text" id="prd_discount" name="prd_discount" class="form-control "
												value="${vo.prd_discount}" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Detail</label>
											<textarea class="form-control" id="prd_detail" name="prd_detail" rows="8"
												value="${vo.prd_detail}"></textarea>
										</div>
	
										<div class="form-group">
											<input type="hidden" name="prd_img" value="${vo.prd_img }"/>
											<label for="exampleInputEmail1">Thumbnail Image</label>
											<span id="fileName" style="margin-left:5px; font-size:14px;">현재 등록된 파일: <c:out value="${originFile}" /></span>
											<input onchange="fileChange(this)" type="file" id="file1" name="file1" class="form-control"/>
										</div>
										
										<div class="form-group">
											<label for="exampleInputEmail1" style="width:30%; margin-right:10px;">Amount</label> 
											<label for="exampleInputEmail1" style="width:15%;">Buy availability</label><br /> 
											<input style="width:30%; margin-right:10px; display: inline-block;"
												type="text" id="prd_stock" name='prd_stock' class="form-control" 
												value="${vo.prd_stock}" />
											<select class="form-control" id="prd_buy" name="prd_buy" style="width: 15%; display: inline-block;">
											  <option <c:out value="${vo.prd_buy=='Y'?'selected':''}"/>>Y</option>
											  <option <c:out value="${vo.prd_buy=='N'?'selected':''}"/>>N</option>
											</select>
										</div>
										<div class="form-group">
											<label for="submitDate" style="widthL40%; margin-right:10px;">Submit Date</label>
											<span class="form-control" style="width:40p%; margin-right:10px; display:inline-block;">
												<fmt:formatDate value="${vo.prd_date_post}" pattern="yyyy-MM-dd HH:mm:ss"/>
											</span>
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
										<button id="btn_list" type="button" class="btn btn-default">List</button>									</div>
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