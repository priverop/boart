var checkLikes = function(){
	
	var $ratingValueSpan = $('.rating-value');
	
	$ratingValueSpan.each(function(index, element){
		var $element = $(element);
		var $likeIcon = $element.siblings('.like_icon');
		var ratingValue = parseInt($element.text());
		
		if(ratingValue > 0){
			$likeIcon.addClass('added');
		}
	});
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

var modalSign = function(){
	
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
		console.log($boxSignIn)
		$boxSignIn.show();
	});
	
	var $boxSignForms = $('.box_sign').find('form');
	
	$boxSignForms.submit(function(){
		
	});
	
};


$(function() {
	modalSign();
	likeManager();
	checkLikes();
});