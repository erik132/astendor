package erik.soekov.astendor.items.repos;

import erik.soekov.astendor.items.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
