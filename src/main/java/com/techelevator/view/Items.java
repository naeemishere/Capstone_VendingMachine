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
    private int amountOfItems=5;

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
        return  "|"+itemName+"|"+ String.format("%.2f",price)+"|"+ typeOfItem;

    }

    public Items(double price, String itemName, String placement, String typeOfItem) {
        this.price = price;
        this.itemName = itemName;
        this.placement = placement;
        this.typeOfItem = typeOfItem;
    }

    public static List <String> displayItems() {
        String inputFile = "vendingmachine.csv";
        File file = new File(inputFile);
        List<String> itemLine = new ArrayList<>();
        try (Scanner vendingItems = new Scanner(file)) {
            while (vendingItems.hasNextLine()) {
                itemLine.add(vendingItems.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
//        for (String str : itemLine) {
//            System.out.println(str);
//        }
	return itemLine;

}
}
