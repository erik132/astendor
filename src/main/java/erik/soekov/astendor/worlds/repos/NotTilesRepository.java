package erik.soekov.astendor.worlds.repos;

import erik.soekov.astendor.worlds.models.WorldNoTiles;
import org.springframework.data.repository.CrudRepository;

public interface NotTilesRepository extends CrudRepository<WorldNoTiles, Integer> {
}
