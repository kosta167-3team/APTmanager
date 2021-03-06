<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String body = request.getParameter("body");

	if (body == null) {
		body = "showMyAptPrice.jsp";
	}
%>
<!doctype html>
<html lang="ko">
<head>

<!-- <link href="css/common.css" rel="stylesheet"> -->
<!-- <link href="/APTmanager/css/sub.css" rel="stylesheet"> -->

<link href="/APTmanager/css/common/common.css" rel="stylesheet">
<link href="/APTmanager/css/common/layout.css" rel="stylesheet">
<link href="/APTmanager/css/common/header.css" rel="stylesheet">
<link href="/APTmanager/css/common/footer.css" rel="stylesheet">


<link href="/APTmanager/css/realEstate/story.css" rel="stylesheet">
<link href="/APTmanager/css/bill/lnb.css" rel="stylesheet">


<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/common/jquery.blockUI.js"></script>
<script src="/APTmanager/js/common/header.js"></script>

<link href="/APTmanager/css/realEstate/realEstate.css" rel="stlyesheet">

<script src="./js/vendor/jquery-1.10.2.min.js"></script>
<script src="./js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
<script src="./js/vendor/jquery.typoshadow.js"></script>

<style type="text/css">
.contents_box {overflow:hidden;float:left;width:870px; margin-left: 25%;}
#lnb h2{
	margin-bottom: 10px;
	text-align: center;
}

#annual_contents h2 {
	display: inline;
	margin-left: 0px;
}

#lastMoth_contents h2 {
	display: inline;
	float: none;
}

div #lastMoth_contents {
	float: left;
	padding-right: 20px;
	padding-left:20px;
	width: 300px;
	height: 400px;
	position: relative;
}

div #annual_contents {
	margin-left: 300px;
	width: 500px;
	height: 400px;
}

div #curve_chart_annual {
	padding-top: 50px;
	position: absolute;
	margin-left: 70px;
}

div #myAPTchart {
	margin-top: 20px;
	margin-left: 20px;
}

div #tot_price_wrap{
	width: 900px;
}
div .non-cat{
	border: solid 1px #EAEAEA;
	width: 800px;
	height: 400px;
	padding-left: 20px;
	padding-top: 20px;
	
}
div .cat {
	margin-top: 40px;
	border: solid 1px #EAEAEA;
	width: 800px;
	height: 380px;
	padding-left: 20px;
	padding-top: 20px;
}
div .cat h2{
	display: inline;
}
</style>
<title>브랜드 스토리 | 브랜드 | 푸르지오</title>
<script>
	lnbName = "brand_lnb";
	lnbBrand = 1;
</script>

