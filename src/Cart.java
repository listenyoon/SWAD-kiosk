import java.util.ArrayList;

public class Cart {
    public static ArrayList<Menu> cartItem = new ArrayList<>();

    public static ArrayList<Menu> addToCart(Menu menu){
        cartItem.add(menu);
        return cartItem;
    }

    public static ArrayList<Menu> confirmCartInfo(){
        Order.getCartInfo(cartItem);
        return cartItem;
    }
}
