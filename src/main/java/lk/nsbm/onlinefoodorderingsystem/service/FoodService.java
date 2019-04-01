package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodDto;
import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantDto;
import lk.nsbm.onlinefoodorderingsystem.entity.Food;

import java.util.List;

public interface FoodService {
    public List<FoodDto> getFoodDtoList(int restaurantId);
    public boolean saveFood(FoodDto food);
    public boolean editFood(FoodDto food);
    public List<FoodDto> getAllFoods();
    public List<FoodDto> getFoodForRestaurant(String restId);
    public List<FoodDto> getAllSpecialOfferFoods();
    public FoodDto getFood(int id);
    public boolean deleteFood(int id);
}
