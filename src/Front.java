import java.util.*;

public class Front {
    public static boolean isTakeOut;
    public static boolean isPrintOut;
    public static String method;
    public static String receiptInfo;
    public static String panel;
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
    public static boolean selectMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("메뉴를 입력하세요! :");
        String foodname = in.nextLine();
        
        if (!foodname.equals("불고기버거")
        && !foodname.equals("새우버거")
        && !foodname.equals("치킨버거")
        && !foodname.equals("감자튀김")
        && !foodname.equals("콜라")
        && !foodname.equals("사이다")) {
            return (true);
        }
        
        System.out.println("옵션을 입력하세요! : ");
        String option = in.nextLine();
        System.out.println("사이즈를 입력하세요 : ");
        String size = in.nextLine();
        
        Menu newMenu = new Menu(foodname, option, size);
        // 1) 여기에 옵션, 사이즈 등 인자를 넣어서 selectMenu()안에 new Menu 만들어주고 리스트 추가 // 이걸로 하는 것 아니여??
        // 2) new Menu 미리 만들어놓고 Controller.selectMenu() 내부에서는 리스트에 추가만 
        Controller.selectMenu(newMenu);
        
        ArrayList<Menu> cartItems;
        cartItems = Controller.requestCartInfo();

        // 카트에 담긴 애들 출력 - 반복문에서 cash 계산 필요
        System.out.println("[ 장바구니 목록 ]");
        int sum = 0;
        for (Menu item : cartItems) {
            int price = (foodList.get(item.name)).price;
            sum += price;
            System.out.println(item.name + "   ₩ " + price);
            System.out.println("합계 : ₩ " + sum);
        }
        
        System.out.println("메뉴 선택을 완료하시겠습니까? (y/n)");
        String answer = in.nextLine();
        if (answer.equals("y")) {
            System.out.println("카트 정보 보내줘잉");
            return (false);
        }
        return (true);
    }
    
    //흠....
    public static void displayCartList(){
        
     }
     
     // 장바구니 확인
     public static void accept() {
        ArrayList<Menu> cartItems;
        cartItems = Controller.requestCartInfo(); // controller의 cartInfo 요청
         
        System.out.println("[ 주문 내역 ]");
        int sum = 0;
        for (Menu item : cartItems) {
            int price = (foodList.get(item.name)).price;
            sum += price;
            System.out.println(item.name + "   ₩ " + price);
            System.out.println("합계 : ₩ " + sum);
            }
        }
        
        public static void insertCard(String cardInfo){
            PaymentSystem.cardInfo(cardInfo);
        }

     public static void selectReceipt(boolean isPrintOut){
        if(isPrintOut) receiptInfo = Controller.requestReceiptInfo();
     }
}
