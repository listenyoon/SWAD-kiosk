import java.util.ArrayList;

public class Order {
    public static ArrayList<Menu> cartInfo;
    public static String orderMethod;
    public static boolean isTakeOut;

    public Order() {
    }

    // cartInfo에 넣는 용도면 setCartInfo로 이름을 고쳐야 더 좋을듯? 이런 용도가 아닌 건가????????
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
