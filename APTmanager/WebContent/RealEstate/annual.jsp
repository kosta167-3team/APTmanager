<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart);

  function drawChart() {

    var data = new google.visualization.DataTable();
    data.addColumn('number', '년/월');
    data.addColumn('number', '매매');

    console.log(${annualRent.size()});

 /*    for(var list in ${annualRent}){
    	alert(list.rr_year);
    } */
    data.addRows([
        [1,  37.8],
        [2,  30.9]
        ]); 
   /*  data.addRows([
      [1,  37.8],
      [2,  30.9, 69.5],
      [3,  25.4,   5]
    ]); */

    var options = {
      chart: {
        title: 'Box Office Earnings in First Two Weeks of Opening',
        subtitle: 'in millions of dollars (USD)'
      },
      width: 900,
      height: 500
    };

    var chart = new google.charts.Line(document.getElementById('curve_chart'));

    chart.draw(data, google.charts.Line.convertOptions(options));
  }
    </script>
</head>
<body>
	<div id="curve_chart" style="width: 900px; height: 500px"></div>
	NEW1
</body>
</html>
