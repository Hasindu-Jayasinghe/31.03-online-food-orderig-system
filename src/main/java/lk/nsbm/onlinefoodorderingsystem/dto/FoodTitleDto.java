package lk.nsbm.onlinefoodorderingsystem.dto;

import java.util.List;

public class FoodTitleDto {
    private int titleId;
    private String name;
    private List<FoodDto> foodList;

    public FoodTitleDto() {
    }

    public FoodTitleDto(int titleId, String name) {
        this.titleId = titleId;
        this.name = name;
    }

    public FoodTitleDto(int titleId, String name, List<FoodDto> foodList) {
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

    public List<FoodDto> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodDto> foodList) {
        this.foodList = foodList;
    }
}
