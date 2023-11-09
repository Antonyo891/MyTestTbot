package com.toys_market.FileWork;

import com.toys_market.Shop.ToyController;

public interface FileWork<T extends ToyController> {
    
    public T ReadFile(String fileName);
    public void WriteFile(String fileName, T toys);
}
