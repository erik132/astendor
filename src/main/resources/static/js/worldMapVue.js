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
        console.log(this.x + ":" + this.y);
        console.log("warlord x " + this.warlord.x);
    },
    computed:{

    },
    methods:{
        dispWar(){

        }
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
