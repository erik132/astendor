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
    private String orderBean;

    public OrderType() {
    }

    public OrderType(Integer id, String name, String orderBean) {
        this.id = id;
        this.name = name;
        this.orderBean = orderBean;
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

    public String getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(String orderBean) {
        this.orderBean = orderBean;
    }
}
