public class Food {
    public String name;
    public Integer price;
    public String allergyInfo;

    public Food(String foodName, Integer foodPrice, String foodAllergyInfo) {
        this.name = foodName;
        this.price = foodPrice;
        this.allergyInfo = foodAllergyInfo;
    }
}