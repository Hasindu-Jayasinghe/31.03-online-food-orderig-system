package lk.nsbm.onlinefoodorderingsystem.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    private int restaurantId;
    private String restaurantName;
    private String location;
    @Lob
    private String image;
    private double lat;
    private double lng;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<Food> foodList;
    @OneToOne
    private UserCredential userCredential;

    public Restaurant() {
    }

    public Restaurant(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant(int restaurantId, String restaurantName, String location, List<Food> foodList) {
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

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }
}
