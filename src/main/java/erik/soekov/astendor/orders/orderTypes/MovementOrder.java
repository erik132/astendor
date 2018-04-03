package erik.soekov.astendor.orders.orderTypes;

public class MovementOrder implements OrderFrame{

    public MovementOrder() {
    }

    @Override
    public void setParams(String params) {
        System.out.println("order params " + params);
    }

    @Override
    public void executeOrder() {
        System.out.println("Executing movement order");
    }
}
