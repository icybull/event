window.addEventListener('DOMContentLoaded', function () {
    const swiper = new Swiper('.swiper', {
        direction: 'horizontal',
        loop: false,
        infinite: true,
        slidesPerView: 'auto',
        spaceBetween: 12,
        followFinger: true,
        freeMode:true,
        animating: false,
        width: 149,
    })
});


/*$('#section04 .mycomment_button').click(function () {
    $(this).toggleClass('on');
});*/

$(document).ready(function($) {

    $("#scroll_move01").click(function(event){

        event.preventDefault();

        $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);

    });

    $("#scroll_move02").click(function(event){

        event.preventDefault();

        $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);

    });

    $("#scroll_move03").click(function(event){

        event.preventDefault();

        $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);

    });


});



$(".visual_slider").slick({
    dots: false, //navigation
    arrows: false, //arrow
    prevArrow: $('.prev'), //prev
    nextArrow: $('.next'), //next
    autoplay: true, // autoplay mode
    autoplaySpeed: 2000, // auto speed
    pauseOnHover: false, // pause on mouse hover
    fade: false, //fade mode only one slider
    speed: 900, // speed
    infinite: true, // infinite mode
    // asNavFor: '.slider2', // another slider
    centerMode: false, // center move
    centerPadding: '0%', // center move padding
    slidesToShow: 1, // show slider number
    slidesToScroll: 1, // next slider number
    swipe: true, // swiper
    focusOnSelect: true, // click to slider
    draggable: true,
    vertical: false, // vertical slider
    verticalSwiping: false, // vertical swiper
    initialSlide: 0,// slider number
    cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
    variableWidth: false,

});


function BTN_1() {
    $('#page_1').addClass('ov');$('#page_2').removeClass('ov');$('#page_3').removeClass('ov');
    $('.line_1').css('display','');$('.line_2').css('display','none');$('.line_3').css('display','none')
    $('#content_1').css('display','');$('#content_2').css('display','none');$('#content_3').css('display','none');

}


function BTN_2() {
    $('#page_1').removeClass('ov');$('#page_2').addClass('ov');$('#page_3').removeClass('ov');
    $('.line_1').css('display','none');$('.line_2').css('display','');$('.line_3').css('display','none')
    $('#content_1').css('display','none');$('#content_2').css('display','');$('#content_3').css('display','none');

}


function BTN_3() {
    $('#page_1').removeClass('ov');$('#page_2').removeClass('ov');$('#page_3').addClass('ov');
    $('.line_1').css('display','none');$('.line_2').css('display','none');$('.line_3').css('display','');
    $('#content_1').css('display','none');$('#content_2').css('display','none');$('#content_3').css('display','');
}
