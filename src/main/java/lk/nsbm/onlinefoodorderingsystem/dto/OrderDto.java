package lk.nsbm.onlinefoodorderingsystem.dto;

import lk.nsbm.onlinefoodorderingsystem.entity.Restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private int orderId;
    private LocalDate date;
    private double cost;
    private String typeOfOrder;
    private String time;
    private String paymentType;
    private String location;
    private UserDto userDto;
    private List<RestaurantDto> restaurantDto;
    private List<OrderDetailDto> orderDetailDto;

    public OrderDto() {
    }

    public OrderDto(int orderId) {
        this.orderId = orderId;
    }

    public OrderDto(int orderId, LocalDate date, double cost, UserDto userDto, List<RestaurantDto> restaurantDto, List<OrderDetailDto> orderDetailDto) {
        this.orderId = orderId;
        this.date = date;
        this.cost = cost;
        this.userDto = userDto;
        this.restaurantDto = restaurantDto;
        this.orderDetailDto = orderDetailDto;
    }

    public OrderDto(int orderId, LocalDate date, double cost, String typeOfOrder, String time, String paymentType, String location, UserDto userDto, List<Restaurant> restaurantDto, List<OrderDetailDto> orderDetailDto)
    {
        this.orderId = orderId;
        this.date = date;
        this.cost = cost;
        this.typeOfOrder = typeOfOrder;
        this.time = time;
        this.paymentType = paymentType;
        this.userDto = userDto;
        this.restaurantDto = convertToRestaurantDto(restaurantDto);
        this.orderDetailDto = orderDetailDto;
        this.location = location;
    }

    private List<RestaurantDto> convertToRestaurantDto(List<Restaurant> restaurantDto){
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant ret : restaurantDto){
            restaurantDtos.add( new RestaurantDto(ret.getRestaurantId() , ret.getRestaurantName() , ret.getLocation() , ret.getImage() , ret.getLat() , ret.getLng()));
        }
        setRestaurantDto(restaurantDtos);
        return getRestaurantDto();
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<RestaurantDto> getRestaurantDto() {
        return restaurantDto;
    }

    public void setRestaurantDto(List<RestaurantDto> restaurantDto) {
        this.restaurantDto = restaurantDto;
    }

    public List<OrderDetailDto> getOrderDetailDto() {
        return orderDetailDto;
    }

    public void setOrderDetailDto(List<OrderDetailDto> orderDetailDto) {
        this.orderDetailDto = orderDetailDto;
    }

    public String getTypeOfOrder()
    {
        return typeOfOrder;
    }

    public void setTypeOfOrder( String typeOfOrder )
    {
        this.typeOfOrder = typeOfOrder;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType( String paymentType )
    {
        this.paymentType = paymentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
