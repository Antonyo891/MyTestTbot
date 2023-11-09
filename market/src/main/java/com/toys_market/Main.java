package com.toys_market;

import java.util.PriorityQueue;

import javax.sound.midi.Soundbank;

import org.w3c.dom.events.Event;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Collection;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.toys_market.Accessory.ToysRandom;
import com.toys_market.FileWork.JsonFileWork;
import com.toys_market.Shop.Toy;
import com.toys_market.Shop.ToyController;

public class Main {
    public static void main(String[] args) {
        //Collection<Toy> toysy;
        ToyController toys = new ToyController();
        Toy toy = new Toy(5, "Cat",3);
        Toy toy1 = new Toy(5, "Dog",3);
        Toy toy2 = new Toy(30, "Smurf",3);
        Toy toy3 = new Toy(100, "Tiger",3);
        Toy toy4 = new Toy(30, "Smurf",3);
        toys.AddToy(toy);
        System.out.println(toys);
        toys.AddToy(toy1);
        System.out.println(toys);
        toys.AddToy(toy2);
        toys.AddToy(toy3);
        toys.AddToy(toy4);
        System.out.println(toys);
        JsonFileWork fileWork = new JsonFileWork();
        fileWork.WriteFile("ToysStore.json", toys);
        ToyController toysLoad = fileWork.ReadFile("ToysStore.json");
        System.out.println("--------------------");
        System.out.println(toysLoad);
        toysLoad.RemoveToy(3);
        fileWork.WriteFile("ToysStore.json", toysLoad);
       
}
}