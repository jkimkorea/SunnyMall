<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(${str});

        var options = {
          title: '매출 현황',
          legend: { position: 'none' },
          colors: ['green'],
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
	<!-- REQUIRED JS SCRIPTS -->
	<%@ include file="/WEB-INF/views/include/plugins.jsp" %>
	<%@include file="/WEB-INF/views/include/admin_header.jsp" %>
	
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
				<ol class="breadcrumb">
					<li>
						<a href="#"><i class="fa fa-dashboard"></i> Level</a>
					</li>
					<li class="active">Here</li>
				</ol>
   <%-- 챠트 위치 --%>
   <form action="/admin/chart/searchChart" method="post">
		<label for="birthday">날짜 선택:</label>
		<input type="date" id="date_s" name="date_s" value="${date_s}">-
		<input type="date" id="date_e" name="date_e" value="${date_e}">까지
		<button type="submit" id="btn_readChart" name="btn_searchChart">검색</button>
		<div id="chart_div" style="width: 100%; height: 450px;"></div>
   </form>
				</section>
				</div>
   <!-- Main Footer -->
   <%@ include file="/WEB-INF/views/include/home_footer.jsp" %>
   <div class="control-sidebar-bg"></div>
   </div>
</body>

</html>