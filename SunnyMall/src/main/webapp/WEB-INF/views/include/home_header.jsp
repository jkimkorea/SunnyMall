<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <!-- Custom styles for this template -->
<%@ include file="/WEB-INF/views/include/shop_css.jsp" %>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/">SUNNY MALL</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
   
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <%--로그인 상태 --%>
          <c:if test="${sessionScope.user==null}">
          <li class="nav-item">
            <a class="nav-link" href="/member/loginPage">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/registerForm">회원가입</a>
          </li>
          </c:if>
          <%--로그인 한 상태 --%>
          <c:if test="${sessionScope.user!=null}">
          <li class="nav-item" style="font-size:12px">
			  <a class="nav-link"> 
			최근 접속 시간: 
			<fmt:formatDate value="${sessionScope.user.mb_date_last}" pattern="yyyy-MM-dd HH:mm:ss"/>
			 </a>
		  </li>
          <li>
             <a class="nav-link" href="/member/logout" style="font-size:12px">로그아웃</a>
          </li>
          <li class="dropdown">
             <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:#FFFFFF80; padding:.5rem 1rem; text-decoration: none;display:block;font-size:12px">
             	회원정보 관리<span class="caret"></span>
             </a>
          <ul class="dropdown-menu" id= "modify_dropdown">
			<li>
			<a href="/member/modifyGet" style="color:black;">회원정보 수정</a></li>
			<li><a href="/member/changePwPage" style="color:black;">비밀번호 변경</a></li>
		  </ul>
		  
		  </li>
          
          <li class="nav-item">
            <a class="nav-link" href="/cart/cartList" style="font-size:12px">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/order/orderList" style="font-size:12px">주문조회</a>
          </li>
          </c:if>
        </ul>
      </div>
    </div>
    	<!-- 검색 -->
		<form action="/product/listSearch" method="get" class="sidebar-form">
			<div class="input-group mb-3 input-group-sm ">
				<input type="hidden" name="searchType" class="form-control" value="name_detail">
				<input type="text" name="keyword" class="form-control" placeholder="상품 검색"  
					<c:if test="${!empty scri}">
						value="<c:out value='${scri.keyword}' />"
					</c:if>
					style="background-color: #; color:#B8C7CE">
				<span class="input-group-append">
					<button type="submit" name="search" id="search-btn" class="btn btn-flat" style="background-color: #ffffff" >
						<i class="fa fa-search">검색</i>
					</button>
				</span>
			</div>
		</form>
  </nav>