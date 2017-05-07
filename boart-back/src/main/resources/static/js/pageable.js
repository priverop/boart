$(function() {
	var pageGlobal = 1;
	var csrf_token = $('meta[name="csrf-token"]').attr('content');
	var filter = $('meta[name="filter"]').attr('content');
	var tags = $('meta[name="tags"]').attr('content');

	
	$('.load_more span').click(function(e){
		 e.preventDefault();
		 
		 $('.spinner_overlay').css('display', 'flex');
		 
		 var request = $.ajax({
			  url: "http://localhost:8400/",
			  method: "POST",
			  data: {page : pageGlobal, type : 'pagination', _csrf: csrf_token, filter : filter, tags : tags}
		});
			 
		request.done(function( response ) {
			$('#columns').append(response);
			$('.spinner_overlay').css('display', 'none');
			pageGlobal++;
		});
			 
		request.fail(function( jqXHR, textStatus ) {
			$('.spinner_overlay').css('display', 'none');
		});
		 
	});

});
