package erik.soekov.astendor.orders;

import erik.soekov.astendor.orders.orderTypes.MovementOrder;
import erik.soekov.astendor.orders.orderTypes.OrderFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean(name = "movementOrder")
    public OrderFrame movementOrder(){
        return new MovementOrder();
    }
}
