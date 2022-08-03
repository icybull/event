//slick slider
$('.ing-rel-box').slick({
  arrows:false,
  dots:true,
  autoplay:true,
  autoplaySpeed:4000,
  infinite:true,
});

// sticky header
var $mainHeader = $(".event-tab"),
    $window = $(window),
    $divide = $mainHeader.outerHeight();

$window.scroll(function () {
  if ($window.scrollTop() > $divide) {
    if (!$mainHeader.hasClass("shrink")) {
      $mainHeader.addClass("shrink");
    }
  } else {
    if ($mainHeader.hasClass("shrink")) {
      $mainHeader.removeClass("shrink");
    }
  }
});

//top btn

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

// event-tab
const tab = $("main>.event-tab>ul")
const speed = 200;

$(window).scroll(function () {
  if ($(window).scrollTop() > 200) {
    tab.addClass("small");
  } else {
    tab.removeClass("small");
  }
  let scrollTop = $(window).scrollTop();
  if (scrollTop >= $("#ing-content").offset().top - speed) {
    $("main>.event-tab>ul>li")
        .eq(0)
        .addClass("active")
        .siblings()
        .removeClass("active");
  }
  if (scrollTop >= $("#end-content").offset().top - speed) {
    $("main>.event-tab>ul>li")
        .eq(1)
        .addClass("active")
        .siblings()
        .removeClass("active");
  }
  if (scrollTop >= $("#review-content").offset().top - speed) {
    $("main>.event-tab>ul>li")
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

// 중간탭메뉴 - .event-tab
const topmenu = $(".event-tab li");
const headerHeight = $('.header-top').height()+10;
const tabHeight = $('.event-tab').height()+10;

topmenu.click(function (e) {
  e.preventDefault();
  let target = $(this);
  let index = target.index();
  let section = $(".section").eq(index);
  let offset = section.offset().top;
  $("html,body").animate({ scrollTop: offset-headerHeight-tabHeight }, 500);
});
