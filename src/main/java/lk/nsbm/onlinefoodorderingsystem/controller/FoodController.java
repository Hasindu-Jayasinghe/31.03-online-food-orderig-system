package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodDto;
import lk.nsbm.onlinefoodorderingsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(value = "/add")
    public boolean addFood(@RequestBody FoodDto foodDto) {
        return foodService.saveFood(foodDto);
    }

    @GetMapping
    public List<FoodDto> getAllFodds() {
        return foodService.getAllFoods();
    }

    @GetMapping(value = "/special-offers")
    public List<FoodDto> getAllSpecialOfferFoods() {
        return foodService.getAllSpecialOfferFoods();
    }

    @GetMapping(value = "/get/{id}")
    public FoodDto getFood(@PathVariable int id) {
        return foodService.getFood(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodDto> getFoodDtoList(@PathVariable int id) {
        return foodService.getFoodDtoList(id);
    }

    @GetMapping(value = "/restaurant/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodDto> getFoodDtoOfRestaurantList(@PathVariable String username) {
        return foodService.getFoodForRestaurant(username);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteFood(@PathVariable int id) {
        return foodService.deleteFood(id);
    }

    @PutMapping(value = "/edit")
    public boolean editFood(@RequestBody FoodDto foodDto) {
        return foodService.editFood(foodDto);
    }
}
