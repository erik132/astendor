package erik.soekov.astendor.orders.repos;

import erik.soekov.astendor.orders.models.OrderType;
import org.springframework.data.repository.CrudRepository;

public interface OrderTypeRepository extends CrudRepository<OrderType, Integer> {
}
