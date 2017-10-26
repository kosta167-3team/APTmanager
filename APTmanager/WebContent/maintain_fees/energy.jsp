<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    
    function drawChart() {
      var options = {
        title: "에너지 사용량",
        width: 300,
        height: 400,
        bar: {groupWidth: "35%"},
        legend: { position: "none" },
        animation:{
          duration: 1000,
          easing: 'out',
        }
      };
       var ElecData = google.visualization.arrayToDataTable([
        ["종류", "전체 평균", "내 평균" ],
        ["전체 전기비", ${allElec}, ${meBill.elec_bill()}]
      ]); 
       var heatData = google.visualization.arrayToDataTable([
           ["종류", "전체 평균", "내 평균" ],
           ["전체 열비", ${allHeat}, ${meBill.heat_bill()}]

         ]); 
       var waterData = google.visualization.arrayToDataTable([
           ["종류", "전체 평균", "내 평균" ],
           ["전체 수도비", ${allWater}, ${meBill.water_bill()}]
         ]); 

      var ElecDataView = new google.visualization.DataView(ElecData);
      var heatDataView = new google.visualization.DataView(heatData);
      var waterDataView = new google.visualization.DataView(waterData);
      
      var elecChart_div = new google.visualization.ColumnChart(document.getElementById("elecChart_div"));
      var heatChart_div = new google.visualization.ColumnChart(document.getElementById("heatChart_div"));
      var waterChart_div = new google.visualization.ColumnChart(document.getElementById("waterChart_div"));
      elecChart_div.draw(ElecDataView, options);
      heatChart_div.draw(heatDataView, options);
      waterChart_div.draw(waterDataView, options);
    };
  </script>

	<style type="text/css">
	
		.billChart{
			display: inline;
			float: left;
		}
	</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	
<body>
	전체 전기 평균 : ${allElec } , 내 평균 ${meBill.elec_bill() }
	전체 열 평균 : ${allHeat }, 내 평균 : ${meBill.heat_bill() }
	전체 물 평균 : ${allWater } 내 평균 : ${meBill.water_bill() }
	
	<div class = "billChart" id = "elecChart_div">
	
	</div>
	<div class = "billChart" id = "heatChart_div">
	
	</div>
	<div class = "billChart" id = "waterChart_div">
	
	</div>
	
</body>
</html>