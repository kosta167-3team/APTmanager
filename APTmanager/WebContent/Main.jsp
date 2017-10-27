<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
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
<link href="/APTmanager/css/common/saleList.css" rel="stylesheet">


<link href="/APTmanager/css/main/main.css" rel="stylesheet">

<script src="/APTmanager/js/common/jquery.js"></script>
<script src="/APTmanager/js/main/jquery.jplayer.js"></script>
<script src="/APTmanager/js/common/common.js"></script>
<title>삼성 힐스테이트 1단지</title>
<script>
    $(function(){

        //video
        $("#player").jPlayer({
	        ready: function () {
	            $(this).jPlayer("setMedia", {
	                m4v: "/APTmanager/js/main/movie.mp4"
	            }).jPlayer("play");
	        },
	        swfPath: "/APTmanager/js/main/jquery.jplayer.swf",
	        supplied: "m4v",
	        size: {
	            width: "110%",
	            height: "110%",
	            cssClass: ""
	        },
	        backgroundColor: "#fff",
	        useStateClassSkin: true,
	        autoBlur: false,
	        smoothPlayBar: true,
	        keyEnabled: true,
	        remainingDuration: false,
	        toggleDuration: false,
	        loop: true,
	        autoPlay:true,
	        volume: 0.5,
	        cssSelectorAncestor: "#player_wrap"
	    });
        
        $(".cover_txt a").on("click", function(){
            if($(this).is(".mov_pause")){
                $("#player").jPlayer("pause");
                $(this).removeClass().addClass("mov_play");
            }else{
                $(this).removeClass().addClass("mov_pause");
                $("#player").jPlayer("play");
            }
        });

        var winW = $(window).width();
        if ($(window).width() < 1600) {
            winW = 1600;
            $("#player").css({"width": winW * 1.2, "margin-left": -(winW * 1.2) / 2});
        }

        //bottom cover button, video width & position control
        $(window).resize(function () {
            var winH = $(window).height();
            winW = $(window).width();
            $(".intro_cover").css("height", winH);
            if ($(window).width() > 1600) {
                $("#player").css({"width": winW * 1.2, "margin-left": -(winW * 1.2) / 2});
            }
        }).trigger("resize");

        //bottom cover button
        $(".cover_btn").delay(500).animate({ "bottom": "0"}, 300);
        $(".cover_btn a").hover(function () {
            $(this).stop().animate({"top": -10, "margin": "0 141px"}, 200);
        }, function () {
            $(this).stop().animate({"top": 0, "margin": "0 141px"}, 200);
        });

        //GNB transform
        var scrollPos = $(window).scrollTop();
        $("#header h1").find("img").attr("src", "/APTmanager/css/images/main/main_logo(2).png")
        $(window).scroll(function () {
            scrollPos = $(window).scrollTop();
            if (scrollPos > $(".intro_cover").height() - 60) {
                $("#header").css({ "position": "fixed" }).parent().removeClass("main_gnb");
                $("#header h1").find("img").attr("src", "/APTmanager/css/images/common/logo.png");
            } else if (scrollPos < $(".intro_cover").height()) {
                $("#header").css({ "position": "absolute" }).parent().addClass("main_gnb");
                $("#header h1").find("img").attr("src", "/APTmanager/css/images/main/main_logo(2).png");
            }
        });
    });
