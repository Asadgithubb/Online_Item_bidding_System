package com.example.onlineitembid.Model;

public class ProductModel {

    private String bidId;
    private String id;
    private String username;
    private String phoneNumber;
    private String foodImage;
    private String foodName;
    private String foodDesc;
    private String foodPrice;
    private String bidder;
    private String bid;
    private boolean isApproved;

    private String restaurantKey;
    private String foodKey;
    private String sellerId;
    public String getBidder() {
        return bidder;
    }
    public void setBidder(String bidder) {
        this.bidder = bidder;
    }
    public String getBid() {
        return bid;
    }
    public void setBid(String bid) {
        this.bid = bid;
    }
    public ProductModel(String  sellerId,String id, String username, String phoneNumber, String foodImage, String foodName, String foodDesc, String foodPrice, String bidder, String bid,boolean isApproved) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodPrice = foodPrice;
        this.bidder = bidder;
        this.bid = bid;
        this.isApproved = isApproved;
        this.sellerId = sellerId;

    }


    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
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

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getRestaurantKey() {
        return restaurantKey;
    }

    public void setRestaurantKey(String restaurantKey) {
        this.restaurantKey = restaurantKey;
    }

    public String getFoodKey() {
        return foodKey;
    }

    public void setFoodKey(String foodKey) {
        this.foodKey = foodKey;
    }

    public ProductModel() {
    }

    public ProductModel(String pushKey,String id, String username, String phoneNumber, String foodImage, String foodName, String foodDesc, String foodPrice,boolean isApproved) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodPrice = foodPrice;
        this.isApproved = isApproved;
    }
}