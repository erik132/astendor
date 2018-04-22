package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.worlds.models.World;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import erik.soekov.astendor.orders.orderTypes.OrderFrame;

import java.util.List;
import java.util.Set;

@Service
public class OrderExecutionServiceImpl implements OrderExecutionService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void executeWarlordOrders(Warlord warlord) {
        Order order = this.orderRepository.findFirstByWarlord(warlord);

        if(order == null){
            return;
        }

        try{
            OrderFrame frame = (OrderFrame) this.appContext.getBean(order.getOrderType().getOrderBean());
            frame.executeOrder(order.getOrderParams(),warlord);
        }catch (BeansException be){
            //just skip the order and log error
            System.out.println("can not obtain bean " + order.getOrderType().getOrderBean());
        }catch (Exception e){
            //not important in prototype, just log error
            System.out.println("error when parsing bean name " + order.getOrderType().getOrderBean());
            e.printStackTrace();
        }

        this.orderRepository.delete(order);
    }

    @Override
    public void executeWorldOrders(World world) {
        Set<Warlord> warlords = world.getWarlords();
        warlords.forEach(this::executeWarlordOrders);
    }
}
