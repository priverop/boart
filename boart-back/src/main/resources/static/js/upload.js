var filters = {};

var readURL = function(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#image').show().attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
};

var setFilter = function(filter, value) {
	filters[filter] = value;
	editImage();
};

var editImage = function() {
		
	var concatValue = "";
	
	for (var filter in filters) {
	    var value = filters[filter];
	    concatValue = concatValue + ' ' + filter + '(' + value + ')';
	}
		
	$('#image').css('filter', concatValue);
	
	console.log($('#image').attr('src'));
};

var setValue = function(name, value) {
	
	switch(name) {
	    case 'blur':
	        value = value + 'px';
	        break;
	    case 'hue-rotate':
	    	value = value + 'deg';
	        break;
	    case 'opacity':
	    	value = value + '%';
	    	break;
	    default:
	        value;
	}
	
	return value;
}

$(function() {
	
	$('input[type=range]').each(function( index ) {
		
		var $this = $(this);
		var value = $this.val();
		var $valueSpan = $this.siblings('.input-group-btn').find('.filter_value');
		
		$valueSpan.text(value);
	});
	
	$(document).on('input', 'input[type=range]', function() {
		
		var $this = $(this);
		var value = $this.val();
		var name = $this.attr('name');
		var $valueSpan = $this.siblings('.input-group-btn').find('.filter_value');
		
		$valueSpan.text(value);
		
		value = setValue(name, value);
				
		setFilter(name, value);
		
	});
	
	$("#inputFile").change(function(){
	    readURL(this);
	});
});