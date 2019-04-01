package lk.nsbm.onlinefoodorderingsystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderDate;
    private double cost;
    private String typeOfOrder;
    private String time;
    private String paymentType;
    private String location;
    private int ratings;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Restaurant> restaurant;

    public Orders() {
    }

    public Orders(String orderDate, double cost, String typeOfOrder, String time, String paymentType, String location, List<OrderDetail> orderDetails, User user, List<Restaurant> restaurant) {
        this.orderDate = orderDate;
        this.cost = cost;
        this.typeOfOrder = typeOfOrder;
        this.time = time;
        this.paymentType = paymentType;
        this.location = location;
        this.orderDetails = orderDetails;
        this.user = user;
        this.restaurant = restaurant;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
    public void addRestaurant(Restaurant restaurant) {
        if(this.restaurant == null){
            this.restaurant = new ArrayList<>();
        }
        this.restaurant.add(restaurant);
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", cost=" + cost +
                ", typeOfOrder='" + typeOfOrder + '\'' +
                ", time='" + time + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", location='" + location + '\'' +
                ", ratings=" + ratings +
                ", orderDetails=" + orderDetails +
                ", user=" + user +
                ", restaurant=" + restaurant +
                '}';
    }
}
