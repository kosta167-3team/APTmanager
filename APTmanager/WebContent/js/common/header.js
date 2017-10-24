/**
 * 
 */

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
});