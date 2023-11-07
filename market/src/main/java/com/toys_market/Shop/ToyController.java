package com.toys_market.Shop;
import java.util.Collection;
import java.util.PriorityQueue;

import com.toys_market.Exeption.ToyExeption;
import com.toys_market.Exeption.ToyFrequencyExeption;

public class ToyController {
    private PriorityQueue<Toy> toys;

    public ToyController() {
        this.toys = new PriorityQueue<>();
    }

    private Integer GetId(){
        if (this.toys==null)
            return 1;
        Integer toyId = 0;
        for (Toy items:this.toys){
            if (toyId <= items.getToyId())
                toyId=items.getToyId();
        }
        return toyId;
    }

    public void CreatedToy(String toyName, Integer frequency){
        Integer toyId= GetId();
        if ((frequency<0)||(frequency>100))
            throw new ToyFrequencyExeption(
                "Invalid frequency value - " + frequency + 
                "A value >" + 
                "0 and less than 100 is allowed", frequency);
        Toy toy = new Toy(toyId, frequency, toyName);
        this.toys.add(toy); 
    }

    public void AddToy(Toy toy){
        this.toys.add(toy);
    }

    public void AddToys(Collection<Toy> toys){
        this.toys.addAll(toys);
    }

    public Toy GetToy(Integer toyId){
        //Toy toy;
        for (Toy item: this.toys)
            if (item.getToyId()==toyId)
                return item;
        throw new ToyExeption("Toys with ID" + toyId + 
        "are not in the store");
    }

    public PriorityQueue<Toy> getToys() {
        return this.toys;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = new PriorityQueue<>(toys);
    }
      
}
