package com.techelevator;

import com.techelevator.view.*;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT_OPTION = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT_OPTION };
	//added a exit option

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;
	Scanner userInput = new Scanner(System.in);

	FeedMoneyOption feedMoneyOption = new FeedMoneyOption();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	public void run() {
		double currentMoneyProvided= 0;
		double machineBalance = 0;

		Map <String, Items> testMap = SelectProductOption.selectProduct();

		NumberFormat formatter = NumberFormat.getCurrencyInstance();


		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				while (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)){
					for (Map.Entry<String,Items> str : testMap.entrySet()) {
					System.out.println(str.getKey()+str.getValue());
					}
					break;
				}

//				choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
//				System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
			while (true) {
				String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					// Feed Money Window
					currentMoneyProvided = feedMoneyOption.feedMoney(currentMoneyProvided);
					Log.log(" FEED MONEY " + formatter.format(machineBalance + currentMoneyProvided) + " " + formatter.format(currentMoneyProvided + machineBalance));
					System.out.println("Current Money Provided: " + formatter.format(currentMoneyProvided));
//
				}
				// User selects Select Product
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// If user select Product Window
					while (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						for (Map.Entry<String, Items> str : testMap.entrySet()) {
							System.out.println(str.getKey() + str.getValue());
						}
						System.out.print("Enter Selection Number: ");
						String option = userInput.nextLine();
						// Here Check if the currently provided money is > 0
						if (currentMoneyProvided <= 0) {
							System.out.println("Balance: $0.00, Enter Money to make a purchase! :)");
							purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
						// Checking if user selected item exists inside vending machine
						if (testMap.containsKey(option)) {
							// This is Where we need a functionality of subtracting currently provided money and quantity == , dispense()
							Items vending = testMap.get(option);
							// Check if user doesn't have enough money to make a purchase
							int vendingItem = vending.getAmountOfItems() - 1;
							double itemPrice = vending.getPrice();
							if (currentMoneyProvided < itemPrice) {
								System.out.println("Not enough money to purchase the selected item! Make another Selection or Feed Money!");
								purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
							} else {
								vending.setAmountOfItems(vendingItem);
								currentMoneyProvided = currentMoneyProvided - itemPrice;
							}
							// Print specific make noise sound method
							System.out.println(makeSound(option));
							String itemName = vending.getItemName();
							Log.log(" " + itemName + " " + option + " " + formatter.format(itemPrice) + " " + formatter.format(currentMoneyProvided));
							System.out.println("Remaining Balance: " + formatter.format(currentMoneyProvided));

						} else {
							System.out.println("Key Not found!");
						}
						break;
					}
				}
				// User Selects Finish Transaction (Its own class)
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// Method to return remaining balance into coins
					Log.log(" GIVE CHANGE:" + formatter.format(currentMoneyProvided) + " " + formatter.format(machineBalance));
					feedMoneyOption.balanceToZero(currentMoneyProvided);
					System.out.println("Thank you for making the purchase, Enjoy! :)");
					break;
				}
			}
			} else {
				break;
			}
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	public String makeSound(String placement){
		String purchaseWords = "";
		if(placement.startsWith("A")){
			return Chips.makeNoise();
		} else if (placement.startsWith("B")) {
			return Candy.makeNoise();
		}else if (placement.startsWith("C")){
			return Soda.makeNoise();
		} else if (placement.startsWith("D")) {
			return Gum.makeNoise();
		}
		return purchaseWords;
	}

		public static String getFeedMoneyOption(){
			return PURCHASE_MENU_OPTION_FEED_MONEY;
	}
		public static String getPurchaseMenuOptionSelectProduct(){
			return PURCHASE_MENU_OPTION_SELECT_PRODUCT;
}
		public static String[] getPurchase(){
			return PURCHASE_MENU_OPTIONS;
	}

}