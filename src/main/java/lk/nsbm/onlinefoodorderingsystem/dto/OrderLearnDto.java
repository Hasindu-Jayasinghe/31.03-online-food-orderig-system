package lk.nsbm.onlinefoodorderingsystem.dto;

public class OrderLearnDto {
    private int learnId;
    private String orderDate;
    private String name;

    public OrderLearnDto(int learnId, String orderDate, String name) {
        this.learnId = learnId;
        this.orderDate = orderDate;
        this.name = name;
    }

    public OrderLearnDto() {
    }

    public int getLearnId() {
        return learnId;
    }

    public void setLearnId(int learnId) {
        this.learnId = learnId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "OrderLearnDto{" +
                "learnId=" + learnId +
                ", orderDate='" + orderDate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
