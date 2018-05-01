package erik.soekov.astendor.worlds.services;

import erik.soekov.astendor.worlds.dto.WorldDTO;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.models.WorldPrimitive;

import java.util.List;

public interface WorldService {

    public World getWorld(Integer id);
    public WorldPrimitive getWorldPrimitive(Integer id);
    public void IncreaseWorldTurn(Integer worldId);
    public Iterable<World> getActiveWorlds();
    public void createWorld(WorldDTO worldDTO);
}
