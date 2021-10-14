$(document).ready(function(){
    var visible = false;

var sliderCount = $('#slider div.slides div.slide').length;

var sliderWidth = $('#slider div.slides div.slide').width();
var sliderHeight = $('#slider div.slides div.slide').height();

$('#slider').css({width: sliderWidth, height: sliderHeight});

 $('#slider div.slides').css({width: sliderCount*sliderWidth, marginLeft: -sliderWidth});



$('#laquo').click(function(){
    $('#slider div.slides').animate({left: +sliderWidth}, 1000, function(){
        $('#slider div.slides div.slide:last-child').prependTo('#slider div.slides');
        $('#slider div.slides').css('left','');
    });
    
});

$('#raquo').click(function(){
    $('#slider div.slides').animate({right: +sliderWidth}, 1000, function(){
        $('#slider div.slides div.slide:first-child').appendTo('#slider div.slides');
        $('#slider div.slides').css('right','');
    });
    
});
})