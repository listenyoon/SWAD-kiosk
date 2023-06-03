public class Kiosk {
    public static void main(String args[]){
        boolean status = true;
        String method = "card";
        while (status) {
            System.out.println("키오스크 주문을 시작합니다.");
            Front.touchScreen();
            Front.selectMenu();
            Front.accept();
            method = Front.selectOrderInfo();
            System.out.println(method);
            if (method.equals("card"))
                Front.insertCard();
            else if (method.equals("barcode"))
                Front.scanBarcode();
            Front.printReceipt();
            System.out.println("주문 및 결제 완료\n");
        }
    }
}
