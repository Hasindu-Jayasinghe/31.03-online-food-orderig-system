package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.*;
import lk.nsbm.onlinefoodorderingsystem.entity.*;
import lk.nsbm.onlinefoodorderingsystem.repository.*;
import lk.nsbm.onlinefoodorderingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodTitleRepository foodTitleRepository;
    @Autowired
    private OrderLearnRepository orderLearnRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderDto addOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Orders orders = new Orders();
        orders.setOrderDate(LocalDate.now().toString());
        orders.setCost(orderDto.getCost());
        orders.setTypeOfOrder(orderDto.getTypeOfOrder());
        orders.setTime(orderDto.getTime());
        orders.setPaymentType(orderDto.getPaymentType());
        orders.setLocation(orderDto.getLocation());

        orders.setUser(userRepository.findById(orderDto.getUserDto().getUserId()).get());

        for(RestaurantDto res: orderDto.getRestaurantDto()){
            orders.addRestaurant(restaurantRepository.findById(res.getRestaurantId()).get());
        }

        orders.setOrderDetails(orderDto.getOrderDetailDto()
                .stream()
                .map(orderDetail ->
                        new OrderDetail(orderDetail.getCount(), new Food(orderDetail.getFood().getFoodId()))).collect(Collectors.toList()));

// 30/03/2019 for the ML created a new table orderLearn
        OrderLearn orderLearn = new OrderLearn();
        orderLearn.setUserId(orderDto.getUserDto().getUserId());
        orderLearn.setName(getFoodType(orderDto.getOrderDetailDto().get(0).getFood().getFoodId()));
        orderLearn.setOrderDate((new Date()));
        try {
            Orders save = orderRepository.save(orders);
            try {
                orderLearnRepository.save(orderLearn);
            } catch (Exception e) {
                System.out.println("---------error--------------");
                System.out.println(e.getMessage());
                return null;
            }
            return new OrderDto(save.getOrderId());
        } catch (Exception e) {
            System.out.println("---------error--------------");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String getFoodType(int foodId) {
        Food food = foodRepository.findByFoodId(foodId);
        int foodTitleId = -1;
        if (food != null) {
            foodTitleId = food.getFoodId();
            if (foodTitleId != -1) {
                FoodTitle foodTitle = foodTitleRepository.getOne(foodTitleId);
                if (foodTitle != null) {
                    return foodTitle.getName();
                }
            }
            return null;
        } else {
            return null;
        }
    }

    @Override
    public List<OrderDto> getOrders() {

        List<OrderDto> ordersList = orderRepository.findAll()
                .stream()
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

        return ordersList;

    }

    @Override
    public List<OrderDto> getSelectedOrders(int id) {
        List<OrderDto> ordersList = orderRepository.getOrdersByUser_UserId(id)
                .stream()
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
        return ordersList;
    }
}

