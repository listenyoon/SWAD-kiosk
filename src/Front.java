import java.util.*;

public class Front {
    public static String isTakeOut;
    public static boolean isPrintOut;
    public static String method;
    public static String panel;
    public static Map<String, Food> foodList;
    private static int count = 0;
    
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
    public static void selectMenu() {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("메뉴 이름을 입력하세요! : ");
            String foodname = in.nextLine();
            
            if (!foodname.equals("불고기버거")
            && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거")
            && !foodname.equals("감자튀김")
            && !foodname.equals("콜라")
            && !foodname.equals("사이다")) {
                //in.close();
                continue;
            }
            
            System.out.print("수량을 입력하세요! : ");
            int count = Integer.parseInt(in.nextLine());
            System.out.print("사이즈를 입력하세요 : ");
            String size = in.nextLine();
    
            // 1) 여기에 옵션, 사이즈 등 인자를 넣어서 selectMenu()안에 new Menu 만들어주고 리스트 추가 // 이걸로 하는 것 아니여??
            // 2) new Menu 미리 만들어놓고 Controller.selectMenu() 내부에서는 리스트에 추가만 
            Controller.selectMenu(foodname, count, size);
            
            HashMap<String, Menu> cartItems;
            cartItems = Controller.requestCartInfo();
    
            // 카트에 담긴 애들 출력 - 반복문에서 cash 계산 필요
            System.out.println("[ 장바구니 목록 ]");
            int sum = 0;
            for (Menu item : cartItems.values()) {
                int price = (foodList.get(item.name)).price * item.count;
                sum += price;
                System.out.println(item.name + "   ₩ " + price);
            }
            System.out.println("합계 : ₩ " + sum);
            
            System.out.print("메뉴 선택을 완료하시겠습니까? (y/n) : ");
            String answer = in.nextLine();
            if (answer.equals("y")) {
                // in.close();
                break;
            }
            // in.close();
            continue;
        }
    }
    
     
     // 장바구니 확인
    public static void accept() {
        Scanner in = new Scanner(System.in);
        TimerT.getInstance().setTimer(20);
        HashMap<String, Menu> cartItems;
        cartItems = Controller.requestCartInfo(); // controller의 cartInfo 요청

        System.out.println("[ 주문 내역 ]");
        int sum = 0;
        for (Menu item : cartItems.values()) {
            int price = (foodList.get(item.name)).price * item.count;
            sum += price;
            System.out.println(item.name + "   ₩ " + price);
        }
        System.out.println("합계 : ₩ " + sum);

        System.out.print("주문을 수정하시겠습니까? : ");
        String answer = in.nextLine();
        if (answer.equals("y"))
            editCartList();
        else if (answer.equals("n"))
            return;
    }

    public static void editCartList()
    {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("삭제하려는 메뉴를 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.nextLine();
            if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            if (foodname.equals("n"))
                break;
            // Controller.deleteMenu(foodname); // 요 안에서 Cart.deleteMenu(foodname) 해서 cartInfo의 foodname 삭제
        }

        while (true) {
            System.out.print("수정하려는 메뉴 이름, 수량, 사이즈를 차례대로 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.next();
            if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            if (foodname.equals("n"))
                break;
            // Controller.deleteMenu(foodname);
            int count = in.nextInt();
            String size = in.next();
            // Controller.selectMenu(foodname, count, size);
        }
        selectMenu();
    }

    public static void selectOrderInfo() {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        String isTakeout;
        String method;

        do {
            System.out.print("포장/매장? : ");
            isTakeout = in.nextLine();
        } while (!isTakeout.equals("포장") && !isTakeout.equals("매장"));
        
        do {
            System.out.print("결제 방법을 선택하세요 (카드/바코드) : ");
            method = in.nextLine();
        } while (!method.equals("카드") && !method.equals("바코드"));
        //잔액이 남았을 때 다시 선택하게 말해야됨...... 
        Controller.sendOrderInfo(method, isTakeOut);
    }

    public static void waitingForCard()
    {
        // 카드 입력받는 타이머 설정
        TimerT.getInstance().setTimer(120);
        // 타이머 종료되면 프로그램 종료되니까~~!! ^^
    }
        
    public static void insertCard() {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        String cardName;
        do {
            System.out.print("결제할 카드를 입력해주세요 (농협카드/신한카드/국민카드/카카오뱅크) : ");
            cardName = in.nextLine();
        } while (!cardName.equals("농협카드") && !cardName.equals("신한카드")
            && !cardName.equals("카카오뱅크") && !cardName.equals("국민카드"));
        Controller.cardInfo(cardName);
    }

    public static void printReceipt(){
        String answer = "n";

        TimerT.getInstance().waiting(120);
        String receiptInfo;
        int orderNumber;
        Scanner in = new Scanner(System.in);
        System.out.print("영수증을 출력하시겠습니까? (y/n) : ");
        answer = in.nextLine();
        if (answer.equals("y")) {
            receiptInfo = Controller.requestReceiptInfo();
            System.out.println(receiptInfo);
        }
        else {
            orderNumber = Controller.requestOrderNumber();
            System.out.println("주문 번호 : " + orderNumber);
        }
        // in.close();
        //Controller.endOrder();
        //return false;
    }

    
}
