import java.util.ArrayList;

public class Cart {
    public static ArrayList<Menu> cartInfo = new ArrayList<>();

    public static void addToCart(Menu menu){
        cartInfo.add(menu);
        //retucrn cartInfo;
    }

    public static ArrayList<Menu> requestCartInfo(){
        // Order.setCartInfo(cartInfo);
        return cartInfo;
    }
}
