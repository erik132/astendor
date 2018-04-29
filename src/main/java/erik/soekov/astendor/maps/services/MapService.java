package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.maps.models.WorldMapPrimitive;

import java.util.List;

public interface MapService {

    public WorldMap getMap(Integer id);
    public List<WorldMapPrimitive> getPrimitiveMaps();
}
