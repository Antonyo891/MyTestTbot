package com.toys_market;

import java.util.PriorityQueue;
import java.util.Collection;
import com.toys_market.Shop.Toy;

public class Main {
    public static void main(String[] args) {
        //Collection<Toy> toysy;
        PriorityQueue<Toy> toys = new PriorityQueue<>();
        Toy toy = new Toy(1, 30, "Cat");
        Toy toy1 = new Toy(2, 25, "Dog");
        Toy toy2 = new Toy(3, 30, "Smurf");
        Toy toy3 = new Toy(4, 15, "Tiger");
        toys.add(toy);
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        boolean True = true;
        for (Toy item:toys) 
            System.out.println(item);
        System.out.println(toys.removeIf(e -> e.getToyId()==3));
        while (True) {
            if (toys.peek()!=null) 
            System.out.println(toys.poll());
            else
                True=false;//toys.peek();
            }
}
}