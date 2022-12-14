package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Items {
    private double price;
    private String itemName;
    private String placement;
    private String typeOfItem;
    public int amountOfItems=5;

    public void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPlacement() {
        return placement;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    @Override
    public String toString() {
        //String.format("%,.2f", amount));
        return  "|"+itemName+"|"+ String.format("%.2f",price)+"|"+ typeOfItem+"|Q:"+amountOfItems;

    }

    public Items(double price, String itemName, String placement, String typeOfItem, int quantity) {
        this.amountOfItems = quantity;
        this.price = price;
        this.itemName = itemName;
        this.placement = placement;
        this.typeOfItem = typeOfItem;
    }
}
