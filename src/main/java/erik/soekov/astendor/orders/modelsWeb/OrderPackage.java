package erik.soekov.astendor.orders.modelsWeb;

import java.util.List;

public class OrderPackage {

    private List<StrippedOrder> warlordOrders;
    private Integer warlordId;

    public OrderPackage() {
    }

    public List<StrippedOrder> getWarlordOrders() {
        return warlordOrders;
    }

    public void setWarlordOrders(List<StrippedOrder> warlordOrders) {
        this.warlordOrders = warlordOrders;
    }

    public Integer getWarlordId() {
        return warlordId;
    }

    public void setWarlordId(Integer warlordId) {
        this.warlordId = warlordId;
    }
}
