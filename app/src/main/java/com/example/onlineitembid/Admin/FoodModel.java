package com.example.onlineitembid.Admin;

public class FoodModel {
    private String foodName;
    private String foodDesc;
    private String foodPrice;
    private String username;
    private String foodImage;
    private String phoneNumber;
    private boolean isApproved;

    // Default constructor for Firebase
    public FoodModel() {
    }

    public FoodModel(String foodName, String foodDesc, String foodPrice, String username, String foodImage, String phoneNumber, boolean isApproved) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodPrice = foodPrice;
        this.username = username;
        this.foodImage = foodImage;
        this.phoneNumber = phoneNumber;
        this.isApproved = isApproved;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
