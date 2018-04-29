package erik.soekov.astendor.maps.repos;

import erik.soekov.astendor.maps.models.WorldMapPrimitive;
import org.springframework.data.repository.CrudRepository;

public interface MapPrimitiveRepository extends CrudRepository<WorldMapPrimitive, Integer> {
}
