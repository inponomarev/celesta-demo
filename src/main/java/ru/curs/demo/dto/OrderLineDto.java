package ru.curs.demo.dto;

public class OrderLineDto {
    private String itemId;
    private String item_name;
    private int qty;
    private double cost;

    public String getItemId() {
        return itemId;
    }

    public OrderLineDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQty() {
        return qty;
    }

    public OrderLineDto setQty(int qty) {
        this.qty = qty;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public OrderLineDto setCost(double cost) {
        this.cost = cost;
        return this;
    }

}
