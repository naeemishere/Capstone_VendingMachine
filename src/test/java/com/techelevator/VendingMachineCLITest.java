package com.techelevator;
import com.techelevator.VendingMachineCLI;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.out;

public class VendingMachineCLITest extends TestCase {
    private VendingMachineCLI vendingMachineCLI;
        @Test
    public void testFeedMoney() {
            InputStream anyInputStream = new ByteArrayInputStream("10".getBytes());

            double value = Double.parseDouble(anyInputStream.toString());
            out.println("Give a number between 1 and 20");
            double output = FeedMoneyOption.feedMoney(value);
            assertEquals("It loading the money",20,output);

    }



}