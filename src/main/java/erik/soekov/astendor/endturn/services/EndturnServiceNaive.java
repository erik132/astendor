package erik.soekov.astendor.endturn.services;

import erik.soekov.astendor.orders.services.OrderExecutionService;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.repos.WorldRepository;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndturnServiceNaive implements EndturnService{

    @Autowired
    private WorldService worldService;

    @Autowired
    private OrderExecutionService orderService;

    @Override
    public void endturn(Integer worldId) {
        World world = worldService.getWorld(worldId);
        worldService.IncreaseWorldTurn(worldId);
        orderService.executeWorldOrders(world);
    }
}
