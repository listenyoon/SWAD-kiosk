import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Front_GUI {
    public static String isTakeOut;
    public static boolean isPrintOut;
    public static String method;
    public static String panel;
    public static Map<String, Food> foodList;
    private static int count = 0;

    public Front_GUI() {
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

    public static String printMenuInfo(String foodname){
        return foodList.get(foodname).allergyInfo;
    }

    // GUI - 메뉴 선택
    public static String selectMenu(String foodname, int count, String size) {
        TimerT.getInstance().setTimer(120);
        Controller_GUI.selectMenu(foodname, count, size);

        HashMap<String, Menu> cartItems;
        cartItems = Controller_GUI.requestCartInfo();

        // 카트에 담긴 애들 출력 - 반복문에서 cash 계산 필요
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (Menu item : cartItems.values()) {
            int price = (foodList.get(item.name)).price * item.count;
            sum += price;
            sb.append("   "  + item.name);
            for (int i = 0; i < 8 - item.name.length(); i++) {
                sb.append("   ");
            }
            sb.append("₩ " + (foodList.get(item.name)).price);
            for (int i = 0; i < 20 - String.valueOf(item.price).length(); i++) {
                sb.append(" ");
            }
            sb.append(item.count);
            for (int i = 0; i < 14 - String.valueOf(item.count).length(); i++) {
                sb.append(" ");
            }
            sb.append(price + "\n");
        }
        sb.append("\n합계 : ₩ " + sum + "\n");
        return sb.toString();
    }
    
     
     // 장바구니 확인
    public static String accept() {
        Scanner in = new Scanner(System.in);
        TimerT.getInstance().setTimer(120);
        HashMap<String, Menu> cartItems;
        cartItems = Controller_GUI.requestCartInfo(); // controller의 cartInfo 요청

        // 카트에 담긴 애들 출력 - 반복문에서 cash 계산 필요
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (Menu item : cartItems.values()) {
            int price = (foodList.get(item.name)).price * item.count;
            sum += price;
            sb.append("   "  + item.name);
            for (int i = 0; i < 8 - item.name.length(); i++) {
                sb.append("   ");
            }
            sb.append("₩ " + (foodList.get(item.name)).price);
            for (int i = 0; i < 20 - String.valueOf(item.price).length(); i++) {
                sb.append(" ");
            }
            sb.append(item.count);
            for (int i = 0; i < 14 - String.valueOf(item.count).length(); i++) {
                sb.append(" ");
            }
            sb.append(price + "\n");
        }
        sb.append("\n 합계 : ₩ " + sum + "\n");
        return sb.toString();

//        System.out.print("주문을 수정하시겠습니까? : ");
//        String answer = in.nextLine();
//        if (answer.equals("y"))
//            editCartList();
//        else if (answer.equals("n"))
//            return;
    }

    public static void editCartList()
    {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("삭제하려는 메뉴를 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.nextLine();
            if (foodname.equals("n"))
                break;
            else if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            Controller_GUI.deleteMenu(foodname); // 요 안에서 Cart.deleteMenu(foodname) 해서 cartInfo의 foodname 삭제
        }

        while (true) {
            System.out.print("수정하거나 추가하려는 메뉴 이름, 수량, 사이즈를 차례대로 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.next();
            if (foodname.equals("n"))
                break;
            else if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            Controller_GUI.deleteMenu(foodname);
            int count = in.nextInt();
            String size = in.next();
            Controller_GUI.selectMenu(foodname, count, size);
        }
        accept();
    }

    public static void selectOrderInfo(String isTakeOut, String paymentMethod) {
        TimerT.getInstance().setTimer(120);

        Controller_GUI.sendOrderInfo(paymentMethod, isTakeOut);
    }

    public static void waitingForCard()
    {
        // 카드 입력받는 타이머 설정
        TimerT.getInstance().setTimer(120);
    }

    public static void waitingForBarcode()
    {
        // 카드 입력받는 타이머 설정
        TimerT.getInstance().setTimer(120);
    }
        
    public static String insertCard(String cardName) {
        TimerT.getInstance().setTimer(120);

        if (Controller_GUI.cardInfo(cardName).equals("fail")) {
            return "잔액 부족으로 결제가 실패하였습니다.";
        }
        return "성공적으로 결제되었습니다.";
    }

    public static String scanBarcode(String coupon) {
        TimerT.getInstance().setTimer(120);
        if ((Controller_GUI.barcodeInfo(coupon)).equals("fail")) {
            return "잔액 결제할 카드를 투입해 주십시오.";
        }
        return "성공적으로 결제되었습니다.";
    }

    public static String printReceipt(){
        TimerT.getInstance().waiting(120);
        StringBuilder sb = new StringBuilder();

        String receiptInfo;
        int orderNumber;

        receiptInfo = Controller_GUI.requestReceiptInfo();
        sb.append(receiptInfo);

        orderNumber = Controller_GUI.requestOrderNumber();
        sb.append("   주문 번호 : " + orderNumber);

        return sb.toString();
    }

    
}
