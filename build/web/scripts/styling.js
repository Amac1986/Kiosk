/* 
 * Author: Matt
 */
$(document).ready( function() {
    $(".ui-layout-unit").css({
        "border":"none",
        "border-radius":"0"
    });
    
    $(".ui-layout-north").css({
        "background":"url(images/topBar.png)",
        "background-size":"100% 100%"
    });
    
    $(".ui-layout-north .ui-widget-content").css({
        "background-color":"rgba(0,0,0,0)"
    });
    
    $(".ui-layout-east").css({
        "padding":"0",
        "background-color":"#ccc"
    });
    
    $(".ui-layout-east h2").css({
        "text-align":"center",
        "color":"#fff",
        "background":"#737373",
        "margin":"0 0 10px 0",
        "padding":"10px 10px"
    });
    
    $(".ui-layout-east .ui-widget-content").css({
        "padding":"0",
        "background-color":"rgba(0,0,0,0)"
    });
    
    $("#optionsContainer").css({
        "margin":"0",
        "padding":"10px"
    });
});