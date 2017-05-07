$(function() {
	$('.edit-icon').click(function(e){
		 e.preventDefault();
		 $(this).find('.edit_profile').prop("disabled", false).focus();
	});
	
	$('.edit_profile').focusin(function(e){
		$('.send_form').prop("disabled", false);
	});
	$("#avatar").click(function(){
	    $("#inputFile").click();
	    $('.send_form').prop("disabled", false);
	});
    $("#inputFile").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#avatar').attr('src', e.target.result);
            }
            reader.readAsDataURL(this.files[0]);
        }
    });
	
});

