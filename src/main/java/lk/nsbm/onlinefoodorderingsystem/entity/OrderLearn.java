package lk.nsbm.onlinefoodorderingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderLearn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int learnId;
    private Date orderDate;
    private String name;
    private int userId;

    public OrderLearn() {
    }

    public OrderLearn(Date orderDate, String name) {
        this.orderDate = orderDate;
        this.name = name;
    }

    public OrderLearn(Date orderDate, String name, int userId) {
        this.orderDate = orderDate;
        this.name = name;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLearnId() {
        return learnId;
    }

    public void setLearnId(int learnId) {
        this.learnId = learnId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
