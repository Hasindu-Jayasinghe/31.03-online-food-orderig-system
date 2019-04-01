package lk.nsbm.onlinefoodorderingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RestaurantRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;
    private String userId;
    private String restaurantId;
    private int rating;
    private String comment;

    public RestaurantRating() {
    }

    public RestaurantRating(int ratingId, String userId, int rating, String comment) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    public RestaurantRating( String userId, String restaurantId, int rating, String comment) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
