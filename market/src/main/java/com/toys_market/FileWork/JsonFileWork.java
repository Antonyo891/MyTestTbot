package com.toys_market.FileWork;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.toys_market.Shop.ToyController;

public class JsonFileWork implements FileWork {
    Gson gson;

    @Override
    public ToyController ReadFile(String fileName) {
        gson = new Gson();
        try(FileReader reader = new FileReader(fileName)) {
            ToyController toys = gson.fromJson(reader, ToyController.class);
            System.out.println("Data was successfully downloaded to the "+ fileName);
            return toys;
        } catch (IOException e) {
            System.out.println("Loading exception");
        }
        return null;
    }

    @Override
    public void WriteFile(String fileName, ToyController toys) {
        gson = new Gson();
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write(gson.toJson(toys));
            System.out.println("Data was successfully written to the "+ fileName);
        } catch (IOException e) {
            System.out.println("Loading exception");
        }
    }
    
}
