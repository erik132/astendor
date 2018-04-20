package erik.soekov.astendor.orders;

import erik.soekov.astendor.orders.modelsWeb.OrderPackage;
import erik.soekov.astendor.orders.modelsWeb.StrippedOrder;
import erik.soekov.astendor.orders.services.OrderExecutionService;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST, value = "/orders")
public class OrderController {

    @Autowired
    private OrderExecutionService orderExecutionService;

    @Autowired
    private WarlordService warlordService;

    @RequestMapping("/executewarlord/{id}")
    public String testOrder(@PathVariable Integer id){
        this.orderExecutionService.executeWarlordOrders(this.warlordService.getWarlord(id));
        return "order set";
    }

    @RequestMapping("save/{warlordid}")
    public String saveOrders(@RequestBody OrderPackage orderPackage){
        List<StrippedOrder> orders = orderPackage.getWarlordOrders();

        orders.forEach(order ->{
            System.out.println(order.toString());
        });
        return "orders received";
    }
}
