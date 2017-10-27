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
<link href="/APTmanager/css/bill/billMonth.css" rel="stylesheet">

<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/common/common.js"></script>
<script src="/APTmanager/js/common/jquery.blockUI.js"></script>
<script src="/APTmanager/js/bill/monthBill.js"></script>

<!-- google chart js -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<title>브랜드 스토리 | 브랜드 | 푸르지오</title>
<script>
	lnbName = "brand_lnb";
	lnbBrand = 1;
</script>
</head>
<body>
	<script type="text/javascript">
	function visit() {
        location.href="createReservationMenu.resident";
     }
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
					<h3> ${Personal_mgmt_ex.p_month }월 관리비 내역 </h3>
					<p> 전달의 관리비와 비교합니다.</p>
				</div>										
					<table id = "billTable">
						<tr id = "trHead">
							<td class = "billIndex"> 항목</td>
							<td class = "billIndex"> 당월</td>
							<td class = "billIndex"> 지난달 비교</td>
						</tr>
						<tr>
							<td>일반 관리비</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.general_mgmt }" pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.general_mgmt }"
									pattern="###,###,###" /></td>


						</tr>
						<tr>
							<td>청소비</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.clean }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.clean }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>소독비</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.fumigate }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.fumigate }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>승강기유지비</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.elevator_maintain }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.elevator_maintain }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>수선유지비</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.repair }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.repair }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>장기수선충당금</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.long_term_repair }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.long_term_repair }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>건물보험료</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.building_insurance }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.building_insurance }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>경비비</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.security}"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.security }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>위탁관리수수료</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.consignment }" pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.consignment }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>세대전기료</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.personal_elec }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.personal_elec}"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>공동전기료</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.public_elec}" pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.public_elec }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>TV수신료</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.tv}"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.tv }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>세대수도료</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.personal_water }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.personal_water }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>세대급탕비</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.personal_heat_water }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber
									value="${compare.personal_heat_water }" pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>생활폐기물 수거</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.trash_pick_up  }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.trash_pick_up }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>입대위 운영비</td>

							<td><fmt:formatNumber
									value="${Personal_mgmt_ex.resident_repre }"
									pattern="###,###,###" /></td>
							<td><fmt:formatNumber value="${compare.resident_repre }"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>선관위 운영비</td>

							<td><fmt:formatNumber value="${Personal_mgmt_ex.emc }"
									pattern="###,###,###원" /></td>
							<td><fmt:formatNumber value="${compare.emc}"
									pattern="###,###,###" /></td>

						</tr>
						<tr>
							<td>미납여부</td>

							<td>${Personal_mgmt_ex.pay_check }</td>
							<td>${compare.pay_check}
						</tr>
					</table>
					<!-- 첫번 째 페이지  -->					
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

