package erik.soekov.astendor.orders;

import erik.soekov.astendor.orders.services.ExecutionService;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private ExecutionService executionService;

    @Autowired
    private WarlordService warlordService;

    @RequestMapping("/orders/{id}")
    public String setOrder(@PathVariable Integer id){
        this.executionService.executeWarlordOrders(this.warlordService.getWarlord(id));
        return "order set";
    }
}
