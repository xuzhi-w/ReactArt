package esb;

public class ShipFilter {
    public boolean filter(Order order){
        if(order.getAmount() <= 175.00){
            return true;
        }else{
            return false;
        }
    }
}
