package com.toys_market.Exeption;

public class ToyFrequencyExeption extends ToyExeption {

    private Integer frequency;
    /**
     * Invalid value of frequency
     * @param message Output message
     */
    public ToyFrequencyExeption(String message, Integer frequency) {
        super(message);
        this.frequency = frequency;
    }
    
    public Integer getFrequency(){
        return this.frequency;
    }
}
