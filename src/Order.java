import java.util.ArrayList;

public class Order {
    public ArrayList<String> cartInfo;
    public String orderMethod;
    public boolean isTakeOut;
    private PaymentSystem paymentSystem;

    public Order() {
        this.paymentSystem = new PaymentSystem();
    }

    public void getCartInfo(ArrayList<String> cartInfo){
        this.cartInfo = cartInfo;
    }
    public void getOrderInfo(String orderMethod, boolean isTakeOut){
        this.orderMethod = orderMethod;
        this.isTakeOut = isTakeOut;
        paymentSystem.paymentInfo(orderMethod);
    }
    public void cancelOrder(){

    }
}
