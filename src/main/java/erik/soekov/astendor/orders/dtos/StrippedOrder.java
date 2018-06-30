package erik.soekov.astendor.orders.dtos;

import erik.soekov.astendor.orders.models.Order;

public class StrippedOrder {

    private String orderType;
    private String orderParams;


    public StrippedOrder() {
    }

    public StrippedOrder(String orderType, String orderParams) {
        this.orderType = orderType;
        this.orderParams = orderParams;
    }

    public String getOrderParams() {
        return orderParams;
    }

    public void setOrderParams(String orderParams) {
        this.orderParams = orderParams;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return this.orderType + " : " + this.orderParams;
    }
}
