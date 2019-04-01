package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(
            value = "select food_id,food_name,image,price,food_title_title_id, restaurant_list_restaurant_id,description,is_special_offer , old_price from food where restaurant_list_restaurant_id=:id",
            nativeQuery = true
    )
    public List<Food> findByRestaurantId(@Param("id") int id);

    @Query(
            value = "select food_id,food_name,image,price,food_title_title_id, restaurant_list_restaurant_id,description,is_special_offer ,old_price from food where food_id=:id",
            nativeQuery = true
    )
    public Food findByFoodId(@Param("id") int id);





}
