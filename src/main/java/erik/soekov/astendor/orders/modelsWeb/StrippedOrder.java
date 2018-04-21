package erik.soekov.astendor.orders.modelsWeb;

public class StrippedOrder {

    private String orderType;
    private String orderParams;


    public StrippedOrder() {
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
