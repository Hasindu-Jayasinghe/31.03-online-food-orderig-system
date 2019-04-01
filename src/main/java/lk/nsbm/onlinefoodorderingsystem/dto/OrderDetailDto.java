package lk.nsbm.onlinefoodorderingsystem.dto;


import java.util.List;

public class OrderDetailDto {
    private int orderDetailId;
    private int count;
    private FoodDto food;

    public OrderDetailDto() {
    }

    public OrderDetailDto(int orderDetailId, int count, FoodDto food) {
        this.orderDetailId = orderDetailId;
        this.count = count;
        this.food = food;
    }


    public OrderDetailDto(int orderDetailId, FoodDto food) {
        this.orderDetailId = orderDetailId;
        this.food = food;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public FoodDto getFood() {
        return food;
    }

    public void setFood(FoodDto food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
