<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var options = {
        title: "${lastMonthRent.a_name}의\n${lastMonthRent.rr_year} / ${lastMonthRent.rr_month}월시세 (㎡)",
        width: 300,
        height: 400,
        bar: {groupWidth: "35%"},
        legend: { position: "none" },
        animation:{
          duration: 1000,
          easing: 'out',
        }
      };
       var data = google.visualization.arrayToDataTable([
        ["Element", "가격", { role: "style" } ],
        ["전세", ${lastMonthRent.rr_deposit}, "#FF6C6C"],
        ["매매", ${lastMonthTrade.rt_price}, "#53C14B"],
        
      ]); 

      var view = new google.visualization.DataView(data);
      

      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>
  </head>
  <body>
    <div id="columnchart_values" ></div>
  </body>
</html>