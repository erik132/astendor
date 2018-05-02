package erik.soekov.astendor.orders.services;


import erik.soekov.astendor.orders.dtos.OrderPackage;
import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.models.OrderPrimitive;
import erik.soekov.astendor.orders.dtos.StrippedOrder;
import erik.soekov.astendor.orders.repos.OrderPrimitiveRepository;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.exceptions.WarlordNotFoundException;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.models.WorldNoTiles;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceStandard implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPrimitiveRepository orderPrimitiveRepository;

    @Autowired
    private WorldService worldService;

    private Integer translateOrderType(String frontEndCode){
        switch (frontEndCode){
            case "Move":
                return 1;
                default:
                    return -1;
        }
    }

    //is this stupid?
    /*@Override
    public void processAndSave(List<StrippedOrder> orders, Warlord warlord) {
        List<OrderPrimitive> orderList = new ArrayList<>();
        Integer countNr = 0;

        this.deleteWarlordOrders(warlord);

        for(StrippedOrder order: orders){
            countNr++;
            orderList.add(new OrderPrimitive(warlord.getId(),
                    countNr,
                    this.translateOrderType(order.getOrderType()),
                    order.getOrderParams()));
        }

        this.orderPrimitiveRepository.saveAll(orderList);
    }*/

    @Override
    public void saveOrders(OrderPackage orderPackage, User user) throws WarlordNotFoundException {
        List<OrderPrimitive> orderList = new ArrayList<>();
        Integer countNr = 0;
        WorldNoTiles world = this.worldService.getNoTiles(orderPackage.getWorldId());
        Warlord warlord = world.findWarlord(user);

        if(warlord == null){
            throw new WarlordNotFoundException("warlord not found in world " + world.getName());
        }

        this.deleteWarlordOrders(warlord);
        for(StrippedOrder order: orderPackage.getWarlordOrders()){
            countNr++;
            orderList.add(new OrderPrimitive(warlord.getId(),
                    countNr,
                    this.translateOrderType(order.getOrderType()),
                    order.getOrderParams()));
        }
        this.orderPrimitiveRepository.saveAll(orderList);
    }

    @Override
    public void saveOrders(List<Order> orders) {

        this.orderRepository.saveAll(orders);
    }

    @Override
    public void saveOrder(Order order) {

        this.orderRepository.save(order);
    }

    @Override
    public void deleteWarlordOrders(Warlord warlord) {
        this.orderPrimitiveRepository.deleteWarlordOrders(warlord.getId());
    }


}
