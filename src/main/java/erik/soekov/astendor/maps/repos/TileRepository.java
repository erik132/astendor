package erik.soekov.astendor.maps.repos;

import erik.soekov.astendor.maps.models.MapTile;
import org.springframework.data.repository.CrudRepository;

public interface TileRepository extends CrudRepository<MapTile, Integer>{
}
