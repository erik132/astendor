Vue.component("areabanner", {
    template: `
                <img v-show="this.warlord.x == this.x && this.warlord.y == this.y" class="area-banner" src="/flags/egypt.png">
            `,
    props: {
        x: {required: true},
        y: {required: true},
        warlord: {required: true}
    },
    mounted(){

    },
    computed:{

    },
    methods:{
    }
});


var mapview = new Vue({
    el: "#mapview",
    data: {
        warlord:{
            id: 1,
            x: 1,
            y: 1,
        }

    },
    methods: {
        setWarlordPos(x,y){
            this.warlord.x = x;
            this.warlord.y = y;
        },
        endturn(){
            console.log("ending turn");
            this.$http.post("/endturn/1/").then(function (response) {
                console.log("success");
                console.log(response.data);
                this.getState();
            },function(response) {
                console.log("error ending turn");
                console.log(response.data);
            });
        },
        getState(){
            this.$http.post("/worldstate/get/1").then(function(response){
               this.processState(response.data);

            }, function(response){
                console.log("error getting world state");
                console.log(response.data);
            });
        },
        processState(state){
            this.setWarlordPos(state.warlord.x, state.warlord.y);
            this.warlord.id = state.warlord.id;
        }
    }
});

var orderSection = new Vue({
    el: "#orderSection",
    data: {
        msg: "tere",
        orderHolder: "#orderHolder",
        currentId: 4
    },
    methods:{
        countChildren(){
            var items = $(this.orderHolder).sortable("toArray");

            items.forEach(items=>{
                $("#"+items).children(".level-left").children("span").each(function(){
                    console.log($(this).html());
                });
            });
        },
        addMovementOrder(direction){
            this.currentId++;
            let movementOrder = `
                
                <div class="notification has-text-black level" id="order` + this.currentId +`">
                    <div class="level-left">
                    <span class="order-type">Move</span> <span>` + direction +`</span>
                    </div>
                    <div class="level-right">
                        <span class="icon has-text-danger" onclick="orderSection.deleteMovementOrder('order` + this.currentId +`')">
                          <i class="fas fa-ban"></i>
                        </span>
                    </div>
                </div>
                
            `;
            $(this.orderHolder).append(movementOrder);
        },
        deleteMovementOrder(orderId){
            $("#" + orderId).remove();
        }
    }
});
