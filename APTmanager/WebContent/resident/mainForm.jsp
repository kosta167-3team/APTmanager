<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- <link href="css/common.css" rel="stylesheet"> -->
<!-- <link href="/APTmanager/css/sub.css" rel="stylesheet"> -->

<link href="/APTmanager/css/common/common.css" rel="stylesheet">
<link href="/APTmanager/css/common/layout.css" rel="stylesheet">
<link href="/APTmanager/css/common/header.css" rel="stylesheet">
<link href="/APTmanager/css/common/footer.css" rel="stylesheet">


<link href="/APTmanager/css/bill/story.css" rel="stylesheet">
<link href="/APTmanager/css/bill/lnb.css" rel="stylesheet">

<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/common/jquery.blockUI.js"></script>
<script src="/APTmanager/js/common/header.js"></script>

<script type="text/javascript">
	$(function(){
		$("#a").click(function(){
			$("#sub_title").load("createReservationForm.jsp");  //등록
		});
	});
	$(function(){
		$("#b").click(function(){
			$("#sub_title").load("listReservation.jsp");  //조회
		});
	});
	$(function(){
		$("#c").click(function(){
			$("#sub_title").load("createReservationForm.jsp");  //로그아웃
		});
	});
</script>

<title>브랜드 스토리 | 브랜드 | 푸르지오</title>
<script>
	lnbName = "brand_lnb";
	lnbBrand = 1;
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
					<a href="http://www.prugio.com/main.aspx"><img
						src="/APTmanager/css/images/common/logo.png" alt="PRUGIO"></a>
				</h1>
				<ul id="gnb" class="gnb">
					<li class="menu1"><a
						href="http://www.prugio.com/sale/sale.aspx">분양안내</a>
						<ul class="gnb_list">
							<li><a href="http://www.prugio.com/sale/sale.aspx?menu=0">신규분양</a></li>
							<li><a href="http://www.prugio.com/sale/sale.aspx?menu=1">추천분양</a></li>
							<li><a href="http://www.prugio.com/sale/sale.aspx?menu=2">상가분양</a></li>
							<li><a href="http://www.prugio.com/sale/plan.aspx">분양계획
									한눈에 보기</a></li>
							<li><a href="http://www.prugio.com/sale/map.aspx">지도로 보기</a></li>
						</ul></li>
					<li class="menu2"><a
						href="http://www.prugio.com/construction/construction.aspx">현장안내</a>
						<ul class="gnb_list">
							<li><a
								href="http://www.prugio.com/construction/construction.aspx">공사진행단지</a></li>
							<li><a
								href="http://www.prugio.com/construction/construction.aspx?menu=Y">입주진행단지</a></li>
						</ul></li>
					<li class="menu3"><a
						href="http://www.prugio.com/brand/brand.aspx">브랜드</a>
						<ul class="gnb_list">
							<li><a href="http://www.prugio.com/brand/story.aspx">브랜드
									스토리</a></li>
							<!--<li><a href="http://www.prugio.com/brand/valley.aspx">푸르지오 밸리</a></li>-->
							<li><a href="http://www.prugio.com/brand/news.aspx">푸르지오
									소식</a></li>
							<li><a href="http://www.prugio.com/brand/pr-video.aspx">브랜드
									PR</a></li>
							<li><a href="http://www.prugio.com/brand/award.aspx">수상경력</a></li>
							<li><a href="http://www.prugio.com/brand/record.aspx">시공실적</a></li>
							<li class="wide"><a
								href="http://www.prugio.com/brand/redevelop.aspx">재개발/재건축/<br>리모델링
							</a></li>
						</ul></li>
					<li class="menu4"><a
						href="http://www.prugio.com/cast/cast.aspx">캐스트</a>
						<ul class="gnb_list">
							<li><a href="http://www.prugio.com/cast/cast.aspx">전체보기</a></li>
							<li><a href="http://www.prugio.com/cast/news.aspx">소식&amp;이벤트</a></li>
							<li><a href="http://www.prugio.com/cast/complex.aspx">단지별
									캐스트</a></li>
						</ul></li>
					<li class="menu5"><a
						href="http://www.prugio.com/product/product.aspx">상품안내</a>
						<ul class="gnb_list">
							<li><a
								href="http://www.prugio.com/product/premium-green.aspx">프리미엄
									상품</a></li>
							<li><a href="http://www.prugio.com/product/merits-01.aspx">특화아이템</a></li>
							<li><a href="http://www.prugio.com/product/gallery.aspx">단지
									갤러리</a></li>
						</ul></li>
					<li class="menu6"><a
						href="http://www.prugio.com/life/life.aspx">라이프</a>
						<ul class="gnb_list">
							<li><a href="http://www.prugio.com/life/life.aspx">푸르지오
									웹진</a></li>
						</ul></li>
				</ul>
				<div class="util">
					<a href="https://www.prugio.com/membership/login.aspx">로그인</a> <a
						href="http://www.prugio.com/customer/faq.aspx">고객센터</a> <a
						href="http://www.prugio.com/myprugio/myprugio.aspx">마이 푸르지오</a>
				</div>
			</div>
			<div class="gnb_bg"></div>
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
							<img src="/APTmanager/css/images/common/title_h2.gif" alt="마이푸르지오">
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
						<h2 style="font-size: 30px">
						방문객
							<!-- <img src="/APTmanager/css/images/common/title_h2.gif" alt="브랜드"> -->
						</h2>
						<ul class="depth">
							<li><a href='#' id="a">방문객 등록
									</a></li>
							<!--<li><a href="http://www.prugio.com/brand/valley.aspx">푸르지오 밸리</a></li>-->
							<li><a href='#' id="b">방문객 조회
									</a></li>
							<li><a href='#' id="c">로그아웃
									</a></li>
							
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
							<img src="/APTmanager/css/images/common/title_h2.gif" alt="푸르지오정책">
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
					<div id="sub_title">
						<h3>브랜드 스토리</h3>
						<p>푸르지오는 자연과 함께 건강하고 행복한 생활을 영위할 수 있는 생활문화공간을 의미합니다.</p>
					</div>
					<div class="story_top">
						<!-- <img src="/asset/images/brand/story_top_img.jpg" alt="">
						<h4>사람과 자연이 함께하는 프리미엄 주거 문화 공간을 제공합니다.</h4>
						<p class="txt">
							대우건설은 1994년 최초로 아파트에 환경개념을 도입한 그린홈, 크린아파트라는 주거상품을 탄생시켰습니다.
							2003년에는 친환경 철학을 집약하여 자연과 함께 건강하고 행복한 생활을 영위할 수 있는 생활문화공간인 ‘푸르지오’를
							론칭하고 우리나라를 대표하는 친환경 브랜드로 성장시켰습니다.<br> 푸르지오는 깨끗함, 싱그러움을 표현하는
							“푸르다”라는 순우리말에 대지, 공간을 뜻하는 “GEO”를 결합한 것으로 사람, 자연, 그리고 환경이 하나 된 차원
							높은 생활 문화 공간을 의미합니다.
						</p> -->
					</div>
					<!--
					<div class="story_tab">
						<a href="javascript:void(0);" class="on">푸르지오</a>
						<a href="javascript:void(0);" class="summit_color">푸르지오 써밋</a>
					</div>
					-->
					<div class="story_box on">
						<div class="story_mid">
							<!-- <img src="/asset/images/brand/story_img01.jpg" alt=""> -->
						</div>
						<div class="story_bot">
							<!-- <h4>푸르지오는 고객의 삶 어디에나 함께하고 있습니다.</h4>
							<p class="txt">친환경 웰빙을 구현한 아파트와 주상복합 브랜드 ‘푸르지오’, 도시적 감각의 주거상품
								브랜드 ‘푸르지오 시티’, 그리고 전원형 빌라, 타운하우스 브랜드 ‘푸르지오 하임’을 통해 푸르지오는 고객의 삶
								어디에나 함께하고 있습니다.</p> -->
							<div class="story_design">
								<!-- <h4>대한민국 랜드마크 푸르지오</h4>
								<p class="txt">푸르지오는 대한민국에서 가장 많이 공급된 대표 브랜드 아파트이며 12년간 공급
									실적 1위로서 '살기좋은 아파트' 대통령상 포함 최다 수상, 프리미엄 브랜드 지수 1위 선정, 국내 최초 서울시
									'우수디자인 공동주택' 선정 등 다양한 분야에서 수많은 수상실적으로 인정받고 있습니다.</p>
								<h4>아파트 브랜드 최초 ‘Good Design’ 선정</h4>
								<p class="txt">푸르지오 BI(Brand Identity)가 산업통산자원부가 주최하고
									한국디자인진흥원이 주관하는 국내 최고 권위의 디자인 선정제도인 ‘Good Design’에 선정되었습니다.</p> -->
							</div>
							<div class="story_bi">
								<!-- <h4>푸르지오 BI</h4>
								<img src="/asset/images/brand/story_img02.jpg" alt="">
								<p class="txt">푸르지오 BI의 가장 핵심적인 요소인 브랜드마크는 모든 매체의 중심에 사용될
									것입니다. 따라서 브랜드마크 적용 시 규정과 원칙을 반드시 준수하여 왜곡, 변형 , 오남용 등의 사례가 발생하지
									않도록 합니다.</p>
								<a href="/asset/file/Prugio_bI.zip" target="_blank">푸르지오 BI
									다운로드</a> -->
							</div>
							<div class="story_font">
								<!-- <h4>푸르지오 전용서체</h4>
								<img src="/asset/images/brand/story_img03.jpg" alt="">
								<p class="txt">
									<strong>‘푸르지오체’</strong>는 건설사 최초로 자체 개발한 전용서체로, 푸르지오 BI(Brand
									Identity)의 로고타입을 반영하여 제작되었습니다.<br />브랜드 심볼 ‘푸르지오 트리’가 상징하는
									자연친화적인 느낌을 곡선을 통해 살리는 한편, 브랜드 핵심가치인 ‘사람과 자연이 함께 하는 프리미엄 주거공간’ 을
									세련되고 모던한 형태로 표현하였습니다.
								</p>
								<a href="/asset/file/prugio_font.zip" target="_blank">푸르지오체
									다운받기</a> -->
							</div>
						<!-- 	<div class="story_catalog">
								<a href="/asset/file/prugio_catalog.pdf" target="_blank">카탈로그
									보기</a>
							</div> -->
						</div>
					</div>
					<!--
					<div class="story_box">
						<div class="story_mid">
							<div class="left"><img src="/asset/images/brand/story_summit_img01.jpg" alt=""></div>
							<p class="right">최고급 주거상품으로서<br />세상의 중심과 삶의 정상에서 누릴 수 있는<br />고품격 주거공간</p>
						</div>
						<div class="story_bot">
							<h4>최고급 주거상품 브랜드 PRUGIO SUMMIT</h4>
							<p class="txt">대한민국 대표 주거상품 브랜드 푸르지오와 최고, 절정, 정상을 뜻하는 단어 ‘SUMMIT’이 결합된 푸르지오 써밋은 특별한 삶을 꿈꾸는 고객들에게 지금까지 없던 차별화된 고품격 주거공간을 선사합니다.</p>
						</div>
					</div>
					-->
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

	<ul>
		<li>
		 방문객
		 <ul>
		 	<li> <a href = "createReservationMenu.resident">방문객 등록</a> </li>
		 	<li> <a href = "listReservation.resident">방문객 조회</a> </li>
		 	<li> <a href = "selectMenu.resident">로그아웃</a> </li>
		 </ul>		
		</li>
	</ul>

</body>
</html>

