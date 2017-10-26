/**
 * 
 */

$(function(){
	var a= 0;
	$('#billTable').find('tr').find('td:eq(2)').each(function(){
		if(  parseInt($(this).html()) > 0 && a > 0){
			$(this).css({
				"color" : "red"
			});
		}
		else if( parseInt($(this).html()) < 0 && a > 0)
			$(this).css({
				"color":"blue"
			});
		a++;
		
	});
	
	$(document).ready(function(){
		var top = $('.lnb_list').offset().top - parseFloat($('.lnb_list').css('marginTop').replace(/auto/,0) );
		$(window).scroll(function(event){
			var y = $(this).scrollTop();
			
			if(y >= top){
				$('.lnb_list').addClass('fixed');
			}
			else{
				$('.lnb_list').removeClass('fixed');
			}
		});
	});
	
});


