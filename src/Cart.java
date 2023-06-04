import java.util.*;
import java.util.HashMap;

public class Cart {
    public static HashMap<String, Menu> cartInfo = new HashMap<String, Menu>();

    public static void addToCart(String name, Menu menu){
        // 다른 객체에서 호출되면, 이 Cart의 속성 cartInfo에 메뉴 이름(key)과 수량, 사이즈 등 메뉴 정보(value)를 추가한다.
        cartInfo.put(name, menu);
    }

    public static void deleteMenu(String foodname) {
        // cartInfo에 메뉴가 이미 들어가있는지 확인하고, 있는 경우에만 삭제한다. 그 다음 변경된 부분을 Order에게 반영해준다.
        if (cartInfo.containsKey(foodname)) {
            cartInfo.remove(foodname);
            Order.setCartInfo(cartInfo);
        }
    }

    public static HashMap<String, Menu> requestCartInfo(){
        // Order 객체에게 현재까지의 cart 안에 담긴 정보들을 전해주고, 이 함수를 호출한 객체에게 cartInfo를 전달해준다. 
        Order.setCartInfo(cartInfo);
        return cartInfo;
    }
}

