package erik.soekov.astendor.orders.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class OrderIdentity implements Serializable {

    @NotNull
    @Column(name = "warlord_id")
    private Integer warlordId;
    @NotNull
    @Column(name = "order_nr")
    private Integer orderNr;

    public OrderIdentity() {
    }

    public OrderIdentity(@NotNull Integer warlordId, @NotNull Integer orderNr) {
        this.warlordId = warlordId;
        this.orderNr = orderNr;
    }

    public Integer getWarlordId() {
        return warlordId;
    }

    public void setWarlordId(Integer warlordId) {
        this.warlordId = warlordId;
    }

    public Integer getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(Integer orderNr) {
        this.orderNr = orderNr;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        OrderIdentity target = (OrderIdentity)obj;

        if(!this.warlordId.equals(target.warlordId)) return false;
        return this.orderNr.equals(target.orderNr);
    }

    //no idea why I need this
    @Override
    public int hashCode() {
        int result = warlordId.hashCode();
        result = 31 * result + orderNr.hashCode();
        return result;
    }
}
