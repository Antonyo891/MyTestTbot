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
        Integer toyId = 1;
        for (Toy items:this.toys){
            if (toyId <= items.getToyId())
                toyId=items.getToyId()+1;
        }
        return toyId;
    }

    public void CreatedToy(String toyName, Integer frequency, Integer amount){
        if ((frequency<0)||(frequency>100))
            throw new ToyFrequencyExeption(
                "Invalid frequency value - " + frequency + 
                "of the " + toyName +
                "A value >" + 
                "0 and less than 100 is allowed", frequency);
        if (amount<=0) 
            throw new ToyExeption("The number of toys must be more than 0");
        boolean toyInShop = false;
        for (Toy item:this.toys){
            if ((item.getToyName().equalsIgnoreCase(toyName))&&
            (item.getFrequency()==frequency)) {
                item.setAmount(item.getAmount()+amount);
                System.out.println("Add "+ 
                amount +" "+ item.getToyName() + ". ");
                toyInShop = true;
            }
        }
        if (!toyInShop){
            this.toys.add(new Toy(this.GetId(),frequency,toyName, amount));
            System.out.println(toyName + " add to the shop.");
        } 
    }

    public void LoadToys(Collection<Toy> toys){
        for (Toy item:toys)
            this.toys.add(item);
    }

    public void AddToy(Toy toy){
        CreatedToy(toy.getToyName(), toy.getFrequency(), toy.getAmount());
        }

    public void AddToys(Collection<Toy> toys){
        for (Toy item: toys)
            AddToy(item);
    }
    /**
     * Return Toy by ToyID
     * @param toyId ToyId
     * @return Toy
     */
    public Toy GetToy(Integer toyId){
        for (Toy item: this.toys)
            if (item.getToyId()==toyId) {
                item.setAmount(item.getAmount()-1);
                //Toy toy = item;
                if (item.getAmount()==0) {
                    System.out.println("The " + item.getToyName()+ 
                    " are out");
                    RemoveToy(toyId);
                    return item;}
                else return item;
            }
        throw new ToyExeption("Toys with ID" + toyId + 
        "are not in the store");
    }
    /**
     * Remove toy by ToyId
     */
    public void RemoveToy(Integer toyId){
        if (!this.toys.removeIf(e->e.getToyId()==toyId))
            throw new ToyExeption("Toys with ID " + toyId + 
        " are not in the store");
    }

    public PriorityQueue<Toy> getToys() {
        return this.toys;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = new PriorityQueue<>(toys);
    }

    @Override
    public String toString() {
        return "{" +
            " toys='" + getToys() + "'" +
            "}";
    }

      
}
