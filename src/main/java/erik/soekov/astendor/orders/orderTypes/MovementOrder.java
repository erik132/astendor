package erik.soekov.astendor.orders.orderTypes;

import erik.soekov.astendor.warlords.model.Warlord;

public class MovementOrder implements OrderFrame{

    public MovementOrder() {
    }

    @Override
    public void setParams(String params) {
        System.out.println("order params " + params);
    }

    @Override
    public void executeOrder(Warlord warlord) {
        System.out.println("Executing movement order");
    }
}
