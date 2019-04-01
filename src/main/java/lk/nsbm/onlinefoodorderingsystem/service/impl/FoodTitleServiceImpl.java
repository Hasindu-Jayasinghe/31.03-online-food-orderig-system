package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodTitleDto;
import lk.nsbm.onlinefoodorderingsystem.entity.FoodTitle;
import lk.nsbm.onlinefoodorderingsystem.entity.Restaurant;
import lk.nsbm.onlinefoodorderingsystem.repository.FoodTitleRepository;
import lk.nsbm.onlinefoodorderingsystem.service.FoodTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodTitleServiceImpl implements FoodTitleService {

    @Autowired
    private FoodTitleRepository foodTitleRepository;

    @Override
    public boolean addFoodCategory(FoodTitleDto foodTitleDto) {
        if (foodTitleDto == null) {
            return false;
        }

        FoodTitle foodTitle = new FoodTitle();
        foodTitle.setTitleId(foodTitleDto.getTitleId());
        foodTitle.setName(foodTitleDto.getName());

        if (foodTitleRepository.existsById(foodTitleDto.getTitleId())) {
            return false;
        }
        try {
            foodTitleRepository.save(foodTitle);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<FoodTitleDto> getAllFoodTitles() {
        List<FoodTitleDto> foodTitleDtoList = foodTitleRepository.findAll().stream().map(foodTitle ->
                new FoodTitleDto(foodTitle.getTitleId(), foodTitle.getName())).collect(Collectors.toList());

        return foodTitleDtoList;
    }
}
