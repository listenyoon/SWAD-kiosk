import java.util.*;

public class PaymentSystem {
    private static String paymentMethod;
    private static String mean;
    private static int orderNumber;
    private static boolean is_reprocess = false;
    private static int remains = 0;
    private static int sum = 0;
    private static int discount = 0;
    private static StringBuilder receiptInfo;
    private static HashMap<String, Menu> cartItems;
    private static HashMap<String, Integer> cardRemains = new HashMap<String, Integer>() {{
        put("농협카드", 5000);
        put("신한카드", 20000);
        put("국민카드", 100000);
        put("카카오뱅크", 1000);
    }};

    public static void paymentInfo(String method, HashMap<String, Menu> cartItemss, int _orderNumber) {
        paymentMethod = method;
        orderNumber = _orderNumber;
        cartItems = cartItemss;
        Front.waitingForCard();
    }
    
    public static String cardInfo(String cardInfos) {
        paymentMethod = "카드";
        mean = cardInfos;
        String receipt = processPay();
        return receipt;
    }

    public static String barcodeInfo(String coupon) {
        paymentMethod = "바코드";
        mean = coupon;
        String receipt = processPay();
        return receipt;
    }
    
    private static String processPay(){
        receiptInfo = new StringBuilder();
        if (!is_reprocess) {
            for (Menu item : cartItems.values()) {
                int price = (Controller.foodList.get(item.name)).price;
                sum += price * item.count;
            }
        }

        // 결제 처리
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
            // 결제 실패 (잔액 부족)
            System.out.println(remains);
            is_reprocess = true;
            return "fail";
        }
        is_reprocess = false;
        makeReceipt();
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