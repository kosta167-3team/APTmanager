/**
 * 
 */
    
    
    $(function(){
    	var a= 0;
    	$('#energyTable').find('tr').find('td:eq(3)').each(function(){
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
    });
    