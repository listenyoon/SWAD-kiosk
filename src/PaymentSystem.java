import java.util.ArrayList;

public class PaymentSystem {
    private static String paymentMethod;
    private static String cardName;
    private static int orderNumber;
    private static StringBuilder receiptInfo;
    private static ArrayList<Menu> cartItems;

    public static void paymentInfo(String method, ArrayList<Menu> cartItemss, int _orderNumber) {
        paymentMethod = method;
        orderNumber = _orderNumber;
        cartItems = cartItemss;
        Front.waitingForCard();
    }
    
    public static String cardInfo(String cardInfos) {
        cardName = cardInfos;
        String receipt = processPay();
        return receipt;
    }
    
    private static String processPay(){
        System.out.println("processing...");
        receiptInfo = new StringBuilder();
        
        
        receiptInfo
            .append("\n                  [ 영수증 ]                  \n")
            .append("                  주문 번호 " + orderNumber + "               \n")
            .append("----------------------------------------------\n")
            .append(" 상품명            단가      수량      금액 \n")
            .append("----------------------------------------------\n");
            int sum = 0;
            for (Menu item : cartItems) {
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
        receiptInfo.append("결제수단 : " + paymentMethod + "(" + cardName + ")" + "\n");
        
        return receiptInfo.toString();
    }
}
