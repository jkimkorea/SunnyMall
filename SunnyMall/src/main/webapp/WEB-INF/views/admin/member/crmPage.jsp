<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<!-- REQUIRED JS SCRIPTS -->
<%@ include file="/WEB-INF/views/include/plugins.jsp" %>

<script>
$(function(){
	$("#btn_comment").click(function(){
		var ad_comment = $("#ad_comment").val();
		var mb_id = $("input[name='mb_id']").val();
	
		$.ajax({
			url:'/admin/member/addComment',
			type:'post',
			dataType:'text',
			data:{
				ad_comment:ad_comment,
				mb_id:mb_id
			},
			success:function(data){
				window.location.reload("/admin/member/crmPage");
			}
		});
	});
});
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
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 회원 관리</a></li>
					<li class="active">회원 정보</li>
				</ol>
			</section>
			<div class="container">
    			<div class="row">
        
        			<div class="col-md-12">
        
			        <h5>>>회원 기본 정보</h5>
			        <div class="table-responsive">

						  <table class="table table-bordered">
						      <tr>
						        <th class="info" style="width : 20%; text-align:center;">이름</th>
						        <td>${memDetailVO.mb_name}</td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">ID</th>
						        <td>${memDetailVO.mb_id}</td>
						      </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">닉네임</th>
						        <td>${memDetailVO.mb_nickname}</td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">연락처</th>
						        <td>${memDetailVO.mb_phone}</td>
						      </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">Email</th>
						        <td>${memDetailVO.mb_email}</td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">우편번호</th>
						        <td>${memDetailVO.mb_zipcode}</td>
						      </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">주소</th>
						        <td>${memDetailVO.mb_add}${memDetailVO.mb_add_d}</td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">포인트</th>
						        <td>${memDetailVO.mb_point}</td>
						      </tr>
						    </tbody>
						  </table>
						</div>
						 <h5>>>회원 이용 정보</h5>
			        <div class="table-responsive">
		            
						  <table class="table table-bordered">
						      <tr>
						        <th class="info" style="width : 20%; text-align:center;">최초 가입일</th>
						        <td><fmt:formatDate value="${memDetailVO.mb_date_first}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">최근 접속일</th>
						        <td><fmt:formatDate value="${memDetailVO.mb_date_last}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						      </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">주문 총 수량</th>
						        <td>${memDetailVO.ord_total_amount}</td>
						       </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">주문 총 금액</th>
						        <td><fmt:formatNumber value="${memDetailVO.ord_total_price}" pattern="###,###,###"/>원</td>
						      </tr>
						       <tr>
						        <th class="info" style="width : 20%; text-align:center;">게시물</th>
						        <td>리뷰 : [${reviewCount}]개</td>
						       </tr>
						    </tbody>
						  </table>
						</div>
				        <div class="container">
						  	<h5>>>관리자 메모</h5>
						  	<p></p>
						  	<form>
							    <div class="form-group">
							      <label for="comment">Comment:</label>
							      <textarea class="form-control" rows="5" id="ad_comment">${memDetailVO.ad_comment}</textarea>
							    </div>
							    <input type="hidden" name="mb_id" id="mb_id" value="${memDetailVO.mb_id}">
							    <button id="btn_comment" name="btn_comment" class="btn btn-info btn-xs"  type="submit">확인</button>
						 		<br><br>
						 	</form>
						</div>
          			 </div>
            
        		</div>
			</div>
		</div>

		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

</body>
</html>