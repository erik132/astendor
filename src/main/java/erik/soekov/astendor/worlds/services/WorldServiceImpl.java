package erik.soekov.astendor.worlds.services;

import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.repos.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldServiceImpl implements WorldService{

    @Autowired
    private WorldRepository worldRepository;

    @Override
    public World getWorld(Integer id) {
        return this.worldRepository.findById(id).get();
    }

    @Override
    public void IncreaseWorldTurn(Integer worldId) {
        World world = this.worldRepository.findById(worldId).get();
        world.increaseTurn();
        this.worldRepository.save(world);
    }

    @Override
    public Iterable<World> getActiveWorlds() {
        return this.worldRepository.findAll();
    }
}
