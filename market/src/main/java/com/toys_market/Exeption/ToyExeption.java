package com.toys_market.Exeption;

public class ToyExeption extends RuntimeException{

    /**
     * Toy creation exception
     * @param message - output message
     */
    public ToyExeption(String message) {
        super(message);
    }
    
}