<script type="text/javascript">
$(function(){
	
	/* $('#myAPTchart').on('mouseover', function(){
   	 	$(this).stop(true).animate({
      	  borderWidth: '12px',
       	 color: '#ae5e9b'
    }, duration, 'easeOutSine');
})
.on('mouseout', function(){
    $(this).stop(true).animate({
        borderWidth: '0px',
        color: '#ebc000'
    }, duration, 'easeOutSine');
});
}) */


</script>
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
	</script>

	<!-- wrap -->
	<div id="wrap">
		<!-- header -->
		
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
		<!-- container -->
		<div id="container" class="story">
			<div class="contents">
				<!-- lnb -->

				<div id="lnb" class="lnb">
					<div class="lnb_list customer">
						<h2 id = "logo">
							<img src="/APTmanager/css/images/common/title_h2.gif" alt="고객센터">
						</h2>
						<ul class="depth">
							<li><a href="http://www.prugio.com/customer/faq.aspx">FAQ</a></li>
							<li><a href="http://www.prugio.com/myprugio/my-qna.aspx">1:1
									상담</a></li>
							<li><a href="http://www.prugio.com/myprugio/my-as.aspx">A/S
									신청</a></li>
							<li><a href="http://www.prugio.com/customer/call.aspx">전화문의</a></li>

							<li><a href="http://www.prugio.com/myprugio/payment.aspx">분양대금
									조회</a></li>
							<li><a href="http://www.prugio.com/myprugio/document.aspx">민원서류
									신청</a></li>

						</ul>
					</div>
					<div class="lnb_list myprugio">
						<h2>
							<img src="/APTmanager/css/images/common/title_h2.gif"
								alt="마이푸르지오">
						</h2>
						<ul class="depth">
							<li><a href="https://www.prugio.com/myprugio/my-info.aspx">개인정보관리</a></li>
							<li><a
								href="https://www.prugio.com/myprugio/my-complex.aspx">나의
									분양단지</a></li>
							<li><a href="https://www.prugio.com/myprugio/my-qna.aspx">1:1
									상담</a></li>
							<li><a href="https://www.prugio.com/myprugio/my-as.aspx">A/S
									신청</a></li>

							<li><a href="https://www.prugio.com/myprugio/payment.aspx">분양대금
									조회</a></li>
							<li><a href="https://www.prugio.com/myprugio/document.aspx">민원서류
									신청</a></li>

							<li><a href="https://www.prugio.com/myprugio/visit.aspx">내집방문의날
									행사 예약</a></li>
							<li><a
								href="https://www.prugio.com/myprugio/move-reservation.aspx">입주예약</a></li>
							<li><a
								href="https://www.prugio.com/myprugio/withdrawal.aspx">회원탈퇴</a></li>
						</ul>
					</div>
					<div class="lnb_list brand_lnb">
						<h2>
							<img src="/APTmanager/css/images/common/title_h2.png"
								alt="부동산 시세 보기">
						</h2>
						<ul class="depth">
							<li><a
								href="/APTmanager/RealEstate/realEstate.jsp?body=start.jsp">내
									아파트 시세 보기</a></li>
							<!--<li><a href="http://www.prugio.com/brand/valley.aspx">푸르지오 밸리</a></li>-->
							<li><a href="#">주변
									아파트 시세보기</a></li>

						</ul>
					</div>
					<div class="lnb_list product_lnb">
						<h2>
							<img src="/APTmanager/css/images/common/title_h2.gif" alt="상품 안내">
						</h2>
						<ul class="depth">
							<li><a
								href="http://www.prugio.com/product/premium-green.aspx">프리미엄
									상품</a></li>
							<li><a href="http://www.prugio.com/product/merits-01.aspx">특화아이템</a></li>
							<li><a href="http://www.prugio.com/product/gallery.aspx">단지
									갤러리</a></li>
						</ul>
					</div>
					<div class="lnb_list prugio_guide">
						<h2>
							<img src="/APTmanager/css/images/common/title_h2.gif"
								alt="푸르지오정책">
						</h2>
						<ul class="depth">
							<li><a
								href="http://www.prugio.com/membership/user-guidelines.aspx">이용약관</a></li>
							<li><a
								href="http://www.prugio.com/membership/privacy-statement.aspx">개인정보처리방침</a></li>
							<li><a
								href="http://www.prugio.com/membership/email-security.aspx">이메일
									무단수집 거부</a></li>
						</ul>
					</div>
				</div>
				<script>
					switch (lnbName) {
					
					case "customer":
						$("#lnb").children(".customer").addClass("on").find(
								".depth").children("li").eq(lnbCustomer - 1)
								.addClass("on");
						break;
					case "myprugio":
						$("#lnb").children(".myprugio").addClass("on").find(
								".depth").children("li").eq(lnbMyprugio - 1)
								.addClass("on");
						break;
					case "brand_lnb":
						$("#lnb").children(".brand_lnb").addClass("on").find(
								".depth").children("li").eq(lnbBrand - 1)
								.addClass("on");
						break;
					case "prugio_guide":
						$("#lnb").children(".prugio_guide").addClass("on")
								.find(".depth").children("li").eq(lnbGuide - 1)
								.addClass("on");
						break;
					case "product_lnb":
						$("#lnb").children(".product_lnb").addClass("on").find(
								".depth").children("li").eq(lnbProduct - 1)
								.addClass("on");
						break;
					default:
						break;
					};
				</script>
				<!-- // lnb -->
				<div class="contents_box">

					<div class="my_apt_real_estate">
						<jsp:include page="<%=body%>"></jsp:include>
					</div>
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
					<span class="icsi_logo"><img
						src="/APTmanager/css/images/common/logo_01.png" alt="" /></span> <span
						class="icsi_logo"><img
						src="/APTmanager/css/images/common/logo_02.png" alt="" /></span>
					<div class="right_cont">
						<p class="customer_tel">고객센터 1670-1000</p>
						<a href="http://www.daewooenc.com/" target="_blank" class="dwlogo">
							<img src="css/images/common/footer_logo_daewooenc.png"
							alt="(주)대우건설">
						</a>
					</div>
				</div>
			</div>
			<!-- //footer -->
		</div>
		<!-- //wrap -->
</body>
</html>

