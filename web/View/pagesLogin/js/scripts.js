/*!
    * Start Bootstrap - SB Admin v6.0.2 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
    function validate (input) {
         if($(input).attr('type') == 'numeric' || $(input).attr('name') == 'txtReg')  {
            if($(input).val().trim().match(/[-]{0,1}[\d]*[.]{0,1}[\d]+/g) == null) {
                return false;
            }
        }
        if($(input).attr('type') == 'password' || $(input).attr('name') == 'senha' || $(input).attr('name') == 'senha') {
            if($(input).val().trim().match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/) == null) {
                return false;
            }
        }
        else{
        input.setCustomValidity('');
    }
        
    }
    
})(jQuery);
