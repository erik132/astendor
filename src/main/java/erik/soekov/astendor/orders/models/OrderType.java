package erik.soekov.astendor.orders.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_types")
public class OrderType {

    @Id
    private Integer id;
    private String name;
    private String orderClass;

    public OrderType() {
    }

    public OrderType(Integer id, String name, String orderClass) {
        this.id = id;
        this.name = name;
        this.orderClass = orderClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderClass() {
        return orderClass;
    }

    public void setOrderClass(String orderClass) {
        this.orderClass = orderClass;
    }
}
