import java.util.HashMap;

public class Order_GUI {
    public static HashMap<String, Menu> cartInfo;
    public static String orderMethod;
    public static String isTakeOut;
    private static int orderNumber = 0;

    public Order_GUI() {
    }

    // cartInfo에 넣는 용도면 setCartInfo로 이름을 고쳐야 더 좋을듯? 이런 용도가 아닌 건가????????
    public static void setCartInfo(HashMap<String, Menu> cartInfoes){
        cartInfo = cartInfoes;
    }

    public static int getOrderInfo(String orderMethods, String isTakeOuts){
        orderMethod = orderMethods;
        isTakeOut = isTakeOuts;
        orderNumber++;
        PaymentSystem_GUI.paymentInfo(orderMethod, cartInfo, orderNumber);
        return orderNumber;
    }

    public static void cancelOrder(){

    }
}
