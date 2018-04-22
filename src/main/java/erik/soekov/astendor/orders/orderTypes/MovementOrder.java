package erik.soekov.astendor.orders.orderTypes;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.warlords.model.Warlord;

import java.awt.*;


public class MovementOrder extends OrderFrame{

    private final String east = "east";
    private final String south = "south";
    private final String west = "west";
    private final String north = "north";


    public MovementOrder() {

    }


    private Point translParams(String params) {
        Integer moveX=0;
        Integer moveY=0;
        switch (params){
            case east:
                moveX = 1;
                break;
            case west:
                moveX = -1;
                break;
            case south:
                moveY = 1;
                break;
            case north:
                moveY = -1;
                break;
                default:
                    System.out.println("Problems interpreting warlord orders");

        }
        return new Point(moveX, moveY);
    }

    @Override
    public void executeOrder(String params, Warlord warlord) {
        Integer x = warlord.getX();
        Integer y = warlord.getY();

        Point movement = this.translParams(params);

        WorldMap map = warlord.getWorld().getMap();
        x += movement.x;
        y += movement.y;

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
