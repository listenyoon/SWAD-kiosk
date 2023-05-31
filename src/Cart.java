import java.util.ArrayList;

public class Cart {
    public ArrayList<String> cartItem;
    private Order order;

    public Cart() {
        this.order = new Order();
        cartItem = new ArrayList<>();
    }

    public ArrayList<String> addToCard(String menu){
        cartItem.add(menu);
        return cartItem;
    }

    public ArrayList<String> confirmCartInfo(){
        order.getCartInfo(cartItem);
        return cartItem;
    }
}
