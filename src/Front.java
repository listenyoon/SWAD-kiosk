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
    
    public static void printMenuInfo(){
        StringBuilder menuBoard = new StringBuilder();
        menuBoard.append("\n                  [ 메뉴판 ]                  \n")
            .append("----------------------------------------------\n")
            .append(" 상품명            단가      알러지 주의 성분 \n")
            .append("----------------------------------------------\n");
        
        for (Food food : foodList.values()) {
            menuBoard.append(" " + food.name + "        ");
            for (int i = 0; i < 5 - food.name.length(); i++)
                menuBoard.append("  ");

            menuBoard.append(food.price + " ");
            for (int i = 0; i < 10 - String.valueOf(food.price).length(); i++)
                menuBoard.append(" ");
            
            menuBoard.append(food.allergyInfo + '\n');
        }
        menuBoard.append("----------------------------------------------\n");
        System.out.println(menuBoard);
    }
    
    //여기서 인자를 넣어주는게 아니라 여기서 컨트롤러로 부를때 인자를 넣어줘야될듯?
    public static void selectMenu() {
        printMenuInfo();
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
        TimerT.getInstance().setTimer(120);
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
            editCartList();  // accept() 함수의 흐름 중 
            //주문을 수정하기를 원할 경우 editCartList()로 들어감.
        else if (answer.equals("n"))
            return;
    }

    public static void editCartList()
    {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        // case 1) 사용자가 메뉴를 삭제하고 싶은 경우 
        //         삭제하려는 메뉴 이름을 입력받고, deleteMenu를 호출하여 Controller->Cart의 장바구니 리스트에서 해당 메뉴를 삭제한다.
        while (true) {
            System.out.print("삭제하려는 메뉴를 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.nextLine();
            if (foodname.equals("n"))
                break;
            else if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            Controller.deleteMenu(foodname);
        }

        // case 2) 사용자가 메뉴를 뒤늦게 추가하고 싶은 경우 
        //         추가하려는 메뉴 이름과 수량, 사이즈를 입력받고 Controller.selectMenu()를 호출해 Cart의 장바구니 리스트에 추가한다.

        // case 3) 사용자가 메뉴 옵션(수량, 사이즈)을 수정하고 싶은 경우 
        //         이미 해당 메뉴가 들어와있는지 장바구니 리스트에서 조회한 후 삭제하고, 새로운 입력값으로 다시 장바구니 리스트에 넣는다.
        while (true) {
            System.out.print("수정하거나 추가하려는 메뉴 이름, 수량, 사이즈를 차례대로 입력하세요! 없을 경우, n를 입력하세요 : ");
            String foodname = in.next();
            if (foodname.equals("n"))
                break;
            else if (!foodname.equals("불고기버거") && !foodname.equals("새우버거")
            && !foodname.equals("치킨버거") && !foodname.equals("감자튀김")
            && !foodname.equals("콜라") && !foodname.equals("사이다"))
                continue;
            Controller.deleteMenu(foodname);
            int count = in.nextInt();
            String size = in.next();
            Controller.selectMenu(foodname, count, size);
        }
        accept();  // 다시 주문 정보를 출력하고, Order에게로 수정된 장바구니 리스트를 전달해준다.
    }

    public static String selectOrderInfo() {
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
        if (method.equals("카드"))
            return "card";
        else if (method.equals("바코드"))
            return "barcode";
        else {
            return "unknown";
        }
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
        
    public static void insertCard() {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        String cardName;
        do {
            System.out.print("결제할 카드를 입력해주세요 (농협카드/신한카드/국민카드/카카오뱅크) : ");
            cardName = in.nextLine();
        } while (!cardName.equals("농협카드") && !cardName.equals("신한카드")
            && !cardName.equals("카카오뱅크") && !cardName.equals("국민카드"));
        if (Controller.cardInfo(cardName).equals("fail")) {
            System.out.println("잔액 부족으로 결제가 실패하였습니다. 다른 결제수단을 투입해주십시오.");
            insertCard();
        }
    }

    public static void scanBarcode() {
        TimerT.getInstance().setTimer(120);
        Scanner in = new Scanner(System.in);
        String coupon;
        do {
            System.out.print("읽어들일 바코드를 입력해주세요 : ");
            coupon = in.nextLine();
        } while (!coupon.equals("2000원 할인쿠폰") && !coupon.equals("10% 할인쿠폰")
            && !coupon.equals("20% 할인쿠폰") && !coupon.equals("30% 할인쿠폰"));
        if ((Controller.barcodeInfo(coupon)).equals("fail")) {
            System.out.println("잔액 결제할 카드를 투입해 주십시오.");
            insertCard();
        }
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
