package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.RestaurantRatingsDto;
import lk.nsbm.onlinefoodorderingsystem.entity.Restaurant;
import lk.nsbm.onlinefoodorderingsystem.entity.RestaurantRating;
import lk.nsbm.onlinefoodorderingsystem.repository.RatingsRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.RestaurantRepository;
import lk.nsbm.onlinefoodorderingsystem.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RatingServiceImpl implements RatingsService {

    @Autowired
    private RatingsRepository ratingsRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<RestaurantRatingsDto> getRetaurantRatings(String restName) {
        Restaurant  restaurant = restaurantRepository.getRestaurantByUserCredentialUsername(restName);
        List<RestaurantRatingsDto> ratingsDtos = ratingsRepository.findByRatingByRestaurantId(restaurant.getRestaurantId()).stream()
                .map(rating ->
                        new RestaurantRatingsDto(rating.getUserId(), rating.getRating(), rating.getComment(), rating.getRestaurantId()))
                .collect(Collectors.toList());
        return ratingsDtos;
    }

    @Override
    public boolean saveRestaurantRating(RestaurantRatingsDto restaurantRatingsDto) {
        RestaurantRating rating = new RestaurantRating(restaurantRatingsDto.getUserId(), restaurantRatingsDto.getRestaurantId(), restaurantRatingsDto.getRating(), restaurantRatingsDto.getComment());
        try {
            ratingsRepository.save(rating);
            return true;
        } catch (Exception e) {
            System.out.println("---------error--------------");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
