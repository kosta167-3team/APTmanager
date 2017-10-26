/**
 * 
 */

	$(function() {
		
		
		
		
		$("#gnb > li > a").mouseover(function(){
			$(this).css({
				"color" : "green"
			});
		});
		$("#gnb > li > a").mouseout(function(){
			$(this).css({
				"color" : "black"
			});
		});
		//video
		$("#player").jPlayer({
			ready : function() {
				$(this).jPlayer("setMedia", {
					m4v : "/APTmanager/js/main/movie.mp4"
				}).jPlayer("play");
			},
			swfPath : "/APTmanager/js/main/jquery.jplayer.swf",
			supplied : "m4v",
			size : {
				width : "110%",
				height : "110%",
				cssClass : ""
			},
			backgroundColor : "#fff",
			useStateClassSkin : true,
			autoBlur : false,
			smoothPlayBar : true,
			keyEnabled : true,
			remainingDuration : false,
			toggleDuration : false,
			loop : true,
			autoPlay : true,
			volume : 0.5,
			cssSelectorAncestor : "#player_wrap"
		});

		$(".cover_txt a").on("click", function() {
			if ($(this).is(".mov_pause")) {
				$("#player").jPlayer("pause");
				$(this).removeClass().addClass("mov_play");
			} else {
				$(this).removeClass().addClass("mov_pause");
				$("#player").jPlayer("play");
			}
		});

		var winW = $(window).width();
		if ($(window).width() < 1600) {
			winW = 1600;
			$("#player").css({
				"width" : winW * 1.2,
				"margin-left" : -(winW * 1.2) / 2
			});
		}

		//bottom cover button, video width & position control
		$(window).resize(function() {
			var winH = $(window).height();
			winW = $(window).width();
			$(".intro_cover").css("height", winH);
			if ($(window).width() > 1600) {
				$("#player").css({
					"width" : winW * 1.2,
					"margin-left" : -(winW * 1.2) / 2
				});
			}
		}).trigger("resize");

		//bottom cover button
		$(".cover_btn").delay(500).animate({
			"bottom" : "0"
		}, 300);
		$(".cover_btn a").hover(function() {
			$(this).stop().animate({
				"top" : -10,
				"margin" : "0 141px"
			}, 200);
		}, function() {
			$(this).stop().animate({
				"top" : 0,
				"margin" : "0 141px"
			}, 200);
		});

		//GNB transform
		var scrollPos = $(window).scrollTop();
		$("#header h1").find("img").attr("src",
				"/APTmanager/css/images/main/main_logo(2).png")
		$(window).scroll(function() {
							scrollPos = $(window).scrollTop();
							if (scrollPos > $(".intro_cover").height() - 60) {
								$("#header").css({
									"position" : "fixed"
								}).parent().removeClass("main_gnb");
								$("#header h1").find("img").attr("src","/APTmanager/css/images/common/logo.png");
								$("#gnb > li > a").css({
									"color" : "white"
								});
								$("#util_id").css({
									"margin-right" : "150px",
									"right" : "5%"
								});
							} else if (scrollPos < $(".intro_cover").height()) {
								$("#header").css({
									"position" : "absolute"
								}).parent().addClass("main_gnb");
								$("#gnb > li > a").css({
									"color" : "black"
								});
								$("#util_id").css({
									"margin-right" : "100px",
									"right" : "0%"
								});
								$("#header h1").find("img").attr("src","/APTmanager/css/images/main/main_logo(2).png");
							}
						});
		
		
	});
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
	function login() {              
        //window.open("./resident/loginForm.jsp", "loginPopup", "width=700, height=250, left=200, top=200");
         location.href="./resident/loginForm.jsp";            
	}
	function visit() {
        location.href="createReservationMenu.resident";
     }
	
	
	
	