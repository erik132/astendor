package erik.soekov.astendor.orders.models;

import erik.soekov.astendor.warlords.model.Warlord;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private Integer id;
    private String orderParams;

    @ManyToOne
    @JoinColumn(name = "warlord_id", nullable = false)
    private Warlord warlord;

    @ManyToOne
    @JoinColumn(name = "order_type", nullable = false)
    private OrderType orderType;

    public Order() {
    }

    public Order(Integer id, String orderParams, Warlord warlord, OrderType orderType) {
        this.id = id;
        this.orderParams = orderParams;
        this.warlord = warlord;
        this.orderType = orderType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
