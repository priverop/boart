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


var showHide = function(){
	var groupImagen = document.getElementById("groupImagen");
	var groupAudio = document.getElementById("groupAudio");
	var groupVideo = document.getElementById("groupVideo");
	var optionsRadios1 = document.getElementById("optionsRadios1");
	var optionsRadios2 = document.getElementById("optionsRadios2");
	var optionsRadios3 = document.getElementById("optionsRadios3");
	
	groupImagen.style.display = optionsRadios1.checked ? "block" : "none";
	groupAudio.style.display = optionsRadios2.checked ? "block" : "none";
	groupVideo.style.display = optionsRadios3.checked ? "block" : "none";
	
	document.getElementById("inputFile").value="";
	document.getElementById("txtAudio").value="";
	document.getElementById("txtVideo").value="";
	document.getElementById("divRetoques").style.display = "none";
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
		var input = document.getElementById("inputFile");
		var divRetoques = document.getElementById("divRetoques");
		divRetoques.style.display = (input.value == "") ? "none" : "block";
	    readURL(this);
	});
});