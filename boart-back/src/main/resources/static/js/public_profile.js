$(function() {
	var pageGlobal = 1;
	
	$('.load_more span').click(function(e){
		
		 e.preventDefault();
		 $('.spinner_overlay').css('display', 'flex');
		 var IDUser = $("#userID").text();
		 
		 var request = $.ajax({
			  url: "/public_profile/pagination",
			  method: "GET",
			  data: {page : pageGlobal, userId : IDUser}
		});
			 
		request.done(function( response ) {
			pageGlobal++;
			$('#publicationWrapper').append(response);
			$('.spinner_overlay').css('display', 'none');
		});
			 
		request.fail(function( jqXHR, textStatus ) {
			$('.spinner_overlay').css('display', 'none');
		});
		 
	});

});