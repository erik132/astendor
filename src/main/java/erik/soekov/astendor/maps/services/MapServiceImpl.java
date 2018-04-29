package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.maps.models.WorldMapPrimitive;
import erik.soekov.astendor.maps.repos.MapPrimitiveRepository;
import erik.soekov.astendor.maps.repos.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapPrimitiveRepository mapPrimitiveRepository;

    @Override
    public WorldMap getMap(Integer id) {
        return mapRepository.findById(id).get();
    }

    @Override
    public List<WorldMapPrimitive> getPrimitiveMaps() {
        List<WorldMapPrimitive> results = new ArrayList<>();
        this.mapPrimitiveRepository.findAll().forEach(results::add);

        return results;
    }

    @Override
    public WorldMapPrimitive getMinMap(Integer id) {
        return this.mapPrimitiveRepository.findById(id).get();
    }
}
