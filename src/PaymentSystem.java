import java.util.*;

public class PaymentSystem {
    private static String paymentMethod;          // 결제수단(카드 or 바코드)
    private static String mean;                   // 결제 정보(결제할 카드 이름 또는 할인쿠폰 이름)
    private static int orderNumber;
    private static boolean is_reprocess = false;  // 한 번 결제를 실패해서 재시도 하는 경우
    private static int remains = 0;               // 결제해야 할 잔액 (할인, 최초 결제에서 결제해야 할 금액이 깎이고 남은 금액)
    private static int sum = 0;                   // 총합 금액
    private static int discount = 0;              // 할인 금액
    private static StringBuilder receiptInfo;
    private static HashMap<String, Menu> cartItems;
    private static HashMap<String, Integer> cardRemains = new HashMap<String, Integer>() {{
        put("농협카드", 5000);                     // 각 카드의 잔액 정보
        put("신한카드", 20000);
        put("국민카드", 100000);
        put("카카오뱅크", 1000);
    }};

    public static void paymentInfo(String method, HashMap<String, Menu> cartItemss, int _orderNumber) {
        // Order에서 부르는 함수로,
        // 영수증을 만들 때 필요한 결제 수단 정보와 장바구니 리스트, 주문번호를 저장하고, 선택한 결제 수단 입력을 기다리는 함수 호출.
        paymentMethod = method;
        orderNumber = _orderNumber;
        cartItems = cartItemss;
        if (paymentMethod.equals("카드"))
            Front.waitingForCard();
        else if (paymentMethod.equals("바코드"))
            Front.waitingForBarcode();
    }
    
    public static String cardInfo(String cardName) {
        // Controller에서 호출되는 함수로, 어떤 카드로 결제할 것인지 카드 이름을 저장하고, 결제 처리를 하기 위한 processPay를 부른다.
        // 성공할 경우 영수증 정보, 실패할 경우 실패했다는 문자열을 받고, 반환한다.
        paymentMethod = "카드";
        mean = cardName;
        String receiptInfo = processPay();
        return receiptInfo;
    }

    public static String barcodeInfo(String coupon) {
        // cardInfo와 동작 방식이 유사하다. 사용할 쿠폰 이름을 저장하고, 결제 처리로 들어간다.
        paymentMethod = "바코드";
        mean = coupon;
        String receipt = processPay();
        return receipt;
    }
    
    private static String processPay(){
        receiptInfo = new StringBuilder();
        // 처음 결제를 시도할 때에만 결제할 금액을 계산한다. 두번째 결제를 할 경우 할인이 초기화되지 않게 하기 위해서이다.
        if (!is_reprocess) {
            for (Menu item : cartItems.values()) {
                int price = (Controller.foodList.get(item.name)).price;
                sum += price * item.count;
            }
        }

        // 각 할인쿠폰에 맞는 할인 금액을 계산하고, 카드가 들어온 경우 cardRemains 속성에서 각 카드 별 잔액을 조회하여 결제할 금액을 계산한다. 
        System.out.println("processing...");
        if (mean.equals("2000원 할인쿠폰"))
            discount = 2000;
        else if (mean.equals("10% 할인쿠폰"))
            discount = Integer.parseInt(String.valueOf(Math.round(sum * 0.1)));
        else if (mean.equals("20% 할인쿠폰"))
            discount = Integer.parseInt(String.valueOf(Math.round(sum * 0.2)));
        else if (mean.equals("30% 할인쿠폰"))
            discount = Integer.parseInt(String.valueOf(Math.round(sum * 0.3)));
        remains = sum - discount;
        if (paymentMethod.equals("카드")) {
            remains -= cardRemains.get(mean);
        }
        if (remains > 0) {
            // 결제 실패 (잔액 부족) 의 경우, fail 문자열을 돌려주어 결제 재시도가 필요함을 Controller 및 Front에게 알려주고, 다시 결제수단을 입력받게 함.
            is_reprocess = true;
            return "fail";
        }
        is_reprocess = false;
        makeReceipt();  // 영수증을 만들어주는 함수
        return receiptInfo.toString();
    }

    private static void makeReceipt() {
        int sum = 0;
        receiptInfo
            .append("\n                  [ 영수증 ]                  \n")
            .append("                  주문 번호 " + orderNumber + "               \n")
            .append("----------------------------------------------\n")
            .append(" 상품명            단가      수량      금액 \n")
            .append("----------------------------------------------\n");
            for (Menu item : cartItems.values()) {
                int price = (Controller.foodList.get(item.name)).price;
                sum += price * item.count;

                receiptInfo.append(" " + item.name + "        ");
                for (int i = 0; i < 5 - item.name.length(); i++) {
                    receiptInfo.append("  ");
                }
                receiptInfo.append(price + " ");
                for (int i = 0; i < 10 - String.valueOf(price).length(); i++) {
                    receiptInfo.append(" ");
                }
                receiptInfo.append(item.count);
                for (int i = 0; i < 10 - String.valueOf(item.count).length(); i++) {
                    receiptInfo.append(" ");
                }
                receiptInfo.append((price * item.count) + " \n");

                receiptInfo.append("   ㄴ 사이즈: " + item.size + " \n");
        }

        receiptInfo.append("==============================================\n");
        receiptInfo.append("합계 : " + sum + "\n");
        receiptInfo.append("결제수단 : " + paymentMethod + "(" + mean + ")" + "\n");
    }
}