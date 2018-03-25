package erik.soekov.astendor.maps.repos;

import erik.soekov.astendor.maps.models.WorldMap;
import org.springframework.data.repository.CrudRepository;

public interface MapRepository extends CrudRepository<WorldMap, Integer>{
}
