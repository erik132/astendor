package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.warlords.model.Warlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecutionServiceImpl implements ExecutionService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void executeWarlordOrders(Warlord warlord) {
        List<Order> orders = this.orderRepository.getWarlordOrders(warlord);
        System.out.println("nr of orders: " + orders.size());
    }
}
