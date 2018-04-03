package erik.soekov.astendor.endturn.services;

import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.repos.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndturnServiceNaive implements EndturnService{

    @Autowired
    private WorldRepository worldRepository;

    @Override
    public void endturn(Integer worldId) {
        World world = this.worldRepository.findById(worldId).get();
        world.increaseTurn();
        this.worldRepository.save(world);
    }
}
