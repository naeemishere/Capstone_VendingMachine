package com.techelevator.view;

public class Candy extends Items{
    public Candy(double price, String itemName, String placement, String typeOfItem, int quantity) {
        super(price, itemName, placement, typeOfItem, quantity);
    }

    public static String makeNoise(){
        return "\nMunch Munch, Yum!";
    }
}
