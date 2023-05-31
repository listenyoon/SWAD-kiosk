import java.util.Scanner;

public class Kiosk {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("hello world");

        boolean status = Front.touchScreen();
        
        while (status) {
            System.out.println("메뉴를 입력하세요! :");
            String foodname = in.nextLine();

            if (!foodname.equals("불고기버거")
                    && !foodname.equals("새우버거")
                    && !foodname.equals("치킨버거")
                    && !foodname.equals("감자튀김")
                    && !foodname.equals("콜라")
                    && !foodname.equals("사이다")) {
                continue;
            }

            System.out.println("옵션을 입력하세요! : ");
            String option = in.nextLine();
            System.out.println("사이즈를 입력하세요 : ");
            String size = in.nextLine();
            Menu newMenu = new Menu(foodname, option, size);
            Front.selectMenu(newMenu);

            System.out.println(newMenu.name + " " + newMenu.price + " " + newMenu.allergyInfo + " " + newMenu.option
                    + " " + newMenu.size);
            String answer = in.nextLine();
            System.out.println("메뉴 선택을 완료하시겠습니까? (y/n)");
            if (answer.equals("y")) {
                System.out.println("카트 정보 보내줘잉");
                break;
            }
        }
        Front.accept();
        System.out.println("끝남");
        in.close();
    }
}
