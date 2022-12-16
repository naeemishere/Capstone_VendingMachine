package com.techelevator.view;

import junit.framework.TestCase;
import org.junit.Assert;

public class MakeSoundTest extends TestCase {

    public void testMakeSoundChips() {
        String startingWithA = "Crunch Crunch, Yum!";
        Assert.assertEquals(startingWithA, Chips.makeNoise());
    }
    public void testMakeSoundGum() {
        String startingWithA = "Chew Chew, Yum!";
        Assert.assertEquals(startingWithA, Gum.makeNoise());
    }
    public void testMakeSoundSoda() {
        String startingWithA = "Glug Glug, Yum!";
        Assert.assertEquals(startingWithA, Soda.makeNoise());
    }
    public void testMakeSoundCandy() {
        String startingWithA = "Munch Munch, Yum!";
        Assert.assertEquals(startingWithA, Candy.makeNoise());
    }
}
