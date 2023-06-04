import java.util.HashMap;
import java.util.Map;

public class Controller_GUI {
    public static Map<String, Food> foodList = new HashMap<String, Food>() {{
        put("불고기버거", new Food("불고기버거", 4000, "밀, 대두, 소고기"));
        put("새우버거", new Food("새우버거", 4500, "밀, 대두, 새우"));
        put("치킨버거", new Food("치킨버거", 4500, "밀, 대두, 닭고기"));
        put("감자튀김", new Food("감자튀김", 2000, "없음"));
        put("콜라", new Food("콜라", 2000, "없음"));
        put("사이다", new Food("사이다", 2000, "없음"));
    }};
    private static int orderNumber;
    private static String receiptInfo;

    public Controller_GUI() {
    }
    
    public static Map<String, Food> startOrder() {
        // 주문시작 메세지 출력
        // foodList foodName 출력
        return foodList;
    }
    
    public static void selectMenu(String foodname, int count, String size){
        Menu newMenu = new Menu(foodname, count, size);
        Cart_GUI.addToCart(foodname, newMenu);
        //return cartInfo;
    }
    
    public static void deleteMenu(String foodname) {
        Cart_GUI.deleteMenu(foodname);
    }

    public static HashMap<String, Menu> requestCartInfo(){
        HashMap<String, Menu> cartInfo;
        cartInfo = Cart_GUI.requestCartInfo();
        return cartInfo;
    }
    
    public static void sendOrderInfo(String orderMethod, String isTakeOut) {
        orderNumber = Order_GUI.getOrderInfo(orderMethod, isTakeOut);
    }

    public static String cardInfo(String cardName) {
        receiptInfo = PaymentSystem_GUI.cardInfo(cardName);
        return receiptInfo;
    }
    
    public static String barcodeInfo(String coupon) {
        receiptInfo = PaymentSystem_GUI.barcodeInfo(coupon);
        return receiptInfo;
    }

    public static String requestReceiptInfo(){
        return receiptInfo;
    }
    
    public static int requestOrderNumber() {
        return orderNumber;
    }

    public static void endOrder() {
        // 프로그램 종료?
        // 초기화면이 뭐지..???
    }
}
