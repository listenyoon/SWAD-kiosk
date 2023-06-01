import java.util.ArrayList;

public class Order {
    public static ArrayList<Menu> cartInfo;
    public static String orderMethod;
    public static String isTakeOut;

    public Order() {
    }

    // cartInfo에 넣는 용도면 setCartInfo로 이름을 고쳐야 더 좋을듯? 이런 용도가 아닌 건가????????
    public static void setCartInfo(ArrayList<Menu> cartInfoes){
        cartInfo = cartInfoes;
    }

    public static void getOrderInfo(String orderMethods, String isTakeOuts, ArrayList<Menu> cartInfos){
        orderMethod = orderMethods;
        isTakeOut = isTakeOuts;
        cartInfo = cartInfos;
        int sum = 0;
        for (Menu item : cartInfo) {
            int price = (Controller.foodList.get(item.name)).price;
            sum += price;
            System.out.println(item.name + "   ₩ " + price);
            System.out.println("합계 : ₩ " + sum);
        }
        PaymentSystem.paymentInfo(orderMethod);
    }
    public static void cancelOrder(){

    }
}
