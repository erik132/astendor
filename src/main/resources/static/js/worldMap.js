function setEqual(){
    var cw = $('.map-strech').width();
    $('.map-strech').css({
        'height': cw + 'px'
    });
}

function initOrderSection(){
    var height = $("#mapview").height();
    $(".order-holder").css({
        'height': height + "px"
    });
}

function initOrderMenu(){
    var cw = $('.movement-order-tile').width();
    $('.movement-order-tile').css({
        'height': cw + 'px'
    });
}


