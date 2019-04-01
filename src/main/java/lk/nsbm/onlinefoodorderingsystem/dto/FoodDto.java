package lk.nsbm.onlinefoodorderingsystem.dto;

public class FoodDto {
    private int foodId;
    private String foodName;
    private String description;
    private double price;
    private double oldPrice;
    private FoodTitleDto foodTitle;
    private String image;
    private RestaurantDto restaurantDtoList;
    private boolean isSpecialOffer;

    public FoodDto() {
    }

    public FoodDto(String foodName) {
        this.foodName = foodName;
    }

    public FoodDto(int foodId, String foodName, double price, FoodTitleDto foodTitle, String image, RestaurantDto restaurantDtoList) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.foodTitle = foodTitle;
        this.image = image;
        this.restaurantDtoList = restaurantDtoList;
    }

    public FoodDto(int foodId, String foodName, double price, double oldPrice, FoodTitleDto foodTitle, String image, RestaurantDto restaurantDtoList, boolean isSpecialOffer) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.oldPrice = oldPrice;
        this.foodTitle = foodTitle;
        this.image = image;
        this.restaurantDtoList = restaurantDtoList;
        this.isSpecialOffer = isSpecialOffer;
    }

    public FoodDto(int foodId, String foodName, String description, double price, double oldPrice, FoodTitleDto foodTitle, String image, RestaurantDto restaurantDtoList, boolean isSpecialOffer) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.foodTitle = foodTitle;
        this.image = image;
        this.restaurantDtoList = restaurantDtoList;
        this.isSpecialOffer = isSpecialOffer;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RestaurantDto getRestaurantDtoList() {
        return restaurantDtoList;
    }

    public void setRestaurantDtoList(RestaurantDto restaurantDtoList) {
        this.restaurantDtoList = restaurantDtoList;
    }

    public FoodTitleDto getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(FoodTitleDto foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public boolean getIsSpecialOffer() {
        return isSpecialOffer;
    }

    public void setIsSpecialOffer(boolean specialOffer) {
        isSpecialOffer = specialOffer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
