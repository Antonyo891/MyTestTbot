package com.toys_market.Shop;

import java.util.PriorityQueue;

public class ToyController {
    private PriorityQueue<Toy> toys;
    private Integer toyId;

    public ToyController() {
        this.toys = new PriorityQueue<>();
    }

    private Integer GetToyId(){
        if (this.toyId==null)
            this.toyId = 0;
        this.toyId++;
        return this.toyId;
    }

    public void Created(String toyName, Integer frequency){
        toyId= GetToyId();
        Toy toy = new Toy(toyId, frequency, toyName);
        this.toys.add(toy); 
    }

    
}
