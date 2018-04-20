package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.modelsWeb.StrippedOrder;

import java.util.List;

public interface OrderService {

    public void processAndSave(List<StrippedOrder> orders);
    public void saveOrders(List<Order> orders);
    public void saveOrder(Order order);
}
