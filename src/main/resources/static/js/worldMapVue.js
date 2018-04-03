Vue.component("areabanner", {
    template: `
                <img v-show="this.warrior.x == this.x && this.warrior.y == this.y" class="area-banner" src="/flags/egypt.png">
            `,
    props: {
        x: {required: true},
        y: {required: true},
        warrior: {required: true}
    },
    mounted(){
        console.log(this.x + ":" + this.y);
        console.log("warlord x " + this.warrior.x);
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
            x: 1,
            y: 1,
        }

    },
    methods: {
        setWarlordPos(x,y){
            this.warlord.x = x;
            this.warlord.y = y;
        }
    }

});
