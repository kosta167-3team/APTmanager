<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawVisualization);
	
		function drawVisualization() { 
			var data = google.visualization.arrayToDataTable([
					['', '전체 평균', '내 사용량', 'Madagascar', 'Papua New Guinea', 'Rwanda', 'Average'],
					['2004/05',  165,      938,         522,             998,           450,      614.6],
					['2005/06',  135,      1120,        599,             1268,          288,      682],
					['2006/07',  157,      1167,        587,             807,           397,      623],
					['2007/08',  139,      1110,        615,             968,           215,      609.4],
					['2008/09',  136,      691,         629,             1026,          366,      569.6]
				]);
			var options = {
					title : 'Monthly Coffee Production by Country',
					vAxis: {title: 'Cups'},
					hAxis: {title: 'Month'}, 
					seriesType: 'bars',
					series: {5: {type: 'line'}}
				};
			
			var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			chart.draw(data, options);
		}
	</script>

<body>
	전체 전기 평균 : ${allElec } , 내 평균 ${meBill.elec_bill() }
	전체 열 평균 : ${allHeat }, 내 평균 : ${meBill.heat_bill() }
	전체 물 평균 : ${allWater } 내 평균 : ${meBill.water_bill() }
	
	<div id = 'chart_div'>
	
	</div>
	
</body>
</html>