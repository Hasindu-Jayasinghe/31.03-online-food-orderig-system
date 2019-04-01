package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantRatingsDto;
import lk.nsbm.onlinefoodorderingsystem.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingsService ratingsService;

    @GetMapping(value = "/restaurants/{restaurantName}")
    public List<RestaurantRatingsDto> getRatings(@PathVariable String restaurantName){
        return ratingsService.getRetaurantRatings(restaurantName);
    }
    @PostMapping(value = "/restaurants/{restaurantId}")
    public boolean saveRatings(@PathVariable int restaurantId, @RequestBody RestaurantRatingsDto restaurantRatingsDto){
        return ratingsService.saveRestaurantRating(restaurantRatingsDto);
    }
}
