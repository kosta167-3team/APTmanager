<%@page import="real_estate.model.RealEstate_rent"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#columnchart_lastMonth g:FIRST-CHILD{
		margin-top: 50px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">

	var $r_year ;
	var $r_month ;
	var $r_deposit ;
	
	var $t_year ;
 	var $t_month ;
 	var $t_deposit ;
 	
 	var r_size;
 	
 	var t_size;
 
 $(function(){

 	
 	$r_year = $('.r_year');
 	$r_month = $('.r_month');
 	$r_deposit =$('.r_deposit');
 	
 	 r_size =$r_year.length;
 	
 	for(var i = 0 ; i < r_size; i++){
 		console.log($r_year[i].value +"/" + $r_month[i].value +"  " +$r_deposit[i].value);
 	}
 	
 	 $t_year = $('.t_year');
 	 $t_month = $('.t_month');
 	 $t_deposit =$('.t_deposit');
 	
 	 t_size =$t_year.length;
 	
 	for(var i = 0 ; i < t_size; i++){
 		console.log($t_year[i].value +"/" + $t_month[i].value +"  " +parseInt($t_deposit[i].value));
 	}
 	 

 	
 });
 
 	 google.charts.load('current', {'packages':['line']});
     google.charts.setOnLoadCallback(drawChart);
  	
     var z;
     function findDeposit(date){
    	 for(var i = 0 ; i < r_size; i++){
    		 var chkD = $r_year[i].value +"/" + $r_month[i].value;
    		 if(chkD == date){
    			 z = i;
    			 return parseInt($r_deposit[i].value);
    		 }
    	 }
    	 return parseInt($r_deposit[z].value);
     }
     function drawChart() {

     var data = new google.visualization.DataTable();
     data.addColumn('string', '년/월');
     data.addColumn('number', '전세');
     data.addColumn('number', '매매');
     
     for(var i = 0; i <t_size ; i++){
    	 var t_date = $t_year[i].value +"/" + $t_month[i].value;
    	// var r_date= $r_year[j].value +"/" + $r_month[j].value;
    	 var t_m = parseInt($t_deposit[i].value);
    	 var r_m ;
    	 
    	data.addRow([t_date,findDeposit(t_date),t_m]);
    	
     } 

     var options = {
       chart: {
        /*  title: "${lastMonthRent.a_name}의 전세/매매 추이 (1㎡)",
         subtitle: '시세 추이' */
       },
       width: 400,
       height: 300,
       
     };

     var chart = new google.charts.Line(document.getElementById('curve_chart_annual'));

     chart.draw(data, google.charts.Line.convertOptions(options));
   }
 
	
	
</script>
</head>
<body>

	<div id="annual_contents">
		<h2 >1년간 시세 추이</h2>
		<div id="curve_chart_annual" ></div>
  </div>
	<c:forEach var="annualRent" items="${annualRent}">
		<input type="hidden" class="r_year" value="${annualRent.rr_year}">
		<input type="hidden" class="r_month" value="${annualRent.rr_month}">
		<input type="hidden" class="r_deposit"
			value="${annualRent.rr_deposit}">
	</c:forEach>
	<c:forEach var="annualTrade" items="${annualTrade}">
		<input type="hidden" class="t_year" value="${annualTrade.rt_year}">
		<input type="hidden" class="t_month" value="${annualTrade.rt_month}">
		<input type="hidden" class="t_deposit" value="${annualTrade.rt_price}">
	</c:forEach>

</body>
</html>
