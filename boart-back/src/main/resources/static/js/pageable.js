$(function() {
	var pageGlobal = 0;
	
	$('.load_more span').click(function(e){
		 e.preventDefault();
		 
		 $('.spinner_overlay').css('display', 'flex');
		 
		 var request = $.ajax({
			  url: "http://localhost:8400/page",
			  method: "GET",
			  data: {page : pageGlobal + 1}
		});
			 
		request.done(function( response ) {
			$('#columns').append(response);
			$('.spinner_overlay').css('display', 'none');
		});
			 
		request.fail(function( jqXHR, textStatus ) {
			$('.spinner_overlay').css('display', 'none');
		});
		 
	});

});