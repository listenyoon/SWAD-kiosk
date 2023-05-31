import java.util.ArrayList;

public class Order {
    public static ArrayList<Menu> cartInfo;
    public static String orderMethod;
    public static boolean isTakeOut;

    public Order() {
    }

    public static void getCartInfo(ArrayList<Menu> cartInfoes){
        cartInfo = cartInfoes;
    }
    public static void getOrderInfo(String orderMethods, boolean isTakeOuts){
        orderMethod = orderMethods;
        isTakeOut = isTakeOuts;
        PaymentSystem.paymentInfo(orderMethod);
    }
    public static void cancelOrder(){

    }
}
