public class Menu extends Food {
    public int count;
    public String size;

    public Menu(String foodName, int menuCount, String menuSize) {
        super(foodName,
            Controller.foodList.get(foodName).price, 
            Controller.foodList.get(foodName).allergyInfo);
        
        this.count = menuCount;
        this.size = menuSize;
    }
}

