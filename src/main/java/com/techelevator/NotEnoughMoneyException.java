package com.techelevator;

import java.io.IOException;

public class NotEnoughMoneyException extends IOException {

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
