import java.util.ArrayList;

public class Controller {
    private ArrayList<String> menuInfo;
    private ArrayList<String> cartInfo;
    private String receiptInfo;
    private Menu menu;
    private Cart cart;
    private Order order;

    public Controller() {
        menu = new Menu();
        cart = new Cart();
        order = new Order();
    }

    public ArrayList<String> startOrder(){
        return menuInfo;
    }

    public ArrayList<String> selectMenu(String menu){
        cartInfo = cart.addToCard(menu);
        return cartInfo; //여기서 displayCart?
    }

    public ArrayList<String> requestCartInfo(){
        return cartInfo;
    }

    public void sendOrderInfo(String method, boolean isTakeOut){
        order.getOrderInfo(method, isTakeOut);
    }

    public String requestReceiptInfo(){
        return receiptInfo;
    }

    public String endOrder() {
        return "end";
    }
}
