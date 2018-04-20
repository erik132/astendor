package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.modelsWeb.StrippedOrder;
import erik.soekov.astendor.orders.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceStandard implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void processAndSave(List<StrippedOrder> orders) {
        List<Order> orderList = new ArrayList<>();

        /*orders.forEach(order->{
            orderList.add(new Order());
        });*/
    }

    @Override
    public void saveOrders(List<Order> orders) {
        this.orderRepository.saveAll(orders);
    }

    @Override
    public void saveOrder(Order order) {
        this.orderRepository.save(order);
    }
}
