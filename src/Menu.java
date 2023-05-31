public class Menu extends Food {
    public String option;
    public String size;

    public Menu(String foodName, String menuOption, String menuSize) {
        super(foodName,
            Controller.foodList.get(foodName).price, 
            Controller.foodList.get(foodName).allergyInfo);
        
        this.option = menuOption;
        this.size = menuSize;
    }
}

