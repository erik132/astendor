package erik.soekov.astendor.orders.repos;

import erik.soekov.astendor.orders.models.OrderIdentity;
import erik.soekov.astendor.orders.models.OrderPrimitive;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderPrimitiveRepository extends CrudRepository<OrderPrimitive, OrderIdentity> {

    @Transactional
    @Modifying
    @Query("delete from OrderPrimitive o where o.orderIdentity.warlordId = :warlord")
    void deleteWarlordOrders(@Param("warlord") Integer warlordId);

    @Query("select o from OrderPrimitive o where o.orderIdentity.warlordId = :warlord")
    List<OrderPrimitive> allWarlordOrders(@Param("warlord") Integer warlordId);
}
