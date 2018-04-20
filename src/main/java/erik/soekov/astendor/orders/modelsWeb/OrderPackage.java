package erik.soekov.astendor.orders.modelsWeb;

import java.util.List;

public class OrderPackage {

    private List<StrippedOrder> warlordOrders;

    public OrderPackage() {
    }

    public List<StrippedOrder> getWarlordOrders() {
        return warlordOrders;
    }

    public void setWarlordOrders(List<StrippedOrder> warlordOrders) {
        this.warlordOrders = warlordOrders;
    }
}
