package erik.soekov.astendor.orders;

import erik.soekov.astendor.orders.dtos.OrderPackage;
import erik.soekov.astendor.orders.services.OrderExecutionService;
import erik.soekov.astendor.orders.services.OrderService;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.services.AstendorUserService;
import erik.soekov.astendor.warlords.exceptions.WarlordNotFoundException;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/orders")
public class OrderRestController {

    @Autowired
    private OrderExecutionService orderExecutionService;

    @Autowired
    private WarlordService warlordService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AstendorUserService userService;

    @RequestMapping(method = RequestMethod.POST, value="/executewarlord/{id}")
    public String testOrder(@PathVariable Integer id){
        this.orderExecutionService.executeWarlordOrders(this.warlordService.getWarlord(id));
        return "order set";
    }

    @RequestMapping(method = RequestMethod.POST, value="save/{worldId}")
    public String saveOrders(@RequestBody OrderPackage orderPackage, Authentication authentication){
        User user = this.userService.findByAuthentication(authentication);

        try {
            this.orderService.saveOrders(orderPackage, user);
        }catch (WarlordNotFoundException wnfe){
            return "orders not saved";
        }
        return "orders received";
    }

    @RequestMapping(method = RequestMethod.GET,value="/get-orders/{worldId}")
    public OrderPackage getOrders(@PathVariable Integer worldId, Authentication authentication){
        OrderPackage result = new OrderPackage();
        User user = this.userService.findByAuthentication(authentication);

        try{
            result.setWarlordOrders(this.orderService.getWarlordOrders(worldId, user));
            result.setWorldId(worldId);
        }catch (WarlordNotFoundException wnfe){
            result.setWarlordOrders(new ArrayList<>());
            return result;
        }

        return result;
    }
}
