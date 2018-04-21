package erik.soekov.astendor.orders.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="OrderPrimitive")
@Table(name="orders")
public class OrderPrimitive {

    @EmbeddedId
    private OrderIdentity orderIdentity;
    @Column(name = "order_type")
    private Integer orderType;
    private String orderParams;

    public OrderPrimitive() {
    }

    public OrderPrimitive(Integer warlordId, Integer orderNr, Integer orderType, String orderParams) {
        this.orderIdentity = new OrderIdentity(warlordId, orderNr);
        this.orderType = orderType;
        this.orderParams = orderParams;
    }

    public OrderIdentity getOrderIdentity() {
        return orderIdentity;
    }

    public void setOrderIdentity(OrderIdentity orderIdentity) {
        this.orderIdentity = orderIdentity;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderParams() {
        return orderParams;
    }

    public void setOrderParams(String orderParams) {
        this.orderParams = orderParams;
    }
}
