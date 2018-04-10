package erik.soekov.astendor.orders.repos;

import erik.soekov.astendor.orders.models.Order;
import erik.soekov.astendor.orders.models.OrderIdentity;
import erik.soekov.astendor.warlords.model.Warlord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order, OrderIdentity> {

    @Query("SELECT o FROM Order o WHERE o.warlord = :warlord")
    List<Order> getWarlordOrders(@Param("warlord") Warlord warlord);
}
