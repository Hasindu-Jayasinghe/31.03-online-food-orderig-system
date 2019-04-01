package lk.nsbm.onlinefoodorderingsystem.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;
    private int count;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Food food;

    public OrderDetail() {
    }

    public OrderDetail(int count, Food food) {
        this.count = count;
        this.food = food;
    }

    public OrderDetail(int orderDetailId, int count, Food food) {
        this.orderDetailId = orderDetailId;
        this.count = count;
        this.food = food;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
