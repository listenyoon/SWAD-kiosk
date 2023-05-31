import java.util.*;

public class Controller {
    private static ArrayList<Menu> cartInfo;
    public static Map<String, Food> foodList = new HashMap<String, Food>() {{
            put("불고기버거", new Food("불고기버거", 4000, "밀, 대두, 소고기"));
            put("새우버거", new Food("새우버거", 4500, "밀, 대두, 새우"));
            put("치킨버거", new Food("치킨버거", 4500, "밀, 대두, 닭고기"));
            put("감자튀김", new Food("감자튀김", 2000, "없음"));
            put("콜라", new Food("콜라", 1500, "없음"));
            put("사이다", new Food("사이다", 1500, "없음"));
    }};

    private static String receiptInfo;
    
    public Controller() {
    }

    public static Map<String, Food> startOrder() {
        // 주문시작 메세지 출력
        // foodList foodName 출력
        return foodList;
    }

    public static ArrayList<Menu> selectMenu(Menu menu){
        cartInfo = Cart.addToCart(menu);
        return cartInfo;
    }

    public static ArrayList<Menu> requestCartInfo(){
        Cart.confirmCartInfo(cartInfo);
        return cartInfo;
    }

    public static void sendOrderInfo(String method, boolean isTakeOut){
        Order.getOrderInfo(method, isTakeOut);
    }

    public static String requestReceiptInfo(){
        return receiptInfo;
    }

    public static String endOrder() {
        return "end";
    }
}
