import java.util.ArrayList;

public class Cart {
    public static ArrayList<Menu> cartInfo = new ArrayList<>();

    public static ArrayList<Menu> addToCart(Menu menu){
        cartInfo.add(menu);
        return cartInfo;
    }

    public static ArrayList<Menu> confirmCartInfo(ArrayList<Menu> ctr_cart){
        // Controller에 있던 cartInfo와 Cart의 cartInfo를 비교해서 확인작업하는 코드를 추가할까? 눈가리고 아웅이긴 하지만^^ㅋ
        Order.setCartInfo(cartInfo);
        return cartInfo;
    }
}
