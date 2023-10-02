if (typeof jQuery === "undefined") {
  throw new Error("Requires jQuery");
}

'use strict';

$(function () {
  var options = {
    navbarMenuSlimscroll: true,
    navbarMenuSlimscrollWidth: "3px",
    navbarMenuHeight: "200px",
    sidebarToggleSelector: "[data-toggle='offcanvas']",
    sidebarPushMenu: true,
    sidebarSlimScroll: true,
    enableBoxRefresh: true,
    enableBSToppltip: true,
    BSTooltipSelector: "[data-toggle='tooltip']",
    enableFastclick: true,
    enableBoxWidget: true,
    boxWidgetOptions: {
      boxWidgetIcons: {
        collapse: 'fa fa-minus',
        open: 'fa fa-plus',
        remove: 'fa fa-times'
      },
      boxWidgetSelectors: {
        remove: '[data-widget="remove"]',
        collapse: '[data-widget="collapse"]'
      }
    },
    colors: {
      lightBlue: "#3c8dbc",
      red: "#f56954",
      green: "#00a65a",
      aqua: "#00c0ef",
      yellow: "#f39c12",
      blue: "#0073b7",
      navy: "#001F3F",
      teal: "#39CCCC",
      olive: "#3D9970",
      lime: "#01FF70",
      orange: "#FF851B",
      fuchsia: "#F012BE",
      purple: "#8E24AA",
      maroon: "#D81B60",
      black: "#222222",
      gray: "#d2d6de"
    }
  };

  var fixLayout = function () {
    var neg = $('.main-header').outerHeight() + $('.main-footer').outerHeight();
    var window_height = $(window).height();
    var sidebar_height = $(".sidebar").height();

    if ($("body").hasClass("fixed")) {
      $(".content-wrapper, .right-side").css('min-height', window_height - $('.main-footer').outerHeight());
    } else {
      if (window_height >= sidebar_height) {
        $(".content-wrapper, .right-side").css('min-height', window_height - neg);
      } else {
        $(".content-wrapper, .right-side").css('min-height', sidebar_height);
      }
    }
  };

  var fixSidebar = function () {
    if (!$("body").hasClass("fixed")) {
      if (typeof $.fn.slimScroll != 'undefined') {
        $(".sidebar").slimScroll({ destroy: true }).height("auto");
      }
      return;
    } else if (typeof $.fn.slimScroll == 'undefined' && console) {
      console.error("Error: the fixed layout requires the slimscroll plugin!");
    }

    if (options.sidebarSlimScroll && typeof $.fn.slimScroll != 'undefined') {
      $(".sidebar").slimScroll({ destroy: true }).height("auto");
      $(".sidebar").slimScroll({
        height: ($(window).height() - $(".main-header").height()) + "px",
        color: "rgba(0,0,0,0.2)",
        size: "3px"
      });
    }
  };

  var pushMenu = function (toggleBtn) {
    $(toggleBtn).click(function (e) {
      e.preventDefault();
      $("body").toggleClass('sidebar-collapse');
      $("body").toggleClass('sidebar-open');
    });

    $(".content-wrapper").click(function () {
      if ($(window).width() <= 767 && $("body").hasClass("sidebar-open")) {
        $("body").removeClass('sidebar-open');
      }
    });
  };

  var activateTree = function (menu) {
    $("li a", $(menu)).click(function (e) {
      var $this = $(this);
      var checkElement = $this.next();

      if ((checkElement.is('.treeview-menu')) && (checkElement.is(':visible'))) {
        checkElement.slideUp('normal', function () {
          checkElement.removeClass('menu-open');
        });
        checkElement.parent("li").removeClass("active");
      } else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
        var parent = $this.parents('ul').first();
        var ul = parent.find('ul:visible').slideUp('normal');
        ul.removeClass('menu-open');
        var parent_li = $this.parent("li");

        checkElement.slideDown('normal', function () {
          checkElement.addClass('menu-open');
          parent.find('li.active').removeClass('active');
          parent_li.addClass('active');
        });
      }
      if (checkElement.is('.treeview-menu')) {
        e.preventDefault();
      }
    });
  };

  // Easy access to options
  var o = options;

  // Activate the layout maker
  fixLayout();

  // Enable sidebar tree view controls
  activateTree('.sidebar');

  // Add slimscroll to navbar dropdown
  if (o.navbarMenuSlimscroll && typeof $.fn.slimscroll != 'undefined') {
    $(".navbar .menu").slimscroll({
      height: "200px",
      alwaysVisible: false,
      size: "3px"
    }).css("width", "100%");
  }

  // Activate sidebar push menu
  if (o.sidebarPushMenu) {
    pushMenu(o.sidebarToggleSelector);
  }

  // Activate Bootstrap tooltip
  if (o.enableBSToppltip) {
    $(o.BSTooltipSelector).tooltip();
  }

  // Activate box widget
  if (o.enableBoxWidget) {
    $('.btn-group[data-toggle="btn-toggle"]').each(function () {
      var group = $(this);
      $(this).find(".btn").click(function (e) {
        group.find(".btn.active").removeClass("active");
        $(this).addClass("active");
        e.preventDefault();
      });
    });
  }

  if (o.enableFastclick && typeof FastClick != 'undefined') {
    FastClick.attach(document.body);
  }

  // Initialize layout
  $(window).resize(function () {
    fixLayout();
    fixSidebar();
  });
  
});
