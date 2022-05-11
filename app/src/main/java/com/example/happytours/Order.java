package com.example.happytours;

public class Order {
    private String Orderqty,Price,itemname;

    public Order() { }

    public String getItemname() { return itemname;}

    public void setItemname(String itemname) { this.itemname = itemname; }

    public String getOrderqty() {
        return Orderqty;
    }

    public void setOrderqty(String orderqty) {
        Orderqty = orderqty;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
