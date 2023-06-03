import java.util.*;

public class Controller {
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
    
    public Controller() {
    }
    
    public static Map<String, Food> startOrder() {
        // 주문시작 메세지 출력
        // foodList foodName 출력
        return foodList;
    }
    
    public static void selectMenu(String foodname, int count, String size){
        Menu newMenu = new Menu(foodname, count, size);
        Cart.addToCart(newMenu);
        //return cartInfo;
    }
    
    public static ArrayList<Menu> requestCartInfo(){
        ArrayList<Menu> cartInfo;
        cartInfo = Cart.requestCartInfo();
        return cartInfo;
    }
    
    public static void sendOrderInfo(String method, String isTakeOut) {
        ArrayList<Menu> cartInfo;
        cartInfo = Cart.requestCartInfo();
        orderNumber = Order.getOrderInfo(method, isTakeOut, cartInfo);
    }

    public static void cardInfo(String cardName) {
        receiptInfo = PaymentSystem.cardInfo(cardName);
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
