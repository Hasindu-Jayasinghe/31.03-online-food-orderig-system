package lk.nsbm.onlinefoodorderingsystem.service.impl;


import lk.nsbm.onlinefoodorderingsystem.dto.*;
import lk.nsbm.onlinefoodorderingsystem.entity.*;
import lk.nsbm.onlinefoodorderingsystem.repository.OrderRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.RestaurantRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.UserCredentialRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.UserRepository;
import lk.nsbm.onlinefoodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addRestaurant(RestaurantDto restaurantDto) {

        if (restaurantDto == null){
            return false;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDto.getRestaurantId());
        restaurant.setRestaurantName(restaurantDto.getRestaurantName());
        restaurant.setLocation(restaurantDto.getLocation());
        restaurant.setImage(restaurantDto.getImage());
        restaurant.setLat(restaurantDto.getLat());
        restaurant.setLng(restaurantDto.getLng());

        if (restaurantRepository.existsById(restaurantDto.getRestaurantId())){
            return false;
        }

        try {


            UserCredential userCredential = new UserCredential();
            userCredential.setUsername(restaurantDto.getUsername());
            userCredential.setPassword(restaurantDto.getPassword());

            User user = new User();
            user.setFirstName(restaurantDto.getRestaurantName());
            user.setLastName(restaurantDto.getRestaurantName());;
            user.setUserType(2);

            User user1 = userRepository.save(user);
            if (user1 != null) {
                userCredential.setUserCredential(user1);
                UserCredential save = userCredentialRepository.save(userCredential);

                if (save != null){
                    restaurant.setUserCredential(save);
                    Restaurant save1 = restaurantRepository.save(restaurant);
                    return save1 != null;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }

    }


    @Override
    public List<RestaurantDto> getRestaurantList() {
        List<RestaurantDto> restaurantDtoList = restaurantRepository.findAll().stream().map(restaurant ->
                new RestaurantDto(
                        restaurant.getRestaurantId(),
                        restaurant.getRestaurantName(),
                        restaurant.getLocation(),
                        restaurant.getImage(),
                        restaurant.getLat(),
                        restaurant.getLng())).collect(Collectors.toList());



        return restaurantDtoList;
    }

    @Override
    public RestaurantDto getRestaurantDto( int id )
    {
        Restaurant restaurant = restaurantRepository.findById( id ).get();

        RestaurantDto restaurantDto = new RestaurantDto( );
        restaurantDto.setRestaurantId( restaurant.getRestaurantId() );
        restaurantDto.setRestaurantName( restaurant.getRestaurantName() );

        return restaurantDto;
    }

    @Override
    public boolean deleteRestaurant(int id) {

        if(restaurantRepository.existsById(id)){
            restaurantRepository.delete(restaurantRepository.findById(id).get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRate(int value, int order) {
        Orders orders = orderRepository.findById(order).get();
        orders.setRatings(value);

        orderRepository.save(orders);
    }

    @Override
    public String getRatings(int value) {
        List<Orders> ordersByRestaurant_restaurantId = orderRepository.getOrdersByRestaurant_RestaurantId(value);

        int totalRating = 0;
        for (Orders orders : ordersByRestaurant_restaurantId) {
            totalRating += orders.getRatings();
        }

        try{
            return value + ":" +totalRating / ordersByRestaurant_restaurantId.size();
        }catch (ArithmeticException e){
            return value +":"+0;
        }

    }

    @Override
    public List<OrderDto> getOrders(String username) {
        Restaurant restaurantByUserCredentialUsername = restaurantRepository.getRestaurantByUserCredentialUsername(username);

        List<OrderDto> orderDtos = orderRepository.getOrdersByRestaurant_RestaurantId(restaurantByUserCredentialUsername.getRestaurantId()).stream()
                .map(order ->
                        new OrderDto(
                                order.getOrderId(),
                                LocalDate.parse(order.getOrderDate()),
                                order.getCost(),
                                order.getTypeOfOrder(),
                                order.getTime(),
                                order.getPaymentType(),
                                order.getLocation(),
                                new UserDto(order.getUser().getUserId(), order.getUser().getFirstName(), order.getUser().getLastName(), order.getUser().getUserType()),
                                order.getRestaurant(),
                                order.getOrderDetails()
                                        .stream()
                                        .map(orderDetail ->
                                                new OrderDetailDto(0, orderDetail.getCount(), new FoodDto(orderDetail.getFood().getFoodName()))
                                        ).collect(Collectors.toList()))).collect(Collectors.toList());
        return orderDtos;
    }

}
