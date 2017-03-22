var activeFilter = function(filter){
	if (filter == 'likes'){
		document.getElementById('aLikes').className ='active';
	} else if (filter == 'comments'){
		document.getElementById('aComments').className ='active';
	} else {
		document.getElementById('aLatest').className ='active';
	}

};

var likeManager = function(){
	
	var publicationId;
	
	$('.rating a').click(function(){
		
		var $this = $(this);
		publicationId = $this.attr('publication');
		
		var request = $.ajax({
			  url: "like",
			  method: "POST",
			  data: 'publicationId=' + publicationId
		});
			 
		request.done(function( response ) {
			
			var $likeIcon = $this.find('.like_icon');
			var $ratingValueSpan = $this.find('.rating-value');
			var ratingValue = parseInt($ratingValueSpan.text());
			
			if (response == "added") {
				ratingValue = ratingValue + 1;
				$ratingValueSpan.text(ratingValue);
				$likeIcon.addClass('added');
			}
			
			if (response == "deleted") {
				ratingValue = ratingValue - 1;
				$ratingValueSpan.text(ratingValue);
				$likeIcon.removeClass('added');
			}
		});
			 
		request.fail(function( jqXHR, textStatus ) {
			console.log("Fail")
		});
	});
};

var modalSign = function(e){
	
	var $singUpButton = $('#sing_up');
	var $singInButton = $('#sing_in');
	
	var $boxSignIn = $('.box_signin');
	var $boxSignUp = $('.box_signup')
	
	var overlay = function(show){
		var $overlay = $('.box_sign').closest('.overlay');
		if(show){
			$overlay.css('display', 'flex');
		}else{
			$overlay.hide();
		}
	}
	
	$singUpButton.click(function(){
		overlay(true);
		$boxSignIn.hide();
		$boxSignUp.show();
	});
	
	$singInButton.click(function(){
		overlay(true);
		$boxSignUp.hide();
		$boxSignIn.show();
	});
	
	$(".overlay").click(function() {
		overlay(false);
		$boxSignUp.hide();
		$boxSignIn.hide();
	});

	$(".app_box").click(function(event){
		event.stopPropagation();
	});
	
	var $boxSignForms = $('.box_sign').find('form');
	
	$boxSignForms.submit(function(){
		
	});
	
	
};

var checkMyLike = function(idPublication){
	var request = $.ajax({
		  url: "http://localhost:8400/checkLike",
		  method: "GET",
		  data: {id: idPublication}
	}).done(function( response ) {
		
		if (response == "true") {
			$("#"+idPublication).addClass('added');
		}
	});
}


$(function() {
	modalSign();
	likeManager();
});