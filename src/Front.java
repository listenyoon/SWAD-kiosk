import java.util.ArrayList;

public class Front {
    public boolean isTakeOut;
    public boolean isPrintOut;
    public String method;
    public String receiptInfo;
    private Controller controller;
    private PaymentSystem paymentSystem;
    public String panel;
    public ArrayList<String> givenMenu, cartItems;
    TimerT timerT;

    public Front() {
        controller = new Controller();
        timerT = new TimerT();
        System.out.println("환영합니다.");
    }

    public void initScreen(){
        System.out.println("init");
    }

    public void touchScreen(){
        givenMenu = controller.startOrder();
        System.out.println("menus: ");
        timerT.setTimer(30);
    }
     public void getMenuInfo(){

     }
     //여기서 인자를 넣어주는게 아니라 여기서 컨트롤러로 부를때 인자를 넣어줘야될듯?
     public void selectMenu(String menu){
        cartItems = controller.selectMenu(menu);
         for (String item:cartItems) {
             System.out.println(item);
         }
     }

     //흠....
     public void displayCartList(){

     }

     public void accept(){
       cartItems = controller.requestCartInfo();
     }
     public void insertCard(String cardInfo){
        paymentSystem.cardInfo(cardInfo);
     }

     public void selectReceipt(boolean isPrintOut){
        if(isPrintOut) receiptInfo = controller.requestReceiptInfo();
     }
}
