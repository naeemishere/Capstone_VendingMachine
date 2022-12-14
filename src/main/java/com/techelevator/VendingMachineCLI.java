package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.text.NumberFormat;
import java.util.*;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_OPTION = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_OPTION };
	//added a exit option



	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	Scanner userInput = new Scanner(System.in);

	LoggerFile vending = new LoggerFile();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		int currentMoneyProvided= 0;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

 		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
					System.out.println(str.getKey()+str.getValue());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
				String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					// Feed Money Window
					currentMoneyProvided = feedMoney(currentMoneyProvided);
					System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
					purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					// If already inside the Feed Money Menu and continue from here on:
					// If user selects Feed Money
					while(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						currentMoneyProvided = feedMoney(currentMoneyProvided);
						purchaseMenuChoice = PURCHASE_MENU_OPTION_SELECT_PRODUCT;
						System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
						purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}


				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

					// If user select Product Window
					while(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
							System.out.println(str.getKey()+str.getValue());
						}
						purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						System.out.print("Enter Selection Number: ");
						String option = userInput.nextLine();

						if(vendingMachineItems.containsKey(option)){
							System.out.println("It works!");
						} else {
							System.out.println("Key Not found!");
						}
						purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}




				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// Finish Transaction Window
					break;
				}
			}
		}
	}
	Map<String,Items> vendingMachineItems  = vending.displayItems();
	//made a map to hold the items after the string[] made.
	//String itemName, String placement, String typeOfItem

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	public static int feedMoney(int currentMoney) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Insert Money ($1s, $5s, or $10s): ");
		return currentMoney + sc.nextInt();
	}

}
