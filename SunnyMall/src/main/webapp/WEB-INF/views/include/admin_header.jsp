<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<header class="main-header">

			<!-- Logo -->
			<a href="/admin/list" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span class="logo-mini">
					<b>A</b>LT
				</span> <!-- logo for regular state and mobile devices --> <span class="logo-lg">
					<b>Admin</b>LTE
				</span>
			</a>

			<!-- Header Navbar -->
			
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.admin == null}">
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button -->
							<p class="hidden-xs" style="color:white; margin-top:14px; margin-left:15px; margin-right:15px;">
							로그인 해주세요.
							</p>
						</li>
						<li class="dropdown user user-menu">
							<a href="/admin/admin_main"> 
								<span class="hidden-xs">로그인</span>
							</a>
						</li>
					</c:when>
					<c:when test="${sessionScope.admin != null}">
					
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu">
							<p class="hidden-xs" style="color:white; margin-top:14px;">
								최근 접속 시간: 
								<fmt:formatDate value="${sessionScope.admin.admin_lastdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</p>
						</li>
						<!-- /.messages-menu -->
	
						
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
								<!-- Menu Toggle Button -->
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <!-- The user image in the navbar-->
										<img src="/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. --> <span class="hidden-xs">${sessionScope.admin.admin_name}</span>
								</a>
								<ul class="dropdown-menu">
									<!-- The user image in the menu -->
									<li class="user-header">
										<img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
	
										<p>
											${sessionScope.admin.admin_name} <small>Member since Nov. 2012</small>
										</p>
									</li>
								
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="#" class="btn btn-default btn-flat">Profile</a>
										</div>
										<div class="pull-right">
											<a href="/admin/adminLogout" class="btn btn-default btn-flat">Sign out</a>
										</div>
									</li>
								</ul>
						</li>
						
					</c:when>
					<c:otherwise></c:otherwise>
			   </c:choose>
			   </ul>
			   </div>
			</nav>
		</header>