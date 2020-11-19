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
		<label for="birthday">날짜 선택:</label>
		<input type="date" id="birthday" name="birthday">-
		<input type="date" id="birthday" name="birthday">까지
		<div id="chart_div" style="width: 50%; height: 250px;"></div>
</body>

</html>