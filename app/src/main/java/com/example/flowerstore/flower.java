package com.example.flowerstore;

public class flower {
    String idflower,nameflower,category,color,imgflower;
    int price;

    public flower(String idflower, String nameflower, String category, String color, String imgflower, int price) {
        this.idflower = idflower;
        this.nameflower = nameflower;
        this.category = category;
        this.color = color;
        this.imgflower = imgflower;
        this.price = price;
    }
    public flower(){

    }

    public String getIdflower() {
        return idflower;
    }

    public void setIdflower(String idflower) {
        this.idflower = idflower;
    }

    public String getNameflower() {
        return nameflower;
    }

    public void setNameflower(String nameflower) {
        this.nameflower = nameflower;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImgflower() {
        return imgflower;
    }

    public void setImgflower(String imgflower) {
        this.imgflower = imgflower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
