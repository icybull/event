// accordian menu
$(".section-title").on('click', function (e) {
  if ($(this).hasClass('open')) {
    $('.section-title').removeClass('open');
    $('.collapsing-section').slideUp();
  } else {
    $('.section-title').removeClass('open');
    $('.collapsing-section').slideUp();
    $(this).addClass('open');
    var sectionToOpen = $(this).next('.collapsing-section');
    $(sectionToOpen).slideDown();
  }
});


//popup
function popUp(){
  $('#name').val('');
  $('#phone_No').val('');
  $('#popup').css('display', 'flex').hide().fadeIn();
}

function modalClose(){
  $('#popup').fadeOut();
}

// reply



//top-btn
const btt = $("#back-to-top");
$(window).scroll(function () {
  if ($(window).scrollTop() > 150) {
    btt.addClass("visible");
  } else {
    btt.removeClass("visible");
  }
});
btt.click(function (e) {
  e.preventDefault();
  $("html,body").animate({ scrollTop: 0 }, 400);
});

// sticky-header

const pageTab = $("#page-tab").offset().top;
console.log(pageTab);
var speed = 270;
// 360*780에서 top:685

$(window).scroll(function () {
  if ($(window).scrollTop() > pageTab) {
    $('#page-tab>ul').addClass("fix-top");
  } else {
    $('#page-tab>ul').removeClass("fix-top");
  }
  let scrollTop = $(window).scrollTop();
  if (scrollTop >= $("#main-banner").offset().top - speed) {
    $("#page-tab>ul>li")
      .eq(0)
      .addClass("active")
      .siblings()
      .removeClass("active");
  }
  if (scrollTop >= $("#review-notice").offset().top - speed) {
    $("#page-tab>ul>li")
      .eq(1)
      .addClass("active")
      .siblings()
      .removeClass("active");
  }
  if (scrollTop >= $("#join").offset().top - speed) {
    $("#page-tab>ul>li")
      .eq(2)
      .addClass("active")
      .siblings()
      .removeClass("active");
  }
});
var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('.bottom-menu').outerHeight();

$(window).scroll(function(event){
  didScroll = true;
});

setInterval(function() {
  if (didScroll) {
    hasScrolled();
    didScroll = false;
  }
}, 250);

function hasScrolled() {
  var st = $(this).scrollTop();
  if(Math.abs(lastScrollTop - st) <= delta)
    return;
  if (st > lastScrollTop && st > navbarHeight){
    $('.bottom-menu').removeClass('nav-down').addClass('nav-up');
    btt.removeClass("nav-down").addClass('nav-up');
  } else {
    if(st + $(window).height() < $(document).height()) {
      $('.bottom-menu').removeClass('nav-up').addClass('nav-down');
      btt.addClass("nav-down").removeClass('nav-up');
    }
  }

  lastScrollTop = st;
}

// 중간 탭메뉴
const topmenu = $("#page-tab li");
const headerHeight = $('.header-top').height()+10;
const tabHeight = $('#page-tab').height()+10;

topmenu.click(function (e) {
  e.preventDefault();
  let target = $(this);
  let index = target.index();
  console.log(index)
  let section = $(".section").eq(index);
  let offset = section.offset().top;
  $("html,body").animate({ scrollTop: offset-headerHeight-tabHeight }, 500);
});

//스크롤 애니메이션
const visual = $(".visual")
const speed2 = 500

$(window).on('scroll', function(){
  let scrollTop = $(window).scrollTop()
  visual.each(function(i){
    if(scrollTop >= visual.eq(i).offset().top-speed2){
      visual.eq(i).find('.show-up').addClass('active')
    }
  })
})