package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.models.OrderIdentity;
import erik.soekov.astendor.orders.models.OrderType;
import erik.soekov.astendor.orders.modelsWeb.StrippedOrder;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.orders.repos.OrderTypeRepository;
import erik.soekov.astendor.warlords.model.Warlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceStandard implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    private Integer getOrderType(String frontEndCode){
        switch (frontEndCode){
            case "Move":
                return 1;
                default:
                    return -1;
        }
    }

    //is this stupid?
    @Override
    public void processAndSave(List<StrippedOrder> orders, Warlord warlord) {
        List<Order> orderList = new ArrayList<>();
        List<Integer> orderTypeIds = new ArrayList<>();
        Integer countNr = 0;

        for(StrippedOrder order: orders){
            countNr++;
            orderTypeIds.add(this.getOrderType(order.getOrderType()));
            orderList.add(new Order(order.getOrderParams(), warlord, new OrderIdentity(warlord.getId(),countNr)));
        }

        Iterable<OrderType> orderTypes = this.orderTypeRepository.findAllById(orderTypeIds);

        countNr = -1;
        for(OrderType orderType: orderTypes){
            countNr++;
            orderList.get(countNr).setOrderType(orderType);
        }

        this.orderRepository.saveAll(orderList);
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
