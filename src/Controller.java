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
    
    public static Map<String, Food> startOrder() {
        // Front에게 메뉴로 제공될 food 정보들을 리턴해줌.
        return foodList;
    }
    
    public static void selectMenu(String foodname, int count, String size) {
        // 사용자가 선택한 메뉴 정보를 토대로 Menu 객체를 만들고 선택된 메뉴를 Cart에 넘겨줌.
        Menu newMenu = new Menu(foodname, count, size);
        Cart.addToCart(foodname, newMenu);
    }
    
    public static void deleteMenu(String foodname) {
        // Cart에 담긴 리스트에서 해당 메뉴를 삭제함.
        Cart.deleteMenu(foodname);
    }

    public static HashMap<String, Menu> requestCartInfo(){
        // 컨트롤러에서 프론트로 cartInfo를 출력해주기 위해 Cart에게 장바구니 리스트를 요청해서 임시로 변수에 저장한다음, 프론트로 넘겨줌
        HashMap<String, Menu> cartInfo;
        cartInfo = Cart.requestCartInfo();
        return cartInfo;
    }
    
    public static void sendOrderInfo(String orderMethod, String isTakeOut) {
        // 유저가 주문하기 버튼을 누르고 선택한 결제 방법과 포장여부를 Order에게 보냄.
        orderNumber = Order.getOrderInfo(orderMethod, isTakeOut);
    }

    public static String cardInfo(String cardName) {
        // 결제 방법으로 카드를 선택한 경우, PaymentSystem에게 어떤 카드로 결제할 건지 알려주고, 영수증 정보를 받음.
        // 결제가 실패할 경우, 영수증 정보 대신 실패했다는 정보를 받음.
        receiptInfo = PaymentSystem.cardInfo(cardName);
        return receiptInfo;
    }
    
    public static String barcodeInfo(String coupon) {
        // cardInfo()와 유사하게, 선택한 바코드 쿠폰을 PaymentSystem으로 알려주고, 이 정보가 반영된 영수증 정보를 받음.
        // 결제가 실패할 경우, 영수증 정보 대신 실패했다는 정보를 받음.
        receiptInfo = PaymentSystem.barcodeInfo(coupon);
        return receiptInfo;
    }

    public static String requestReceiptInfo(){
        // 사용자가 영수증 출력을 선택할 경우 영수증 정보를 전달해줌.
        return receiptInfo;
    }
    
    public static int requestOrderNumber() {
        // 영수증 출력을 원하지 않는 경우 주문 번호만 출력하기 위해 주문번호를 리턴해줌.
        return orderNumber;
    }

    public static void endOrder() {
        // 프로그램 종료?
        // 초기화면이 뭐지..???
    }
}
