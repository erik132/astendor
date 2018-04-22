package erik.soekov.astendor.orders.models;

import erik.soekov.astendor.warlords.model.Warlord;

import javax.persistence.*;

@Entity(name="Order")
@Table(name="orders")
public class Order {

    @EmbeddedId
    private OrderIdentity orderIdentity;
    @Column(name = "order_params")
    private String orderParams;

    @ManyToOne
    @MapsId("warlordId")
    @JoinColumn(name = "warlord_id", nullable = false)
    private Warlord warlord;

    @ManyToOne
    @JoinColumn(name = "order_type", nullable = false)
    private OrderType orderType;

    public Order() {
    }

    public Order( String orderParams, Warlord warlord, OrderIdentity orderIdentity) {
        this.orderParams = orderParams;
        this.warlord = warlord;
        this.orderIdentity = orderIdentity;
    }

    public String getOrderParams() {
        return orderParams;
    }

    public void setOrderParams(String orderParams) {
        this.orderParams = orderParams;
    }

    public Warlord getWarlord() {
        return warlord;
    }

    public void setWarlord(Warlord warlord) {
        this.warlord = warlord;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderIdentity getOrderIdentity() {
        return orderIdentity;
    }

    public void setOrderIdentity(OrderIdentity orderIdentity) {
        this.orderIdentity = orderIdentity;
    }
}
