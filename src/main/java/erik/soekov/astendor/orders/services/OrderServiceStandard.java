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
import erik.soekov.astendor.warlords.model.WarlordPrimitive;
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
            case "Movement":
                return 1;
                default:
                    return -1;
        }
    }

    private String translateToFrontOrderType(Integer backendCode){
        switch (backendCode){
            case 1:
                return "Movement";
                default:
                    return "None";
        }
    }

    @Override
    public void saveOrders(OrderPackage orderPackage, User user) throws WarlordNotFoundException {
        List<OrderPrimitive> orderList = new ArrayList<>();
        Integer countNr = 0;
        WarlordPrimitive warlord = this.getMinWarlord(orderPackage.getWorldId(), user);

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
    public List<StrippedOrder> getWarlordOrders(Integer worldId, User user) throws WarlordNotFoundException {
        List<StrippedOrder> results = new ArrayList<>();
        WarlordPrimitive warlord = this.getMinWarlord(worldId, user);

        List<OrderPrimitive> orders = this.orderPrimitiveRepository.allWarlordOrders(warlord.getId());
        orders.forEach(order ->{
            results.add(new StrippedOrder(this.translateToFrontOrderType(order.getOrderType()), order.getOrderParams()));
        });

        return results;
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

    @Override
    public void deleteWarlordOrders(WarlordPrimitive warlord) {
        this.orderPrimitiveRepository.deleteWarlordOrders(warlord.getId());
    }

    private WarlordPrimitive getMinWarlord(Integer worldId, User user) throws WarlordNotFoundException{
        WorldNoTiles world = this.worldService.getNoTiles(worldId);
        WarlordPrimitive warlord = world.findWarlord(user);

        if(warlord == null){
            throw new WarlordNotFoundException("warlord not found in world " + world.getName());
        }
        return warlord;
    }

}
