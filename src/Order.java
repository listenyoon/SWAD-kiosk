import java.util.ArrayList;

public class Order {
    public static ArrayList<Menu> cartInfo;
    public static String orderMethod;
    public static String isTakeOut;
    private static int orderNumber = 0;

    public Order() {
    }

    // cartInfo에 넣는 용도면 setCartInfo로 이름을 고쳐야 더 좋을듯? 이런 용도가 아닌 건가????????
    public static void setCartInfo(ArrayList<Menu> cartInfoes){
        cartInfo = cartInfoes;
    }

    public static int getOrderInfo(String orderMethods, String isTakeOuts, ArrayList<Menu> cartInfos){
        orderMethod = orderMethods;
        isTakeOut = isTakeOuts;
        cartInfo = cartInfos;
        orderNumber++;
        PaymentSystem.paymentInfo(orderMethod, cartInfo, orderNumber);
        return orderNumber;
    }

    public static void cancelOrder(){

    }
}
