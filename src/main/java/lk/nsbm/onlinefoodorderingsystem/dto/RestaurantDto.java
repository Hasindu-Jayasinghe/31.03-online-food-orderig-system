package lk.nsbm.onlinefoodorderingsystem.dto;

import lk.nsbm.onlinefoodorderingsystem.entity.Food;

import java.util.List;

public class RestaurantDto {


    private int restaurantId;
    private String restaurantName;
    private String location;
    private String image;
    private String format;
    private double lat;
    private double lng;
    private String username;
    private String password;

    public RestaurantDto()
    {
    }

    public RestaurantDto(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public RestaurantDto(int restaurantId, String restaurantName, String location, String image, double lat, double lng) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
    }



    private List<Food> foodList;

    public RestaurantDto(int restaurantId, String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public RestaurantDto(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantDto(int restaurantId, String restaurantName, String location) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
    }

    public RestaurantDto(int restaurantId, String restaurantName, String location, List<Food> foodList) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.foodList = foodList;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "RestaurantDto{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                ", image='" + image + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", foodList=" + foodList +
                '}';
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
