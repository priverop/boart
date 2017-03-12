$(function() {
	$('.edit-icon').click(function(e){
		 e.preventDefault();
		 $(this).find('.edit_profile').prop("disabled", false).focus();
	});
	
	$('.edit_profile').focusin(function(e){
		$('.send_form').prop("disabled", false);
	});
});