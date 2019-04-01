package lk.nsbm.onlinefoodorderingsystem.dto;

public class RestaurantRatingsDto {
    private int ratingId;
    private String userId;
    private int rating;
    private String comment;
    private String restaurantId;

    public RestaurantRatingsDto() {
    }

    public RestaurantRatingsDto(String userId, int rating, String comment) {
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    public RestaurantRatingsDto( String userId, int rating, String comment, String restaurantId) {
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.restaurantId = restaurantId;
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
