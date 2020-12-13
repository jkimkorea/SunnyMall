<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<c:if test="${sessionScope.admin != null}">
					<!-- Sidebar user panel (optional) -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>${sessionScope.admin.admin_id}</p>
							<!-- Status -->
							<i class="fa fa-circle text-success"></i> Online
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.admin == null}">
					<div class="user-panel">
						<p style="color:#b8c7ce; margin-top:10px; padding-left:5px;">SunnyMall Admin Page</p>
					</div>
				</c:if>
				<!-- /.search form -->

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">MENU</li>
					<!-- Optionally, you can add icons to the links -->
				<c:if test="${sessionScope.admin != null}">
					<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>상품관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="/admin/product/admin_insertPage">상품등록</a>
							</li>
							<li>
								<a href="/admin/product/list">상품리스트</a>
							</li>
						</ul>
					</li>
					<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>주문관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="/admin/delivery/deliveryList">배송 관리</a>
							</li>
							<li>
								<a href="/admin/stock/stockList">재고 관리</a>
							</li>
							<li>
								<a href="/admin/chart/readChart">매출 현황</a>
							</li>
						</ul>
					</li>
					
					<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>회원관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="/admin/member/memberList">회원 리스트</a>
							</li>
							<li>
								<a href="/admin/member/delMemberList">탈퇴회원 리스트</a>
							</li>
						</ul>
					</li>
					<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>게시판 관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="#">상품 문의</a>
							</li>
							<li>
								<a href="#">상품 후기</a>
							</li>
						</ul>
					<%--></li>
						<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>디자인 관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="#">메인 화면</a>
							</li>
							
						</ul>
					</li>--%>
				</c:if>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

