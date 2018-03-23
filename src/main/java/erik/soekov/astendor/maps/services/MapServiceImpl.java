package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.Map;
import erik.soekov.astendor.maps.repos.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapRepository mapRepository;

    @Override
    public Map getMap(Integer id) {
        return mapRepository.findById(id).get();
    }
}
