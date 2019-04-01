package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodDto;
import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantDto;
import lk.nsbm.onlinefoodorderingsystem.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    public boolean addRestaurant(RestaurantDto restaurantDto);
    public List<RestaurantDto> getRestaurantList();
    public RestaurantDto getRestaurantDto(int id);
    public boolean deleteRestaurant(int id);
    public void addRate(int value, int order);
    public String getRatings(int value);
    public List<OrderDto> getOrders(String username);
}
