package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;

import static com.techelevator.VendingMachineCLI.*;
import static com.techelevator.VendingMachineCLI.currentMoneyProvided;

public class FeedMoney {
	public static double feedMoney(double currentMoney) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Insert Money ($1s, $5s, or $10s): ");
		double fedMoney = currentMoney + sc.nextDouble();
		return fedMoney;
	}

	public static double FeedMoneyMoreThenOnce(double currentMoneyProvided, String purchaseMenuChoice) {

		if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

			while (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

				currentMoneyProvided = feedMoney(currentMoneyProvided);
				Log.log(" FEED MONEY "+formatter.format(currentMoneyProvided)+" "+formatter.format(currentMoneyProvided));
				if (currentMoneyProvided > 20) {

					System.out.println("Can't insert money more then $20!");
					currentMoneyProvided = 0;
				}
				System.out.println("Current Money Provided: " + formatter.format(currentMoneyProvided));
				purchaseMenuChoice = (String) menu.getChoiceFromOptions(VendingMachineCLI.PURCHASE_MENU_OPTIONS);
			}

			if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				SelectProduct.SelectProduct(currentMoneyProvided, purchaseMenuChoice);
			}
		}
			return currentMoneyProvided;
		}

	public static void FeedMoneyLog(){
		machineBalance = currentMoneyProvided;
		Log.log("***** NEW TRANSACTION *****");
		Log.log(" FEED MONEY "+formatter.format(currentMoneyProvided)+" "+formatter.format(currentMoneyProvided));
		System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
	}
}
