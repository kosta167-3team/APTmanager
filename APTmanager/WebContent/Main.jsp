<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="naver-site-verification" content="c24c9ad081b21a2c303475db4c4a60a3d4106a9b">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="No-Cache">
<meta name="viewport" content="width=1280">



<link href="/APTmanager/css/common/common.css" rel="stylesheet">
<link href="/APTmanager/css/common/layout.css" rel="stylesheet">
<link href="/APTmanager/css/common/header.css" rel="stylesheet">
<link href="/APTmanager/css/common/footer.css" rel="stylesheet">


<link href="/APTmanager/css/main/main.css" rel="stylesheet">

<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/main/jquery.jplayer.js"></script>
<script src="/APTmanager/js/common/common.js"></script>
<script src="/APTmanager/js/main/main.js"></script>
<title>삼성 힐스테이트 1단지</title>

</head>
<body>
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
								<li><a href="http://www.prugio.com/sale/sale.aspx?menu=0">인사말</a></li>
								<li><a href="http://www.prugio.com/sale/sale.aspx?menu=1">평면도</a></li>
								<li><a href="http://www.prugio.com/sale/sale.aspx?menu=2">위치정보</a></li>
							</ul>
						</li>
						<li class="menu2">
							<a href="month.bill">관리비</a>
							<ul class="gnb_list">
								<li><a href="month.bill">관리비 상세</a></li>
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
						<a id = "login" href="#" onclick = "login();">로그인</a> 
						<a	href="http://www.prugio.com/customer/faq.aspx">고객센터</a> 
						<a	href="http://www.prugio.com/myprugio/myprugio.aspx">마이푸르지오</a>
					</div>
				</div>
				<div class="gnb_bg"></div>
			</div>
		</div>
		<!-- //header -->

		<div id="container" class="main">
			<div class="intro_cover">
				<div id="player_wrap" class="player_wrap">
					<div id="player"></div>
				</div>
				<div class="cover_txt">
					<a href="javascript:void(0)" class="mov_pause">일시정지/플레이</a>
					<p>위 영상은 실제 푸르지오에서 촬영된 영상입니다.</p>
				</div>

				<div class="cover_btn">
					<div class="inner">
						<a href="./sale/sale.aspx?menu=0" class="num01">신규분양 보기</a> 
						<a	href="./brand/pr-video.aspx" class="num02">홍보영상 보기</a> 
						<a	href="./cast/news.aspx" class="num03">이벤트 보기</a>
					</div>
				</div>
			</div>
			
			<div class="contents">
			
			<p id = "allBill_title" >${personBill.p_month } 월 청구서 </p>
			<p class = "allBill_content">  요금 : <fmt:formatNumber value="${personBill.allBill()/17 }" pattern="0"/>원 </p>
			<p class = "resident_content">삼성 힐스테이트 1단지 ${resident.r_dong } 동  ${resident.r_ho }호</p>  <br>
			<p class = "resident_content">${resident.r_name }님</p>
				
			</div>
				
		</div>
	</div>
		<!-- footer -->


		<div id="footer">
			<div class="inner">
				<a href="/main.aspx" class="footer_logo"><img src="/APTmanager/css/images/common/logo.png" alt="PRUGIO"></a>
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
				<span class="icsi_logo">
					<img src="/APTmanager/css/images/common/logo_01.png" alt="" />
				</span> 
				<span class="icsi_logo">
					<img src="/APTmanager/css/images/common/logo_02.png" alt="" />
				</span>
				<div class="right_cont">
					<p class="customer_tel">고객센터 1670-1000</p>
					<a href="http://www.daewooenc.com/" target="_blank" class="dwlogo">
						<img src="/APTmanager/css/images/common/footer_logo_daewooenc.png" alt="(주)대우건설">
					</a>
				</div>
			</div>
		</div>
</body>
</html>
