

var tooltips = document.querySelectorAll('.maptip .maptiptext');

window.onmousemove = function (e) {
    var x = (e.clientX + 20) + 'px',
        y = (e.clientY + 20) + 'px';
    for (var i = 0; i < tooltips.length; i++) {
        tooltips[i].style.top = y;
        tooltips[i].style.left = x;
    }
};


function endturn(){
    mapview.endturn();
}

function initmap(){
    mapview.getState();
}

function updateState(){
    mapview.getState();
}


//---------------------------------------------------
//
//              All initialisers
//
//----------------------------------------------------

setEqual();
initmap();