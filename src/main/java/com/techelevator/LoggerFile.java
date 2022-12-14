package com.techelevator;

import com.techelevator.view.Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoggerFile {

    public Map<String, Items> displayItems() {
        String inputFile = "vendingmachine.csv";
        File file = new File(inputFile);
        Map<String,Items> itemLine = new TreeMap<>();
        try (Scanner vendingItems = new Scanner(file)) {
            while (vendingItems.hasNextLine()) {
                String inventory = vendingItems.nextLine();
                String[] strArray = inventory.split("\\|");
                String itemSlot = strArray[0];
                String itemName = strArray[1];
                double itemPrice = Double.parseDouble(strArray[2]);
                String itemCategory = strArray[3];
                int itemQuantity = 5;
                Items item = new Items(itemPrice, itemName, itemSlot, itemCategory, itemQuantity);
                itemLine.put(itemSlot, item);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return itemLine;
    }

}
