<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<!-- REQUIRED JS SCRIPTS -->
<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
<%@include file="/WEB-INF/views/include/admin_header.jsp"%>

<script>
$(function(){
	//회원 검색
	$("#btn_search").click(function(){
		self.location="memberList"
						+'${pm.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$("#keyword").val();
	});
	//회원 탈퇴 처리버튼 클릭시
	$("#btn-delete").click(function(){
		var mb_id=$(this).prev().val();
		
		$.ajax({
			url:"/admin/member/deleteMember",
			type:"post",
			dataType:"text",
			data:{
				mb_id:mb_id
			},
			success:function(data){
				location.href="/admin/member/memberList";
			}
		});
	});
	//회원 탈퇴 처리
	$("#btn-delete").click(function(){
		var mb_id=$("#mb_id").val();
		alert(mb_id);
		
		$.ajax({
			url:'/admin/member/deleteMem',
			type:'post',
			dataType:'text',
			data:{
				mb_id:mb_id
			},
			successe:function(data){
				location.href="/admin/member/memberList";
			}
		});
	});
});
	//crm 버튼 클릭시
	function openWindow(mb_id){
			var url= "/admin/member/crmPage?mb_id="+mb_id;  
			var winWidth = 700;
		    var winHeight = 600;
		    var popupOption= "width="+winWidth+", height="+winHeight;    
			window.open(url,"",popupOption);
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
					Admin Page
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 회원 관리</a></li>
					<li class="active">회원 목록</li>
				</ol>
			</section>
			<div class="container">
    			<div class="row">
		
        
        			<div class="col-md-12">
        
				        <div class="row text-center">
							<div style="display: inline-block; float: left; margin-left:15px;">
								<select name="searchType" style="width:180px; height:26px;">
									<option value="null" 
										<c:out value="${cri.searchType == null?'selected':''}"/>>검색조건 선택</option>
									<option value="name"
										<c:out value="${cri.searchType == 'name'?'selected':''}"/>>회원명</option>
									<option value="nickname"
										<c:out value="${cri.searchType == 'nickname'?'selected':''}"/>>닉네임</option>
									<option value="mb_id"
										<c:out value="${cri.searchType == 'id'?'selected':''}"/>>아이디</option>
								</select>
								
								<input type="text" name='keyword' id="keyword" style="width:250px; padding-left:5px;" value='${cri.keyword}' />
								<button id="btn_search" class="btn btn-default">검색</button>
							</div>
						</div>
			        <h4>Member List</h4>
			        <div class="table-responsive">

                	
					    <div class="col-xs-3 col-md-3">
						    <div class="table table-responsive">
						        <table class="table">
							        <tr>
							            <th>총회원</th>
							            <td>${mbCount}명</td>
							        </tr>
						        </table>
						    </div>
					     
					    </div>
		              <table id="mytable" class="table table-bordred table-striped">
		                <thead>
		                     <tr>
		                  	 	<th><input type="checkbox" id="checkall" /></th>
		                   		<th style="text-align: center;">ID</th>
		                    	<th style="text-align: center;">Name</th>
		                    	<th style="text-align: center;">NickName</th>
		                     	<th style="text-align: center;">Phone</th>
		                     	<th style="text-align: center;">Email</th>
		                     	<th style="text-align: center;">Zipcode</th>
		                     	<th style="text-align: center;">Address</th>
		                     	<th style="text-align: center;">메일수신</th>
		                     	<th style="text-align: center;">Point</th>
		                      	<th>CRM</th>
		                        <th>탈퇴처리</th>
		                	</tr>
		                </thead>
					    <tbody>
		                <c:if test="${empty memberVO}">
					    		<tr>
									<td colspan="10"> 
										<p style="padding:50px 0px; text-align: center;"><td colspan="10"> </p>
										<p style="padding:50px 0px; text-align: center;">등록된 회원 정보가 존재하지 않습니다.</p>
									</td>
									
								</tr>
					    </c:if>
					    <c:forEach items="${memberVO}" var="vo">
							    <tr style="text-align:center;">
								    <td><input type="checkbox" class="checkthis" /></td>
								    <td>${vo.mb_id}</td>
								    <td>${vo.mb_name}</td>
								    <td>${vo.mb_nickname}</td>
								    <td>${vo.mb_phone}</td>
								    <td>${vo.mb_email}</td>
								    <td>${vo.mb_zipcode}</td>
								    <td>${vo.mb_add}</td>
								    <td>${vo.mb_email_accept}</td>
								    <td>${vo.mb_point}</td>
								    
								    <td>
								    		<button id="btn-edit" class="btn btn-warning btn-xs" onclick="openWindow('${vo.mb_id}')"><span class="glyphicon glyphicon-pencil"></span></button>
								    </td>
								    <td>
								    		<input type="hidden" id="mb_id" value="${vo.mb_id}">
								    		<button id="btn-delete" class="btn btn-danger btn-xs" data-title="Delete"><span class="glyphicon glyphicon-ok"></span></button>
								    </td>
							    </tr>
					    	</c:forEach>
					  	  </tbody>
		        
						</table>
	
					<div class="clearfix"></div>
					<ul class="pagination pull-right">
						<c:if test="${pm.prev}">
					  		<li class="disabled">
					  			<a href="memberList${pm.makeSearch(pm.startPage-1)}">&laquo;</a>
					  		</li>
					    </c:if>
					    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
 					 		<li <c:out value="${pm.cri.page == i?'class=active':''}"/>>
 					 			<a href="memberList${pm.makeSearch(i)}">${i}</a>
 					 		</li>
					  	</c:forEach>
					  	<c:if test="${pm.next && pm.endPage > 0}">
					  		<li>
					  			<a href="memberList${pm.makeSearch(pm.endPage+1)}">>&laquo;</a>
					  		</li>
					  	</c:if>
					</ul>
                
          		 </div>
            
        		</div>
			</div>
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
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="active">
					<a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a>
				</li>
				<li>
					<a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a>
				</li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane active" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript:;"> <i class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
							</a>
						</li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript:;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design
									<span class="pull-right-container">
										<span class="label label-danger pull-right">70%</span>
									</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger" style="width: 70%"></div>
								</div>
							</a>
						</li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading">
								Report panel usage
								<input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
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