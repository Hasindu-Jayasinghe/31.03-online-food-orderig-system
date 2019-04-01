package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodTitleDto;

import java.util.List;

public interface FoodTitleService {
    public boolean addFoodCategory(FoodTitleDto foodTitleDto);
    public List<FoodTitleDto> getAllFoodTitles();
}
