package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.dto.FoodTitleDto;
import lk.nsbm.onlinefoodorderingsystem.entity.FoodTitle;
import lk.nsbm.onlinefoodorderingsystem.service.FoodTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/foods-title")
public class FoodTitleController {

    @Autowired
    private FoodTitleService foodTitleService;

    @PostMapping(value = "/add")
    public boolean saveContact(@RequestBody FoodTitleDto foodTitleDto){
        return foodTitleService.addFoodCategory(foodTitleDto);
    }


    @GetMapping
    public List<FoodTitleDto> getFoodTitleList(){
        return foodTitleService.getAllFoodTitles();
    }
}
