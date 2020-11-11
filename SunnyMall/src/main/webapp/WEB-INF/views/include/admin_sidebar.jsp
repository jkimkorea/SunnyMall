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
							<p>${sessionScope.admin.admin_id }</p>
							<!-- Status -->
							<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.admin == null}">
					<div class="user-panel">
						<p style="color:#b8c7ce; margin-top:10px; padding-left:5px;">SunnyMall Admin Page</p>
					</div>
				</c:if>
				<!-- search form (Optional) -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button type="submit" name="search" id="search-btn" class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
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
								<a href="/admin/delivery/deliveryList">재고 관리</a>
							</li>
						</ul>
					</li>
					
					<li class="treeview">
						<a href="#"><i class="fa fa-link"></i> <span>회원관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu">
							<li>
								<a href="/admin/member/memberList">회원정보 조회</a>
							</li>
							<li>
								<a href="#">회원정보 관리</a>
							</li>
						</ul>
					</li>
				</c:if>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

