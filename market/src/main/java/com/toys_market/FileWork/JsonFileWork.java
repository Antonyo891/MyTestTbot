package com.toys_market.FileWork;

import java.util.Collection;
import java.util.PriorityQueue;

import com.google.gson.Gson;
import com.toys_market.Shop.Toy;

public class JsonFileWork implements FileWork {

    @Override
    public Gson ReadFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ReadFile'");
    }

    @Override
    public void WriteFile(Collection<Object> o) {
        PriorityQueue <Toy> toys= (PriorityQueue) o;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'WriteFile'");
    }
    
}
