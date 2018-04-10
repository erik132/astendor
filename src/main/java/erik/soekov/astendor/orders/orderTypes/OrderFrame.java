package erik.soekov.astendor.orders.orderTypes;

import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderFrame {

    @Autowired
    protected WarlordService warlordService;

    public abstract void setParams(String params);
    public abstract void executeOrder(Warlord warlord);
}
