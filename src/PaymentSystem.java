import java.util.ArrayList;

public class PaymentSystem {
    private static String paymentInfo;
    private static String cardInfo;
    private static StringBuilder receiptInfo;
    private static int price;
    private static ArrayList<Menu> cartItems;

    public static void paymentInfo(String method, ArrayList<Menu> cartItemss, int sums) {
        paymentInfo = method;
        price = sums;
        cartItems = cartItemss;
        Front.waitingForCard();
    }
    
    public static String cardInfo(String cardInfos) {
        cardInfo = cardInfos;
        String receipt = processPay();
        return receipt;
    }
    
    private static String processPay(){
        System.out.println("processing...");
        receiptInfo = new StringBuilder();
        receiptInfo.append("[ 영수증 ]\n");
        
        int sum = 0;
        for (Menu item : cartItems) {
            int price = (Controller.foodList.get(item.name)).price * item.count;;
            sum += price;
            receiptInfo.append(item.name + "   ₩ " + price + "\n");
        }

        receiptInfo.append("합계 : " + sum);

        receiptInfo.append(cardInfo + "\n")
            .append(cardInfo);
        return receiptInfo.toString();
    }
}
