package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.FoodDto;
import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantDto;
import lk.nsbm.onlinefoodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/restaurants")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addRestaurant(@RequestBody RestaurantDto restaurantDto){
        System.out.println(restaurantDto);
        return restaurantService.addRestaurant(restaurantDto);
    }

    @GetMapping(value = "/get/{id}")
    public RestaurantDto getRestaurant(@PathVariable int id){
        return restaurantService.getRestaurantDto( id );
    }

    @GetMapping
    public List<RestaurantDto> getAllRestaurants(){
        return restaurantService.getRestaurantList();
    }

    @DeleteMapping("/{id}")
    public boolean deleteRestaurant(@PathVariable int id){
        return restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/add-rating/{value}/{order}")
    public void addRating(@PathVariable int value, @PathVariable int order){
        restaurantService.addRate(value, order);
    }

    @GetMapping("/get-ratings/{restaurant}")
    public String getRatings(@PathVariable int restaurant){
        return restaurantService.getRatings(restaurant);
    }

    @GetMapping("/get-orders/{username}")
    public List<OrderDto> getOrders(@PathVariable String username){
        return restaurantService.getOrders(username);
    }

}
