package erik.soekov.astendor.orders;

import erik.soekov.astendor.general.MainController;
import erik.soekov.astendor.general.constants.LinkLib;
import erik.soekov.astendor.orders.dtos.OrderPackage;
import erik.soekov.astendor.orders.dtos.StrippedOrder;
import erik.soekov.astendor.orders.services.OrderExecutionService;
import erik.soekov.astendor.orders.services.OrderService;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.services.AstendorUserService;
import erik.soekov.astendor.warlords.exceptions.WarlordNotFoundException;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST, value = "/orders")
public class OrderController {

    @Autowired
    private OrderExecutionService orderExecutionService;

    @Autowired
    private WarlordService warlordService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AstendorUserService userService;

    @RequestMapping("/executewarlord/{id}")
    public String testOrder(@PathVariable Integer id){
        this.orderExecutionService.executeWarlordOrders(this.warlordService.getWarlord(id));
        return "order set";
    }

    @RequestMapping("save/{worldId}")
    public String saveOrders(@RequestBody OrderPackage orderPackage, Authentication authentication){
        User user = this.userService.findByAuthentication(authentication);

        try {
            this.orderService.saveOrders(orderPackage, user);
        }catch (WarlordNotFoundException wnfe){
            return "orders not saved";
        }
        return "orders received";
    }
}
