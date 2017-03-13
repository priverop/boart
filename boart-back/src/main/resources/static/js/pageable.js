$(function() {
	
	$('.load_more span').click(function(e){
		 e.preventDefault();
		 
		 $('.spinner_overlay').css('display', 'flex');
		 
		 var request = $.ajax({
			  url: "pageable",
			  method: "POST",
			  data: "lastIndex=" + 10
		});
			 
		request.done(function( response ) {
			$('.spinner_overlay').css('display', 'none');
		});
			 
		request.fail(function( jqXHR, textStatus ) {
			$('.spinner_overlay').css('display', 'none');
		});
		 
	});

});