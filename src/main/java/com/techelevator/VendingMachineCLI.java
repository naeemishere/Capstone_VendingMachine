package com.techelevator;

import com.techelevator.view.*;

import java.text.NumberFormat;
import java.util.*;

import static com.techelevator.FeedMoney.*;


public class VendingMachineCLI {

	public static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	public static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT_OPTION = "Exit";
	public static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT_OPTION};
	public static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	public static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	public static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	public static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	public static Menu menu;
	public static double currentMoneyProvided = 0;
	public static double machineBalance = 0;
	public static Map<String, Items> testMap = SelectProduct.enterProduct();
	public static NumberFormat formatter = NumberFormat.getCurrencyInstance();


	public void run() {

		while (true) {
		String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

		if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			// display vending machine items
			for (Map.Entry<String, Items> str : testMap.entrySet()) {
				System.out.println(str.getKey() + str.getValue());
			}
		} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
			// do purchase
			System.out.println("Current Money Provided: " + formatter.format(currentMoneyProvided));
			String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
			// Feed Money Window
			currentMoneyProvided = feedMoney(currentMoneyProvided);

			// Log Feed Money
			FeedMoneyLog();
			purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			// User Selects Feed Money
			if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				// If already inside the Feed Money Menu and continue from here on:
				// If user selects Feed Money Again:
				FeedMoneyMoreThenOnce(currentMoneyProvided, purchaseMenuChoice);
			}

			// User selects Select Product
			if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				// If user select Product Window
				SelectProduct.SelectProduct(currentMoneyProvided, purchaseMenuChoice);
			}
			// Finish Transaction
			if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				// Method to return remaining balance into coins
				Log.log(" GIVE CHANGE: "+formatter.format(currentMoneyProvided)+" "+formatter.format(machineBalance));
				ReturnChange.balanceToZero(currentMoneyProvided);
				System.out.println("Thank you for making the purchase, Enjoy! :)");
			}
			} else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				// Finish Transaction Window
				break;
			}
		} else {
			break;
		}
		}
}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
