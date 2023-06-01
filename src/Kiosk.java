import java.util.Scanner;

public class Kiosk {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("hello world");

        boolean status = Front.touchScreen();
        System.out.println("test");
        while (status) {
            status = Front.selectMenu();
            System.out.println("a");
        }
        Front.accept();
        Front.selectOrderInfo();
        Front.insertCard();
        Front.printReceipt();
        System.out.println("끝남");
        in.close();
    }
}
