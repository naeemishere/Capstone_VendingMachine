package com.techelevator.view;

public class Soda extends Items {
    public Soda(double price, String itemName, String placement, String typeOfItem, int quantity) {
        super(price, itemName, placement, typeOfItem, quantity);
    }

    public static String makeNoise(){
        return "Glug Glug, Yum!";
    }

}
