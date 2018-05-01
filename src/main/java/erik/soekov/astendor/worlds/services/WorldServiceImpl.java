package erik.soekov.astendor.worlds.services;

import erik.soekov.astendor.maps.models.MapTile;
import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.maps.models.WorldMapPrimitive;
import erik.soekov.astendor.maps.services.MapService;
import erik.soekov.astendor.worlds.dto.WorldDTO;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.models.WorldPrimitive;
import erik.soekov.astendor.worlds.repos.WorldPrimitiveRepository;
import erik.soekov.astendor.worlds.repos.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WorldServiceImpl implements WorldService{

    @Autowired
    private WorldRepository worldRepository;

    @Autowired
    private MapService mapService;

    @Autowired
    private WorldPrimitiveRepository worldPrimitiveRepository;

    @Override
    public World getWorld(Integer id) {
        return this.worldRepository.findById(id).get();
    }

    @Override
    public WorldPrimitive getWorldPrimitive(Integer id) {
        return this.worldPrimitiveRepository.findById(id).get();
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

    @Override
    public void createWorld(WorldDTO worldDTO) {
        Set<MapTile> tiles = this.mapService.getMap(worldDTO.getMapId()).getTiles();
        WorldMapPrimitive minMap = this.mapService.getMinMap(worldDTO.getMapId());

        World newWorld = new World(worldDTO, minMap,tiles);
        this.worldRepository.save(newWorld);
    }
}
