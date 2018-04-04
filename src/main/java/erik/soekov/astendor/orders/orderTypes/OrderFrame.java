package erik.soekov.astendor.orders.orderTypes;

import erik.soekov.astendor.warlords.model.Warlord;

public interface OrderFrame {

    public void setParams(String params);
    public void executeOrder(Warlord warlord);
}
