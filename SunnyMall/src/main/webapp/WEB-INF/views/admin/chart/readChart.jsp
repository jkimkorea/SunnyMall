<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable('${str}');

        var options = {
          title: '매출 현황',
          hAxis: {title: 'Date',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>

<body>
   <%-- 챠트 위치 --%>
   <form action="/admin/chart/read" method="post">
		<label for="birthday">날짜 선택:</label>
		<input type="date" id="date_s" name="date_s" value="${date_s}">-
		<input type="date" id="date_e" name="date_e" value="${date_e}">까지
		<div id="chart_div" style="width: 50%; height: 250px;"></div>
		
   </form>
</body>

</html>