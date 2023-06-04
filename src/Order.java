import java.util.*;

public class Order {
    public static HashMap<String, Menu> cartInfo;
    public static String orderMethod;
    public static String isTakeOut;
    private static int orderNumber = 0;
    
    public static void setCartInfo(HashMap<String, Menu> cartInfoes){
        // Cart에서 인자로 넘어온 cartInfoes를 Order의 속성에 넣어줌.
        cartInfo = cartInfoes;
    }

    public static int getOrderInfo(String orderMethods, String isTakeOuts){
        // 주문이 확정되면 호출되는 함수로, 사용자가 선택할 결제수단, 포장여부를 Order의 속성에 반영한다.
        // 이 때 주문번호를 저장한다. 한 번 주문이 들어올 때마다 주문번호가 1씩 늘어나서 현재 주문번호가 된다.
        // 이 정보들로 결제 및 영수증을 발급하기 위해 PaymentSystem으로 넘겨주고, 주문번호는 영수증을 출력하든 출력하지 않든 필요하므로 리턴값으로 돌려준다.
        orderMethod = orderMethods;
        isTakeOut = isTakeOuts;
        orderNumber++;
        PaymentSystem.paymentInfo(orderMethod, cartInfo, orderNumber);
        return orderNumber;
    }

}


