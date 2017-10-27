<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ko">
<head>

<!-- <link href="css/common.css" rel="stylesheet"> -->
<!-- <link href="/APTmanager/css/sub.css" rel="stylesheet"> -->

<link href="/APTmanager/css/common/common.css" rel="stylesheet">
<link href="/APTmanager/css/common/layout.css" rel="stylesheet">
<link href="/APTmanager/css/common/header.css" rel="stylesheet">
<link href="/APTmanager/css/common/footer.css" rel="stylesheet">


<link href="/APTmanager/css/bill/story.css" rel="stylesheet">
<link href="/APTmanager/css/bill/lnb.css" rel="stylesheet">
<link href="/APTmanager/css/bill/energyBill.css" rel="stylesheet">


<!-- google chart js -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/common/common.js"></script>
<script src="/APTmanager/js/common/jquery.blockUI.js"></script>
<script src="/APTmanager/js/bill/EnergyBill.js"></script>
<script>
	lnbName = "brand_lnb";
	lnbBrand = 1;	
</script>

<title>브랜드 스토리 | 브랜드 | 푸르지오</title>
</head>
<body>
	<script type="text/javascript">
		var theForm = document.forms['story'];
		if (!theForm) {
			theForm = document.story;
		}
		function __doPostBack(eventTarget, eventArgument) {
			if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
				theForm.__EVENTTARGET.value = eventTarget;
				theForm.__EVENTARGUMENT.value = eventArgument;
				theForm.submit();
			}
		}
		
		google.charts.load("current", {packages:['corechart']});
	    google.charts.setOnLoadCallback(drawChart);
	    
	    function drawChart() {    
	    	 var widthOption = {
	    	title: "면적 대 비용 비교 ",
	     	width: 250,
	    	height: 400,
	    	bar: {groupWidth: "35%"},
	    	legend: { position: "none" },
	    	animation:{
	    		duration: 2000,
	    		easing: 'out',
	        }
	      };
	     
	    
	      var options = {
	        title: "에너지 사용량",
	        width: 250,
	        height: 400,
	        bar: {groupWidth: "35%"},
	        legend: { position: "none" },
	        animation:{
	          duration: 200,
	          easing: 'out',
	        }
	      };
	      
	      var widthData = google.visualization.arrayToDataTable([
	    	  ["종류", "전체 평균", "내 평균" ],
		        ["전체 전기비", ${me}, ${average}]
		      ]);  
	      
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
	      var widthDataView = new google.visualization.DataView(widthData);
	      
	      var elecChart_div = new google.visualization.ColumnChart(document.getElementById("elecChart_div"));
	      var heatChart_div = new google.visualization.ColumnChart(document.getElementById("heatChart_div"));
	      var waterChart_div = new google.visualization.ColumnChart(document.getElementById("waterChart_div"));
	      var widthChart_div = new google.visualization.ColumnChart(document.getElementById("widthChart_div"));
	      
	      elecChart_div.draw(ElecDataView, options);
	      heatChart_div.draw(heatDataView, options);
	      waterChart_div.draw(waterDataView, options);
	      widthChart_div.draw(widthDataView, widthOption);
	    };
		
	</script>

	<!-- wrap -->
	<div id="wrap">
		<!-- header -->
		<div class="main_gnb">

			<div id="header">
				<div class="inner">
					<h1>
						<a href="Main.bill">
							<img src="/APTmanager/css/images/common/logo.png" alt="HILLSTATE">
						</a>
					</h1>
					<ul id="gnb" class="gnb">
						<li class="menu1">
							<a href="#">아파트소개</a>
							<ul class="gnb_list">
								<li><a href="#">인사말</a></li>
								<li><a href="#">평면도</a></li>
								<li><a href="#">위치정보</a></li>
							</ul>
						</li>
						<li class="menu2">
							<a href="month.bill">관리비</a>
							<ul class="gnb_list">
								<li><a href="monthBill.bill">관리비 상세</a></li>
								<li><a href="energy.bill">관리비 비교</a></li>
								<li><a href="#">연간 관리비 비교</a></li>
							</ul>
						</li>
						<li class="menu3">
							<a href="#" onclick = "visit()">외부인예약</a>
							<ul class="gnb_list">
								<li><a href="#" onclick = "visit()">예약</a></li>
								<li><a href="http://www.prugio.com/brand/news.aspx">조회</a></li>
								<li><a href="http://www.prugio.com/brand/pr-video.aspx">취소</a></li>
							</ul>
						</li>
						<li class="menu4"><a href="/APTmanager/facility_reservation/1start.jsp">시설예약</a> 
							<ul class="gnb_list">
								<li><a href="/APTmanager/guest/facilityReview.jsp">시설후기작성</a></li>
								<li><a href="/APTmanager/guest/facilityRule.jsp">준수사항</a></li>
							</ul>
						</li>
						<li class="menu5">
							<a href="/APTmanager/RealEstate/start.jsp">부동산</a>
							<ul class="gnb_list">
								<li><a href="/APTmanager/RealEstate/start.jsp">내 아파트 시세</a></li>
								<li><a href="#">주변 아파트 시세</a></li>
							</ul>
						</li>
						
					</ul>
					
					<div id="util_id" class="util">
						<a href="https://www.prugio.com/membership/login.aspx">로그인</a> 
						<a	href="http://www.prugio.com/customer/faq.aspx">고객센터</a> 
						<a	href="http://www.prugio.com/myprugio/myprugio.aspx">마이푸르지오</a>
					</div>
				</div>
				<div class="gnb_bg"></div>
			</div>
		</div>
		<!-- //header -->
		<!-- container -->
		<div id="container" class="story">
		
			<div class="contents">
				<!-- lnb -->

				
				<div id="lnb" class="lnb">
					<div class="lnb_list customer">
						<h2>
							<img src="/APTmanager/css/images/common/title_h2.gif" alt="고객센터">
						</h2>
					</div>
					
					<div class="lnb_list brand_lnb">
						<h2>
							<img src="/APTmanager/css/bill/images/billLogo.png" alt="브랜드">
						</h2>
						<ul class="depth">
							<li><a href="month.bill">관리비 상세</a></li>
							<li><a href="energy.bill">관리비 비교</a></li>
							<li><a href="http://www.prugio.com/sale/sale.aspx?menu=2">연간 관리비 비교</a></li>
						</ul>
					</div>
				</div>
				<script>
					switch (lnbName) {
					case "brand_lnb":
						$("#lnb").children(".brand_lnb").addClass("on").find(
								".depth").children("li").eq(lnbBrand - 1)
								.addClass("on");
						break;
					default:
						break;
					};
				</script>
				<!-- // lnb -->
				
				<div class="contents_box">
				
				<div class = "sub_title">
					<h3> 관리비 비교 </h3>
					<p> 각종 평균과 비교합니다.</p>
				</div>	
					<div class="chartDiv">
						<div class="billChart" id="elecChart_div"></div>
						<div class="billChart" id="heatChart_div"></div>
						<div class="billChart" id="waterChart_div"></div>
						<div class="billChart" id = "widthChart_div"></div>
					</div>
					
					<table id = "energyTable">
						<tr class = "energyTable_title">
							<td>항목</td>
							<td>평균</td>
							<td>세대</td>
							<td>차이</td>						
						</tr>
						<tr>
							<td>전기</td>
							<td> <fmt:formatNumber value = "${allElec }" pattern="0"/> </td>
							<td> <fmt:formatNumber value = "${meBill.elec_bill() }" pattern="0"/> </td>
							<td><fmt:formatNumber value = "${ meBill.elec_bill() - allElec }" pattern="0"/></td>
						</tr>
						<tr>
							<td>열</td>
							<td><fmt:formatNumber value = "${allHeat }" pattern="0"/></td>
							<td><fmt:formatNumber value = "${meBill.heat_bill() }" pattern="0"/></td>
							<td><fmt:formatNumber value = "${ meBill.heat_bill()- allHeat  }" pattern="0"/></td>
						</tr>
						<tr>
							<td>물</td>
							<td><fmt:formatNumber value = "${allWater }" pattern="0"/></td>
							<td><fmt:formatNumber value = "${meBill.water_bill() }" pattern="0"/></td>
							<td><fmt:formatNumber value = "${meBill.water_bill() - allWater }" pattern="0"/></td>
						</tr>
						<tr>
							<td>면적 (${meBill.width })</td>
							<td><fmt:formatNumber value = "${me }" pattern="0"/></td>
							<td><fmt:formatNumber value = "${average }" pattern="0"/></td>
							<td> <fmt:formatNumber value = "${result }" pattern="0"/></td>
						</tr>
					
					</table>
					
					
				</div>
			</div>
		</div>
		<!-- //container -->
		<!-- footer -->


		<div id="footer">
			<div class="inner">
				<a href="/main.aspx" class="footer_logo"><img
					src="/APTmanager/css/images/common/logo.png" alt="PRUGIO"></a>
				<div class="center_cont">
					<div class="footer_util">
						<a href="http://www.prugio.com/membership/user-guidelines.aspx">이용약관</a>
						<a href="http://www.prugio.com/membership/privacy-statement.aspx">개인정보처리방침</a>
						<a href="http://www.prugio.com/membership/email-security.aspx">이메일무단수집거부</a>
					</div>
					<address>
						법인명 : (주)대우건설 서울특별시 종로구 새문안로 75(신문로 1가) 사업자 등록번호 : 104-81-58180<br>
						Copyright www.prugio.com All rights reserved.
					</address>
				</div>
				<span class="icsi_logo"><img src="/APTmanager/css/images/common/logo_01.png" alt="" /></span> 
				<span class="icsi_logo"><img src="/APTmanager/css/images/common/logo_02.png" alt="" /></span>
				<div class="right_cont">
					<p class="customer_tel">고객센터 1670-1000</p>
					<a href="http://www.daewooenc.com/" target="_blank" class="dwlogo">
					<img src="css/images/common/footer_logo_daewooenc.png" alt="(주)대우건설"></a>
				</div>
			</div>
		</div>
		<!-- //footer -->
	</div>
	<!-- //wrap -->
</body>
</html>

