$(document).ready(function() {
    let font = 14
    
    $("#increase-text").click(function() {
        if(font < 25){
            $("body").css({"font-size": ++font + "px"})
        }
    })
    
    $("#decrease-text").click(function() {
        if(font > 14) {
            $("body").css({"font-size": --font + "px"})
        }
    })
})
