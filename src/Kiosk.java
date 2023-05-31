import java.util.Scanner;

public class Kiosk {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("hello world");
        Front front = new Front();

        front.touchScreen();

        System.out.println("메뉴를 선택하세요! : ");
        input = in.next();
        front.selectMenu(input);
    }
}
