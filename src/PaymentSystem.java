import java.util.ArrayList;

public class PaymentSystem {
    private static String paymentMethod;
    private static String cardName;
    private static StringBuilder receiptInfo;
    private static int sum;
    private static ArrayList<Menu> cartItems;

    public static void paymentInfo(String method, ArrayList<Menu> cartItemss, int sums) {
        paymentMethod = method;
        sum = sums;
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
            .append("\n                   [ 영수증 ]                   \n")
            .append("----------------------------------------------\n")
            .append(" 상품명            단가      수량      금액 \n")
            .append("----------------------------------------------\n");
        for (Menu item : cartItems) {
            int price = (Controller.foodList.get(item.name)).price;

            receiptInfo.append(" " + item.name);
            for (int i = 0; i < 13 - item.name.length(); i++) {
                receiptInfo.append(" ");
            }
            receiptInfo.append(price);
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
