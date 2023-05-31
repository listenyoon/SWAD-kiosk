public class PaymentSystem {
    private static String paymentInfo;
    private static String cardInfo;
    private static String receiptInfo;

    public static void paymentInfo(String infos) {
        paymentInfo = infos;
    }
    
    public static void cardInfo(String cardInfos) {
        cardInfo = cardInfos;
        processPay();
    }
    
    private static String processPay(){
        System.out.println("processing...");
        receiptInfo = paymentInfo + cardInfo;
        return receiptInfo;
    }
}
