var lnbName;
var lnbCustomer;
var lnbMyprugio;
var trident = !!navigator.userAgent.match(/Trident\/7.0/);
var net = !!navigator.userAgent.match(/.NET4.0E/);
var IE11 = trident && net
var IEold = ( navigator.userAgent.match(/MSIE/i) ? true : false );

$(function(){
	//gnb
	$("#gnb").mouseenter(function(){
		$(".gnb_bg").stop().animate({"height": 270}).css({"box-shadow" : "0 2px 5px 0 #bbb"});
		$(".gnb_list").stop().animate({"height": 270});
	});
	$("#gnb").mouseleave(function(){
		$(".gnb_list").stop().animate({"height": 0});
		$(".gnb_bg").stop().animate({"height": 0}).css({"box-shadow" : 0});
	});
	/* $("#top_banner").find("a").animate({"opacity" : 0},0);
	$("#btn_banner_close").click(function(){
		$("#top_banner").stop().animate({"height" : 0});
		$(".top_inner").stop().animate({"top" : -100});
		$(".gnb_bg").stop().animate({"top": 61});
		$("#map_contents").stop().animate({"top" : "200px"});
	}); */
	//ajax focus animation
	$(".btn_more a").on("click", function(){
		$("html, body").stop().animate({scrollTop : $(this).offset().top}, 700);
	});
	
	//sale list hover effect
	if(IE11 || IEold){
		$(".sale_list").find(".feature").addClass("ie_hover");
	}
	$(".sale_list").find(".feature").hover(function(){
		if(IE11 || IEold) {
			$(this).find(".back").stop().animate({"top" : 0});
		}else{
			$(this).addClass("hover");
		}
	},function(){
		if(IE11 || IEold) {
			$(this).find(".back").stop().animate({"top" : "100%"});
		}else{
			$(this).removeClass("hover");
		}
	});
	
	$(".top_menu a").on("click", function(){
		$(this).parent("li").addClass("on").siblings().removeClass("on");
	});
	
});

(function($){
	$.fn.extend({
		gridLayout : function(opt){
			var defaults = {
				item : ".item", // string selecter
				hmargin : 10, // number 
				vmargin : 10, // number
				scrollInit : false,
				callback : function(){ // function
				}
			};
			return this.each(function(){
				this.extend = $.extend(defaults, opt);
				this.wrap = $(this);
				this.item;
				this.itemLength;
				this.itemArray = [];
				this.obj = {
					lineCnt : 0,
					rowCnt : 0,
					colCnt : 0,
					sellIndex : 0,
					leftP : 0,
					topP : 0,
					objCnt : 0
				};
				this.init = function(){
					this.item = this.wrap.find(this.extend.item);
					this.itemLength = this.item.length;
					for(var key in this.obj){
						this.obj[key] = 0;
					};
					for(var i = 0; i < this.itemLength; i++){
						this.obj.topP = 0
						this.obj.leftP += this.item.eq(i-1).width() + this.extend.hmargin;
						if(i == 0){
							this.obj.leftP = 0;
						}else if(this.obj.leftP + this.item.eq(i).width() > this.wrap.width()){
							this.obj.leftP = 0;
							if(this.obj.rowCnt > this.obj.colCnt) this.obj.colCnt = this.obj.rowCnt;
							this.obj.rowCnt = 0;
							if(this.obj.leftP == 0) this.obj.lineCnt++;
						};
						this.itemArray[i] = this.item.eq(i).height();
						for(var n = this.obj.lineCnt ; n > 0; n--){
							this.obj.objCnt = this.obj.sellIndex - (this.obj.colCnt * n );
							if(this.obj.objCnt < 0) this.obj.objCnt = 0;
							this.obj.topP +=  this.itemArray[this.obj.objCnt] + this.extend.vmargin;
						};
						this.item.eq(i).stop().css({"left":this.obj.leftP,"top":this.obj.topP});
						this.obj.rowCnt++;
						this.obj.sellIndex++;
					};
					var heightCalc = 0;
					this.item.each(function(){
						var top = $(this).position().top + $(this).outerHeight();
						if(top > heightCalc) heightCalc = top;
					});
					this.wrap.css({"height": heightCalc });
					return this.extend.callback();
				};
				this.init();
				this.extend.scrollInit && $(window).scroll(function(){
					if($(this).scrollTop() == $(document).height() - $(this).height()){
						addObj();
					};
				});
			});
		},
		gridReset : function(opt){
			this[0].init();
		}
	});
})(jQuery);


/*#################################################################################################
+ gfnIsNull()
- Arguments  : sStr1, sStr2
- Return     : String
- Usage      :
- Content    : ���ڷ� �Ѱܿ� sStr1�� null �̸� sStr2, null �� �ƴϸ� sStr1 ����
#################################################################################################*/
 function gfnIsNull(sStr1, sStr2){
     try{
         if (sStr2 == null) sStr2 = "";
         return ((sStr1==null || sStr1=="undefined" || typeof(sStr1) == "undefined") ? sStr2:sStr1);
     }catch(e){
         alert(e);
     }
}

