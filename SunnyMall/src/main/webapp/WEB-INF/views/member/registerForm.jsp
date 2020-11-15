<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop HomePage - Start Bootstrap Template</title>
    <!-- Bootstrap core JavaScript -->
  <%@ include file="/WEB-INF/views/include/shop_js.jsp" %>
	
  <script type="text/javascript" src="/js/member/register.js"></script>
 
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <%@ include file="/WEB-INF/views/include/shop_css.jsp" %>

</head>

<body>

  <!-- Navigation -->
  <%@ include file="/WEB-INF/views/include/home_header.jsp" %>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

		   <!-- sidebar -->
		   <%@ include file="/WEB-INF/views/include/home_sidebar.jsp" %>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
				
					<form id="joinForm" action="/member/register" method="post">
						
						<div class="container" style="width: 800px; padding: 10% 5%;">
							<h4>회원가입</h4>
							* 아래 항목을 작성해주세요.<br><br><br>
							<div class="form-group" style="width:100%;">
								<label for="inputId">* 아이디</label> <br /> <input type="text"
									class="form-control" id="mb_id" name="mb_id"
									placeholder="아이디를 입력해 주세요"
									style="max-width:540px; width:calc(100% - 100px); margin-right: 5px; display: inline-block;">
								<button id="btn_checkId" class="btn btn-default" type="button" style="background-color:gray">중복 확인</button>
								<p id="id_availability" style="color: red;"></p>
							</div>
							<div class="form-group">
								<label for="inputPassword">* 비밀번호</label> <input type="password"
									class="form-control" id="mb_pw" name="mb_pw"
									placeholder="비밀번호를 입력해주세요" style="max-width: 630px;">
							</div>
							<div class="form-group">
								<label for="inputPasswordCheck">* 비밀번호 확인</label> <input
									type="password" class="form-control" id="mb_pw_check"
									placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요" style="max-width: 630px;" >
							</div>
							<div class="form-group">
								<label for="inputName">* 이름</label> <input type="text"
									class="form-control" id="mb_name" name="mb_name"
									placeholder="이름을 입력해 주세요" style="max-width: 630px;">
							</div>
							<div class="form-group">
								<label for="inputNickName">* 닉네임</label> <input type="text"
									class="form-control" id="mb_nickname" name="mb_nickname"
									placeholder="사용할 닉네임을 입력해 주세요" style="max-width: 630px;">
							</div>
							<div class="form-group">
								<label for="InputEmail">* 이메일 주소</label><br /> <input type="email"
									class="form-control" id="mb_email" name="mb_email"
									placeholder="이메일 주소를 입력해주세요"
									style="max-width: 526px; width:calc(100% - 115px); margin-right: 5px; display: inline-block;">
								<button id="btn_sendAuthCode" class="btn btn-default" type="button" style="background-color:gray">이메일 인증</button>
								<p id="authcode_status" style="color: red;"></p>
							</div>
							<!-- 이메일 인증 요청을 하고 , 성공적으로 진행이 되면, 아래 div태그가 보여진다. -->
							<div id="email_authcode" class="form-group" style="display: none;">
								<label for="inputAuthCode">* 이메일 인증코드</label><br /> 
								<input type="text"
									class="form-control" id="mb_authcode" 
									placeholder="이메일 인증코드를 입력해 주세요" 
									style="max-width: 570px; width:calc(100% - 70px); margin-right: 5px; display: inline-block;" />
								<button id="btn_checkAuthCode" class="btn btn-default" type="button"style="background-color:gray" >확인</button>
							</div>
							<div class="form-group">
								<label for="inputMobile">* 휴대폰 번호</label> <input type="tel"
									class="form-control" id="mb_phone" name="mb_phone"
									placeholder="휴대폰 번호를 입력해 주세요" style="max-width: 630px;">
							</div>
							<div class="form-group">
								<label for="inputAddr">* 주소</label> <br />
								<input type="text" id="sample2_postcode" name="mb_zipcode" class="form-control" 
									style="max-width: 510px; width:calc(100% - 128px); margin-right: 5px; display: inline-block;" placeholder="우편번호" readonly>
								<input type="button" onclick="sample2_execDaumPostcode()" id="btn_postCode" class="btn btn-default" style="background-color:gray" value="우편번호 찾기"><br>
								<input type="text" id="sample2_address" name="mb_add" class="form-control" 
									placeholder="주소" style="max-width: 630px; margin:3px 0px;" readonly>
								<input type="text" id="sample2_detailAddress" name="mb_add_d" class="form-control" 
									placeholder="상세주소" style="max-width: 630px;">
								<input type="hidden" id="sample2_extraAddress" class="form-control" 
									placeholder="참고항목">
							</div>
							<div class="form-group">
								<label>* 수신 동의</label><br /> 
								이벤트 등 프로모션 메일 알림 수신에 동의합니다.
								<label><input type="radio" name="mb_email_accept" value="Y" style="margin-left: 20px;" checked="checked"> 예</label>
	      						<label><input type="radio" name="mb_email_accept" value="N" style="margin-left: 20px;"> 아니오</label>
							</div>
						</div>
						<div class="form-group text-center">
							<button type="button" id="btn_submit" class="btn btn-primary">
								회원가입 <i class="fa fa-check spaceLeft"></i>
							</button>
							<button type="button" id="btn_cancle" class="btn btn-warning">
								가입취소 <i class="fa fa-times spaceLeft"></i>
							</button>
						</div>
						<br><br><br><br>
					</form>
				
				<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
				<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
				
				</div>
				
				<%-- 우편번호API 동작코드 --%>
				<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>

</body>

