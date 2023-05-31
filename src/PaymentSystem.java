public class PaymentSystem {
    private String paymentInfo;
    private String cardInfo;

    public void cardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public void paymentInfo(String info){
        this.paymentInfo = info;
    }
    private boolean processPay(){
        System.out.println("processing...");
        return true;
    }
}
