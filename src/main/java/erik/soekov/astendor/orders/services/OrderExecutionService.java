package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.worlds.models.World;

public interface OrderExecutionService {

    public void executeWarlordOrders(Warlord warlord);
    public void executeWorldOrders(World world);
}
