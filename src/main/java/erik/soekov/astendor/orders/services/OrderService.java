package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.dtos.OrderPackage;
import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.dtos.StrippedOrder;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.exceptions.WarlordNotFoundException;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.model.WarlordPrimitive;

import java.util.List;

public interface OrderService {

    public void saveOrders(OrderPackage orderPackage, User user) throws WarlordNotFoundException;
    public void saveOrders(List<Order> orders);
    public void saveOrder(Order order);
    public void deleteWarlordOrders(Warlord warlord);
    public void deleteWarlordOrders(WarlordPrimitive warlord);
}
