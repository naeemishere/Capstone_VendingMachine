package com.techelevator;

public class ReturnChange {
    public static double balanceToZero(double amount) {
        double convert = amount * 100;
        int quarters = (int) (convert / 25);
        int tempAmount = (int) (convert % 25);
        int dimes = tempAmount / 10;
        int tempAmount2 = tempAmount % 10;
        int nickles = tempAmount2 / 5;
        int tempAmount3 = tempAmount2 % 5;
        System.out.println("Return change: "+"\n"+"Quarters: "+quarters+"\n"+"Dimes: "+dimes+"\n"+"Nickles: "+nickles);
        return convert;
    }
}