/*#################################################################################################
 + gfnLeft(sString, iLength, sDim)
 - Arguments  : sString, iLength, sDim (����ǥ�ù���)
 - Return     :
 - Usage      :
 - Content    : ���ڿ� �ڸ��� (iLength : ���ڼ�)
#################################################################################################*/
  function gfnLeft(sString, iLength, sDim){
      try{
          if(sString == null || sString == ""){
              return ("");
          }
          return sString.substr(0, iLength) + ((sDim == null || sDim == "")? "": (sString.length > iLength? sDim: ""));
      }catch(e){
            alert(e);
      }
  }
/*#################################################################################################
  + encodeURL()
  - Arguments  : sGbn
  - Return     : String
  - Usage      :
  - Content    : ���ڵ�
#################################################################################################*/
   function encodeURL(str){
       var s0, i, s, u;
       s0 = "";                // encoded str
       for (i = 0; i < str.length; i++){   // scan the source
           s = str.charAt(i);
           u = str.charCodeAt(i);          // get unicode of the char
           if (s == " "){s0 += "+";}       // SP should be converted to "+"
           else {
               if ( u == 0x2a || u == 0x2d || u == 0x2e || u == 0x5f || ((u >= 0x30) && (u <= 0x39)) || ((u >= 0x41) && (u <= 0x5a)) || ((u >= 0x61) && (u <= 0x7a))){       // check for escape
                   s0 = s0 + s;            // don't escape
               }
               else {                  // escape
                   if ((u >= 0x0) && (u <= 0x7f)){     // single byte format
                       s = "0"+u.toString(16);
                       s0 += "%"+ s.substr(s.length-2);
                   }
                   else if (u > 0x1fffff){     // quaternary byte format (extended)
                       s0 += "%" + (0xf0 + ((u & 0x1c0000) >> 18)).toString(16);
                       s0 += "%" + (0x80 + ((u & 0x3f000) >> 12)).toString(16);
                       s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
                       s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
                   }
                   else if (u > 0x7ff){        // triple byte format
                       s0 += "%" + (0xe0 + ((u & 0xf000) >> 12)).toString(16);
                       s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
                       s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
                   }
                   else {                      // double byte format
                       s0 += "%" + (0xc0 + ((u & 0x7c0) >> 6)).toString(16);
                       s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
                   }
               }
           }
       } 
       return s0;
   }
   
/*#################################################################################################
  + gfnSNSFeed()
  - Arguments  : sGbn, sTitle, sUrl
  - Return     : String
  - Usage      :
  - Content    : SNS�� �� �ø���
#################################################################################################*/
   function gfnSNSFeed(sGbn, sTitle, sUrl) {
       switch (sGbn) {
           case "fb" :
               SendFaceBook(sTitle, sUrl);
               break ;
           case "tw" :
               SendTwitter(sTitle, sUrl);
               break ;
           case "me" :
               SendmMe2Day(sTitle, sUrl);
               break ;
       }
   }


/*#################################################################################################
  + SendFaceBook()
  - Arguments  : sTitle, sUrl
  - Return     : 
  - Usage      :
  - Content    : ���̽��� (�׽�Ʈ�������� ����, �Ǽ������� ������: �������� �κ����� ����)
#################################################################################################*/

/*
    2016.03.16 �ݼ��� �ܺ� URL ���� ���� ���ʿ��� ���� ����. 

	window.fbAsyncInit = function() {
		FB.init({
			appId  : "341466285920575",
			status : true,
			cookie : true
		});
	};
	  
	(function() { 
		$("body").append("<div id='fb-root'></div>");
		var e = document.createElement('script'); 
		e.src = document.location.protocol + '//connect.facebook.net/ko_KR/all.js'; 
		e.async = true; 
		document.getElementById('fb-root').appendChild(e); 
	}()); 

   function SendFaceBook(sTitle, sUrl) {
       var obj = {
           method: 'feed',                                                        
           link: sUrl,                                        
//           picture: sUrl,        
           name: sTitle,                                        
           caption: 'http://www.prugio.com',                                        
           description: sTitle
       };
       FB.ui(obj, callback);
   }

   function callback(response) {
//         alert("Post ID: " + response['post_id']);
   }
*/
/*#################################################################################################
  + SendTwitter()
  - Arguments  : sTitle, sUrl
  - Return     : 
  - Usage      :
  - Content    : Ʈ����
#################################################################################################*/
   function OpentwitterBook(url) {
       var winObj;
       winObj = window.open(url, "twitterBookWindow", "width=500, height=400, scrollbars=yes");
   }

   function SendTwitter(sTitle, sUrl) {
       var url;
       var title = encodeURL(sTitle) ;
//       var eUrl = 'http://www.prugio.com' ;
       var eUrl = sUrl ;
       var thisUrl = encodeURL(eUrl);

       url = "http://twitter.com/intent/tweet?text=" + title + "&url=" + thisUrl ;

       OpentwitterBook(url) ;
   }