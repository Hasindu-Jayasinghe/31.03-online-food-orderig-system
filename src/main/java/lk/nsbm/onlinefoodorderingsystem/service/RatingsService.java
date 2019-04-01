package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodDto;
import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantRatingsDto;

import java.util.List;

public interface RatingsService {
    public List<RestaurantRatingsDto> getRetaurantRatings(String restaurantName);
    public boolean saveRestaurantRating(RestaurantRatingsDto restaurantRatingsDto);

}
