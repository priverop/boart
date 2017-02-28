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
});