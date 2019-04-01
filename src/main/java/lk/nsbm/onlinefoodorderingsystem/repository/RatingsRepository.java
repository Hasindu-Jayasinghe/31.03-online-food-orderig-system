package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.ContactDetails;
import lk.nsbm.onlinefoodorderingsystem.entity.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsRepository extends JpaRepository<RestaurantRating, Integer> {
    @Query(
            value = "select  * from restaurant_rating where restaurant_id=:id",
            nativeQuery = true
    )
    public List<RestaurantRating> findByRatingByRestaurantId(@Param("id") int id);
}
