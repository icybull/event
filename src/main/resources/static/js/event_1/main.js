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
      width: 141,
   })
});









































    /* scroll event section */
    // container.addListener((e) => {

    //     let scrollTop = container.scrollTop;
    //     $('.posNum').html(scrollTop)
    //
    //
    //
    //
    //
    //
    //
    //     if(scrollTop >= 100){
    //         $('#menu').removeClass('on');
    //     }
    //
    //     if(scrollTop >= 496){
    //         $('#section02').addClass('on');
    //     }
    //
    //
    //
    //     if(scrollTop >= 2125){
    //         $('#section03').addClass('on');
    //     }
    //
    //
    //     if(scrollTop >= 3226){
    //         $('#section04').addClass('on');
    //     }
    //
    //     if(scrollTop >= 5829){
    //         $('#section06').addClass('on');
    //     }
    //
    //     if(scrollTop >= 7559){
    //         $('#section07').addClass('on');
    //     }
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // });



    /*  slide,click event section */


    // $('#section01 .left_box .box').click(function () {
    //
    //     $(this).toggleClass('on');
    //
    // });
    //
    // $('#section01 .cover .nav_box .button').click(function () {
    //
    //     $('#menu').toggleClass('on');
    //
    // });




    // $(".scroll_slider").slick({
    //     dots: false, //navigation
    //     arrows: false, //arrow
    //     prevArrow: $('.prev'), //prev
    //     nextArrow: $('.next'), //next
    //     autoplay:true, // autoplay mode
    //     autoplaySpeed: 2000, // auto speed
    //     pauseOnHover:false, // pause on mouse hover
    //     fade: true, //fade mode only one slider
    //     speed: 900, // speed
    //     infinite: true, // infinite mode
    //     // asNavFor: '.slider2', // another slider
    //     centerMode: false, // center move
    //     centerPadding: '0%', // center move padding
    //     slidesToShow: 1, // show slider number
    //     slidesToScroll: 1, // next slider number
    //     swipe: true, // swiper
    //     focusOnSelect: true, // click to slider
    //     draggable:true,
    //     vertical: false, // vertical slider
    //     verticalSwiping: false, // vertical swiper
    //     initialSlide:0,// slider number
    //     cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
    //     variableWidth: false,
    //
    // });


   //  $(".visual_slider").slick({
   //      dots: false, //navigation
   //      arrows: false, //arrow
   //      prevArrow: $('.prev'), //prev
   //      nextArrow: $('.next'), //next
   //      autoplay:false, // autoplay mode
   //      autoplaySpeed: 2000, // auto speed
   //      pauseOnHover:false, // pause on mouse hover
   //      fade: false, //fade mode only one slider
   //      speed: 900, // speed
   //      infinite: false, // infinite mode
   //      // asNavFor: '.slider2', // another slider
   //      centerMode: false, // center move
   //      centerPadding: '0%', // center move padding
   //      slidesToShow: 0, // show slider number
   //      slidesToScroll: 0, // next slider number
   //      swipe: true, // swiper
   //      focusOnSelect: true, // click to slider
   //      draggable:true,
   //      vertical: false, // vertical slider
   //      verticalSwiping: false, // vertical swiper
   //      initialSlide:0,// slider number
   //      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
   //      variableWidth: false,
   //
   //  });
   //
   //
   //  $("#visual_slider02").slick({
   //      dots: false, //navigation
   //      arrows: true, //arrow
   //      prevArrow: $('#section05 .arrow01'), //prev
   //      nextArrow: $('#section05 .arrow02'), //next
   //      autoplay:true, // autoplay mode
   //      autoplaySpeed: 2000, // auto speed
   //      pauseOnHover:false, // pause on mouse hover
   //      fade: false, //fade mode only one slider
   //      speed: 900, // speed
   //      infinite: true, // infinite mode
   //      // asNavFor: '.slider2', // another slider
   //      centerMode: false, // center move
   //      centerPadding: '0%', // center move padding
   //      slidesToShow: 1, // show slider number
   //      slidesToScroll: 1, // next slider number
   //      swipe: true, // swiper
   //      focusOnSelect: true, // click to slider
   //      draggable:true,
   //      vertical: false, // vertical slider
   //      verticalSwiping: false, // vertical swiper
   //      initialSlide:0,// slider number
   //      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
   //      variableWidth: false,
   //
   //  }).on('beforeChange', function(event, slick, currentSlide, nextSlide){
   //      $('#section01 .commentbox .commentbox_middle .box > div').removeClass('on');
   //
   //
   //
   //  }).on('afterChange', function(event, slick, currentSlide, nextSlide){
   //
   //
   //
   //
   //      $('#section01 .commentbox .commentbox_middle .box > div').eq(currentSlide).addClass('on');
   //
   //
   //  });
   //
   //
   // });
   //
   //  $("#visual_slider03").slick({
   //      dots: false, //navigation
   //      arrows: true, //arrow
   //      prevArrow: $('#section02 .button_L'), //prev
   //      nextArrow: $('#section02 .button_R'), //next
   //      autoplay:true, // autoplay mode
   //      autoplaySpeed: 2000, // auto speed
   //      pauseOnHover:false, // pause on mouse hover
   //      fade: false, //fade mode only one slider
   //      speed: 900, // speed
   //      infinite: true, // infinite mode
   //      // asNavFor: '.slider2', // another slider
   //      centerMode: false, // center move
   //      centerPadding: '0%', // center move padding
   //      slidesToShow: 3, // show slider number
   //      slidesToScroll: 1, // next slider number
   //      swipe: true, // swiper
   //      focusOnSelect: true, // click to slider
   //      draggable:true,
   //      vertical: false, // vertical slider
   //      verticalSwiping: false, // vertical swiper
   //      initialSlide:0,// slider number
   //      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
   //      variableWidth: false,
   //
   //  });
   //
   //
   //  $("#visual_slider04").slick({
   //      dots: true, //navigation
   //      arrows: false, //arrow
   //      prevArrow: $('.prev'), //prev
   //      nextArrow: $('.next'), //next
   //      autoplay:true, // autoplay mode
   //      autoplaySpeed: 2000, // auto speed
   //      pauseOnHover:false, // pause on mouse hover
   //      fade: false, //fade mode only one slider
   //      speed: 900, // speed
   //      infinite: true, // infinite mode
   //      // asNavFor: '.slider2', // another slider
   //      centerMode: false, // center move
   //      centerPadding: '0%', // center move padding
   //      slidesToShow: 1, // show slider number
   //      slidesToScroll: 1, // next slider number
   //      swipe: true, // swiper
   //      focusOnSelect: true, // click to slider
   //      draggable:true,
   //      vertical: false, // vertical slider
   //      verticalSwiping: false, // vertical swiper
   //      initialSlide:0,// slider number
   //      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
   //      variableWidth: false,
   //
   //  }).on('beforeChange', function(event, slick, currentSlide, nextSlide){
   //      $('#section04 .cover04 .room .txtbg .txtbox .txtslider  > div').removeClass('on');
   //
   //
   //
   //  }).on('afterChange', function(event, slick, currentSlide, nextSlide){
   //
   //
   //
   //
   //      $('#section04 .cover04 .room .txtbg .txtbox .txtslider  > div').eq(currentSlide).addClass('on');
   //
   //
   //  });
   //
   //
   //  $("#visual_slider05").slick({
   //      dots: false, //navigation
   //      arrows: false, //arrow
   //      prevArrow: $('.prev'), //prev
   //      nextArrow: $('.next'), //next
   //      autoplay:true, // autoplay mode
   //      autoplaySpeed: 2000, // auto speed
   //      pauseOnHover:false, // pause on mouse hover
   //      fade: true, //fade mode only one slider
   //      speed: 900, // speed
   //      infinite: true, // infinite mode
   //      // asNavFor: '.slider2', // another slider
   //      centerMode: false, // center move
   //      centerPadding: '0%', // center move padding
   //      slidesToShow: 1, // show slider number
   //      slidesToScroll: 1, // next slider number
   //      swipe: true, // swiper
   //      focusOnSelect: true, // click to slider
   //      draggable:true,
   //      vertical: false, // vertical slider
   //      verticalSwiping: false, // vertical swiper
   //      initialSlide:0,// slider number
   //      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)', //css transition∑
   //      variableWidth: false,
   //
   //  }).on('beforeChange', function(event, slick, currentSlide, nextSlide){
   //
   //      $('.line > div').removeClass('on');
   //  }).on('afterChange', function(event, slick, currentSlide, nextSlide){
   //
   //      $('.line > div').eq(currentSlide).addClass('on');
   //
   //    });
   //
   //
   //
   //  $('.line > div').click(function (){
   //
   //      let idx =   $('.line > div').index(this);
   //
   //      $('.line > div').removeClass('on');
   //      $(this).addClass('on');
   //
   //      $("#visual_slider05").slick('slickGoTo',idx);
   //  });
   //
   //
   //  const video = document.querySelector('#video');
   //
   //
   //  $('#menu .videobox .txt').click(function (){
   //
   //      $('.videoboxon').addClass('on');
   //      video.play();
   //
   //  });
   //
   //  $('#menu .videoboxon .button').click(function (){
   //
   //      $('.videoboxon').removeClass('on');
   //      video.pause();
   //
   //
   //  });










// })


