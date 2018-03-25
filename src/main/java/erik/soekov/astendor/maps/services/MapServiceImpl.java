package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.maps.repos.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapRepository mapRepository;

    @Override
    public WorldMap getMap(Integer id) {
        return mapRepository.findById(id).get();
    }
}
