package lk.nsbm.onlinefoodorderingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FoodTitle {
    @Id
    private int titleId;
    private String name;
    @OneToMany
    private List<Food> foodList;

    public FoodTitle() {
    }

    public FoodTitle(int titleId) {
        this.titleId = titleId;
    }

    public FoodTitle(int titleId, String name, List<Food> foodList) {
        this.titleId = titleId;
        this.name = name;
        this.foodList = foodList;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
