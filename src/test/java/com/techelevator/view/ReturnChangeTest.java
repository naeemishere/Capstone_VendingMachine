package com.techelevator.view;

import com.techelevator.ReturnChange;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ReturnChangeTest extends TestCase {
    @Test
    public void testBalanceToZero() {
        // Arrange
        double money = 4.25;

        // Assert
        Assert.assertEquals(425.0, ReturnChange.balanceToZero(money),0.0);
    }
}
