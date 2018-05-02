package erik.soekov.astendor.orders.dtos;

import java.util.List;

public class OrderPackage {

    private List<StrippedOrder> warlordOrders;
    private Integer worldId;

    public OrderPackage() {
    }

    public List<StrippedOrder> getWarlordOrders() {
        return warlordOrders;
    }

    public void setWarlordOrders(List<StrippedOrder> warlordOrders) {
        this.warlordOrders = warlordOrders;
    }

    public Integer getWorldId() {
        return worldId;
    }

    public void setWorldId(Integer worldId) {
        this.worldId = worldId;
    }
}
