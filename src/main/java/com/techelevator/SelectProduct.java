package com.techelevator;

import com.techelevator.view.Items;

import java.util.Map;
import java.util.Scanner;

import static com.techelevator.FeedMoney.FeedMoneyMoreThenOnce;
import static com.techelevator.VendingMachineCLI.*;

public class SelectProduct {

    public static Map<String, Items> enterProduct(){
        LoggerFile vending = new LoggerFile();
        Map<String,Items> vendingMachineItems  = vending.displayItems();
        vendingMachineItems.putAll(vendingMachineItems);
        return vendingMachineItems;
    }

    public static void SelectProduct(double currentMoneyProvided, String purchaseMenuChoice){

        while (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
            for (Map.Entry<String, Items> str : testMap.entrySet()) {
                System.out.println(str.getKey() + str.getValue());
            }

            System.out.print("Enter Selection Number: ");
            // Here Check if the currently provided money is > 0
            if (currentMoneyProvided <= 0) {
                System.out.println("Balance: $0.00, Enter Money to make a purchase! :)");
            }
            Scanner userInput = new Scanner(System.in);
            String option = userInput.nextLine().toUpperCase();

            // Checking if user selected item exists inside vending machine
            if (testMap.containsKey(option)) {
                // This is Where we need a functionality of subtracting currently provided money and quantity == , dispense()
                Items vending = testMap.get(option);
                int vendingItem = vending.getAmountOfItems();
                double itemPrice = vending.getPrice();

                if(vendingItem == 0) {
                    System.out.println(option+ " Item SOLD OUT, Make another selection!");
                    vending.setAmountOfItems(0);
                } else {
                    vendingItem--;
                    // Check if user doesn't have enough money to make a purchase
                    if (currentMoneyProvided > itemPrice) {
                        vending.setAmountOfItems(vendingItem);
                        currentMoneyProvided = currentMoneyProvided - itemPrice;
                        System.out.println(Items.makeSound(option));
//                        Items.playMusic("C:\\Users\\psoab\\Desktop\\Merit\\Pair Programming\\module-1-capstone\\Audio\\vendingmachine-104482.wav");
                    } else {
                        System.out.println("Not enough money to purchase the selected item! Make another Selection or Feed Money!");
//                        purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    }
                    // Print specific make noise sound method
                    String itemName = vending.getItemName();
                    Log.log(" " + itemName + " " + option + " " + formatter.format(itemPrice) + " " + formatter.format(currentMoneyProvided));
                    System.out.println("Remaining Balance: " + formatter.format(currentMoneyProvided));
                }
            } else {
                    System.out.println("Item Not found!");
            }
            purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
        }

        // Feed More Money
        if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
            FeedMoneyMoreThenOnce(currentMoneyProvided, purchaseMenuChoice);
        }

        // Finish Transaction
        if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
            // Method to return remaining balance into coins
            Log.log(" GIVE CHANGE: "+formatter.format(currentMoneyProvided)+" "+formatter.format(machineBalance));
            Log.log(" ***********************");
            Log.log(" End of the transaction!");
            Log.log(" ***********************");
            ReturnChange.balanceToZero(currentMoneyProvided);
            System.out.println("Thank you for making the purchase, Enjoy! :)");
        }
    }
}
