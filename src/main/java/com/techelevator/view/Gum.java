package com.techelevator.view;

public class Gum extends Items {
    public Gum(double price, String itemName, String placement, String typeOfItem, int quantity) {
        super(price, itemName, placement, typeOfItem, quantity);
    }

    public static String makeNoise(){
        return "Chew Chew, Yum!";
    }

}
