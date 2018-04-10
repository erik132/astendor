package erik.soekov.astendor.orders.orderTypes;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.warlords.model.Warlord;


public class MovementOrder extends OrderFrame{

    private final String east = "east";
    private final String south = "south";
    private final String west = "west";
    private final String north = "north";

    private Integer moveX = 0;
    private Integer moveY = 0;

    public MovementOrder() {
    }

    @Override
    public void setParams(String params) {
        switch (params){
            case east:
                this.moveX = 1;
                break;
            case west:
                this.moveX = -1;
                break;
            case south:
                this.moveY = 1;
                break;
            case north:
                this.moveY = -1;
                break;
                default:
                    System.out.println("Problems interpreting warlord orders");

        }
    }

    @Override
    public void executeOrder(Warlord warlord) {
        Integer x = warlord.getX();
        Integer y = warlord.getY();

        WorldMap map = warlord.getWorld().getMap();
        x += this.moveX;
        y += this.moveY;

        if(x < 0){
            x = 0;
        }
        if(y < 0){
            y = 0;
        }
        if(x >= map.getXdim()){
            x = map.getXdim() -1;
        }
        if(y >= map.getYdim()){
            y = map.getYdim() -1;
        }

        warlord.setX(x);
        warlord.setY(y);
        this.warlordService.setWarlord(warlord);
    }
}
