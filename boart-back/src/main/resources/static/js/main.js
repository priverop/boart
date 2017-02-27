var modalSign = function(){
	
	var $singUpButton = $('#sing_up');
	var $singInButton = $('#sing_in');
	
	var overlay = function(show){
		var $overlay = $('.box_sign').closest('.overlay');
		if(show){
			$overlay.show();
		}else{
			$overlay.hide();
		}
	}
	
	$singUpButton.click(function(){
		overlay(true);
	});
	
	$singInButton.click(function(){
		overlay(true);
	});
	
	var $boxSignForms = $('.box_sign').find('form');
	
	$boxSignForms.submit(function(){
		
	});
	
};


$(function() {
	modalSign();
});