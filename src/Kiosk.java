import java.util.Scanner;

public class Kiosk {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("hello world");

        boolean status = Front.touchScreen();
        
        while (status) {
            status = Front.selectMenu();
        }
        Front.accept();
        Front.selectOrderInfo();
        Front.insertCard();
        System.out.println("끝남");
        in.close();
    }
}
