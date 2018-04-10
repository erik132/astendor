package erik.soekov.astendor.endturn.services;

import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.repos.WorldRepository;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndturnServiceNaive implements EndturnService{

    @Autowired
    private WorldService worldService;

    @Override
    public void endturn(Integer worldId) {
        worldService.IncreaseWorldTurn(worldId);
    }
}
