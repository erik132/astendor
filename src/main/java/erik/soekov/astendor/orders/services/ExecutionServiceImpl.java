package erik.soekov.astendor.orders.services;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.repos.OrderRepository;
import erik.soekov.astendor.warlords.model.Warlord;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import erik.soekov.astendor.orders.orderTypes.OrderFrame;

import java.util.List;

@Service
public class ExecutionServiceImpl implements ExecutionService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void executeWarlordOrders(Warlord warlord) {
        List<Order> orders = this.orderRepository.getWarlordOrders(warlord);
        System.out.println("nr of orders: " + orders.size());
        for(Order order: orders) {

            try{
                OrderFrame frame = (OrderFrame) this.appContext.getBean(order.getOrderType().getOrderBean());
                frame.setParams(order.getOrderParams());
                frame.executeOrder(warlord);
            }catch (BeansException be){
                //just skip the order and log error
                System.out.println("can not obtain bean " + order.getOrderType().getOrderBean());
            }catch (Exception e){
                //not important in prototype, just log error
                System.out.println("error when parsing bean name " + order.getOrderType().getOrderBean());
                e.printStackTrace();
            }
        }
    }
}