</script>
</head>
<body>
<form name="main" method="post" action="main.aspx" id="main">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTMyODI5NDg5MWRk33N2mx0ngfjn6+o+aKYeh4SFOG0=" />
</div>

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['main'];
if (!theForm) {
    theForm = document.main;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<div>

	<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="202EA31B" />
</div>
	<div id="wrap">
		<!-- header -->
		<div class="main_gnb">

<div id="header">
	<div class="inner">
		<h1><a href="http://www.prugio.com/main.aspx"><img src="/APTmanager/css/images/common/logo.png" alt="PRUGIO"></a></h1>
		<ul id="gnb" class="gnb">
			<li class="menu1">
				<a href="http://www.prugio.com/sale/sale.aspx">분양안내</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/sale/sale.aspx?menu=0">신규분양</a></li>
					<li><a href="http://www.prugio.com/sale/sale.aspx?menu=1">추천분양</a></li>
					<li><a href="http://www.prugio.com/sale/sale.aspx?menu=2">상가분양</a></li>
					<li><a href="http://www.prugio.com/sale/plan.aspx">분양계획 한눈에 보기</a></li>
					<li><a href="http://www.prugio.com/sale/map.aspx">지도로 보기</a></li>
				</ul>
			</li>
			<li class="menu2">
				<a href="http://www.prugio.com/construction/construction.aspx">현장안내</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/construction/construction.aspx">공사진행단지</a></li>
					<li><a href="http://www.prugio.com/construction/construction.aspx?menu=Y">입주진행단지</a></li>
				</ul>
			</li>
			<li class="menu3">
				<a href="http://www.prugio.com/brand/brand.aspx">브랜드</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/brand/story.aspx">브랜드 스토리</a></li>
					<!--<li><a href="http://www.prugio.com/brand/valley.aspx">푸르지오 밸리</a></li>-->
					<li><a href="http://www.prugio.com/brand/news.aspx">푸르지오 소식</a></li>
					<li><a href="http://www.prugio.com/brand/pr-video.aspx">브랜드 PR</a></li>
					<li><a href="http://www.prugio.com/brand/award.aspx">수상경력</a></li>
					<li><a href="http://www.prugio.com/brand/record.aspx">시공실적</a></li>
					<li class="wide"><a href="http://www.prugio.com/brand/redevelop.aspx">재개발/재건축/<br>리모델링</a></li>
				</ul>
			</li>
			<li class="menu4">
				<a href="http://www.prugio.com/cast/cast.aspx">캐스트</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/cast/cast.aspx">전체보기</a></li>
					<li><a href="http://www.prugio.com/cast/news.aspx">소식&amp;이벤트</a></li>
					<li><a href="http://www.prugio.com/cast/complex.aspx">단지별 캐스트</a></li>
				</ul>
			</li>
			<li class="menu5">
				<a href="http://www.prugio.com/product/product.aspx">상품안내</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/product/premium-green.aspx">프리미엄 상품</a></li>
					<li><a href="http://www.prugio.com/product/merits-01.aspx">특화아이템</a></li>
					<li><a href="http://www.prugio.com/product/gallery.aspx">단지 갤러리</a></li>
				</ul>
			</li>
			<li class="menu6">
				<a href="http://www.prugio.com/life/life.aspx">라이프</a>
				<ul class="gnb_list">
					<li><a href="http://www.prugio.com/life/life.aspx">푸르지오 웹진</a></li>
				</ul>
			</li>
		</ul>
		<div class="util">
            
			<a href="https://www.prugio.com/membership/login.aspx">로그인</a>
            
			<a href="http://www.prugio.com/customer/faq.aspx">고객센터</a>
			<a href="http://www.prugio.com/myprugio/myprugio.aspx">마이푸르지오</a>
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
						<a href="./brand/pr-video.aspx" class="num02">홍보영상 보기</a>
						<a href="./cast/news.aspx" class="num03">이벤트 보기</a>
						<!--<a href="./brand/valley.aspx" class="num04">푸르지오밸리 보기</a>-->
					</div>
				</div>
			</div>
			<div class="contents">
				<div class="cont02">
					<div class="sale_box">
						
                                <ul class='sale_list item'>
                                    <li >                             

                                        <a href='http://www.prugio.com/house/2017/dongtanlake/index.aspx' target='_blank'>
								            
                                        
								            <div class='thumb'><img src='/PrugioBoard/Project/843/thumb (0).jpg' alt=''></div>
								            <dl>
									            <dt>동탄 레이크 자연& 푸르지오</dt>
									            <dd class="location">* 위치 : 동탄2신도시 택지개발지구 내 A86BL<br>
* 총 704세대 </dd>
									            <dd class="tel">1599-5853     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                            
                                
                                    <li >
                                        

                                        <a href='http://www.prugio.com/house/2017/gasancentral/index.aspx' target='_blank'>
								            
                                        
								            <div class='thumb'><img src='/PrugioBoard/Project/845/thumb.jpg' alt=''></div>
								            <dl>
									            <dt>가산 센트럴 푸르지오 시티                                   </dt>
									            <dd class="location">* 위치 : 서울시 금천구 가산동 233-5<br>
* 총 1,454실</dd>
									            <dd class="tel">1877-9970     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                            
                                
                                    <li >
                                        

                                        <a href='http://www.prugio.com/house/2017/uiwang_jangan2/index.aspx' target='_blank'>
								            
                                        
								            <div class='thumb'><img src='/PrugioBoard/Project/827/thum_default.jpg' alt=''></div>
								            <dl>
									            <dt>의왕 장안지구 파크 2차 푸르지오 </dt>
									            <dd class="location">* 위치 : 경기도 의왕시 삼동 74-2, 253<br>
* 총 610세대</dd>
									            <dd class="tel">1800-3800     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                            
                                
                                    <li >
                                        

                                        
								            
                                        
								            <div class='thumb'><img src='/PrugioBoard/Project/840/thum_default.jpg' alt=''></div>
								            <dl>
									            <dt>과천 지식정보타운(가칭)                                     </dt>
									            <dd class="location">* 위치 : 경기도 과천시 지식정보타운<br>
* 총 1,263세대 중 S4 679세대, S5 584세대</dd>
									            <dd class="tel">1670-1000     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                </ul>
                            
                                <ul class='sale_list item'>
                                    <li >
								            <div class='thumb'><img src='/PrugioBoard/Project/819/thum_default (0).jpg' alt=''></div>
								            <dl>
									            <dt>수원 영흥공원(가칭)                                         </dt>
									            <dd class="location">* 위치 : 경기도 수원시 영통구 영통동 2<br>* 총 1,999세대</dd>
									            <dd class="tel">1670-1000     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                                    <li >
								            a<div class='thumb'><img src='/PrugioBoard/Project/821/thum_default (0).jpg' alt=''></div>
								            <dl>
									            <dt>창원 교방(가칭)                                             </dt>
									            <dd class="location">* 위치 : 창원시 마산합포구 교방동 75<br>
* 총 1,538세대</dd>
									            <dd class="tel">1670-1000     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                            
                                
                                    <li >
                                        

                                        
								            
                                        
								            <div class='thumb'><img src='/PrugioBoard/Project/837/thum_default.jpg' alt=''></div>
								            <dl>
									            <dt>청주 새적굴공원(가칭)                                       </dt>
									            <dd class="location">* 위치 : 청주시 청원구 내덕동 산59-2<br>
* 총 777세대 </dd>
									            <dd class="tel">1670-1000     </dd>
								            </dl>
								            <span class="flag type1">예정</span>
							            </a>
                                        
                                        
                                    </li>
                                
                            
					</div>
				</div>
				<div class="cont03">
					<div class="banner">
						<dl>
							<dt>푸르지오<br>갤러리</dt>
							<dd>Life, Inspiration<br>
							푸르지오의 다양한 모습을<br>
							감상하세요.</dd>
							<a href="./product/gallery.aspx" class="banner_btn">바로가기</a>
						</dl>
						<div>
							<img src="/APTmanager/css/images/main/main_banner01.jpg" alt="">
						</div>
					</div>
					<div class="banner">
						<dl>
							<dt>푸르지오<br>라이프</dt>
							<dd>프리미엄 라이프 스타일 매거진<br>푸르지오 웹진을 만나보세요.</dd>
							<a href="./life/life.aspx" class="banner_btn">바로가기</a>
						</dl>
						<div>
							<img src="/APTmanager/css/images/main/main_banner02.jpg" alt="">
						</div>
					</div>
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
				법인명 : (주)대우건설 서울특별시 종로구 새문안로 75(신문로 1가) 사업자 등록번호 : 104-81-58180<br> Copyright www.prugio.com All rights reserved.
			</address>
		</div>
		<span class="icsi_logo"><img src="/APTmanager/css/images/common/logo_01.png" alt="" /></span>
		<span class="icsi_logo"><img src="/APTmanager/css/images/common/logo_02.png" alt="" /></span>
		<div class="right_cont">
			<p class="customer_tel">고객센터 1670-1000</p>
			<a href="http://www.daewooenc.com/" target="_blank" class="dwlogo"><img src="/APTmanager/css/images/common/footer_logo_daewooenc.png" alt="(주)대우건설"></a>
		</div>
	</div>
</div>

		<!-- //footer -->
	</div>
	<!-- //wrap -->
</form>
</body>
</html>
