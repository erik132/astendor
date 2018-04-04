package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.warlords.model.Warlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import erik.soekov.astendor.orders.orderTypes.OrderFrame;

import java.util.List;

@Service
public class ExecutionServiceImpl implements ExecutionService{

    @Autowired
    private OrderRepository orderRepository;

    private String orderPath = "erik.soekov.astendor.orders.orderTypes";

    @Override
    public void executeWarlordOrders(Warlord warlord) {
        List<Order> orders = this.orderRepository.getWarlordOrders(warlord);
        System.out.println("nr of orders: " + orders.size());
        for(Order order: orders) {
            try {
                OrderFrame frame = (OrderFrame) Class.forName(this.orderPath + "." + order.getOrderType().getOrderClass()).newInstance();
                frame.setParams(order.getOrderParams());
                frame.executeOrder(warlord);
            } catch (ClassNotFoundException e) {
                //just skip the order and log error
                System.out.println("Order not found " + order.getOrderType().getOrderClass());
            } catch (Exception e){
                //not important in prototype, just log error
                System.out.println("Problems instantiating ordertype class from string");
            }
        }
    }
}
