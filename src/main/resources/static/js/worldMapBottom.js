

var tooltips = document.querySelectorAll('.maptip .maptiptext');

window.onmousemove = function (e) {
    var x = (e.clientX + 20) + 'px',
        y = (e.clientY + 20) + 'px';
    for (var i = 0; i < tooltips.length; i++) {
        tooltips[i].style.top = y;
        tooltips[i].style.left = x;
    }
};

$( function() {
    var holder = $( "#orderHolder" );
    holder.sortable();
    holder.disableSelection();
} );

function endturn(){
    mapview.endturn();
}

function initmap(){
    mapview.getState();
}

function updateState(){
    mapview.getState();
}

function addOrder(){
    orderSection.addMovementOrder("north");
    orderSection.addMovementOrder("east");
    orderSection.addMovementOrder("south");
}

function saveOrders(){
    orderSection.saveOrders();
}


//---------------------------------------------------
//
//              All initialisers
//
//----------------------------------------------------

setEqual();
initmap();
initOrderSection();