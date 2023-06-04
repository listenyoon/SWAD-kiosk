import java.util.HashMap;

public class Cart_GUI {
    public static HashMap<String, Menu> cartInfo = new HashMap<String, Menu>();

    public static void addToCart(String name, Menu menu){
        cartInfo.put(name, menu);
        //retucrn cartInfo;
    }

    public static void deleteMenu(String foodname) {
        if (cartInfo.containsKey(foodname)) {
            cartInfo.remove(foodname);
            Order_GUI.setCartInfo(cartInfo);
        }
    }

    public static HashMap<String, Menu> requestCartInfo(){
        Order_GUI.setCartInfo(cartInfo);
        return cartInfo;
    }
}
