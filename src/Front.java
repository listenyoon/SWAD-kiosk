import java.util.*;

public class Front {
    public static boolean isTakeOut;
    public static boolean isPrintOut;
    public static String method;
    public static String receiptInfo;
    public static String panel;
    public static ArrayList<Menu> cartItems;
    public static Map<String, Food> foodList;

    public Front() {
        System.out.println("환영합니다.");
    }

    public static void initScreen(){
        System.out.println("init");
    }

    public static boolean touchScreen(){
        try {
            foodList = Controller.startOrder();
            //여기서 출력???????

            TimerT.getInstance().setTimer(30);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }
    public static void getMenuInfo(){

    }
    //여기서 인자를 넣어주는게 아니라 여기서 컨트롤러로 부를때 인자를 넣어줘야될듯?
    public static void selectMenu(Menu menu){
        cartItems = Controller.selectMenu(menu);
        //반복문에서 cash 계산 필요
        for (Menu item:cartItems) {
            System.out.println(item.name);
        }
    }

     //흠....
     public static void displayCartList(){

     }

    // 장바구니 확인
     public static void accept() {
         Controller.requestCartInfo(); // controller의 cartInfo 요청
     }

     public static void insertCard(String cardInfo){
        PaymentSystem.cardInfo(cardInfo);
     }

     public static void selectReceipt(boolean isPrintOut){
        if(isPrintOut) receiptInfo = Controller.requestReceiptInfo();
     }
}
