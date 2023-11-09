package com.toys_market.Presenter;

import java.util.ArrayList;

import com.toys_market.Accessory.ToyParser;
import com.toys_market.Accessory.ToysRandom;
import com.toys_market.Exeption.ToyFrequencyException;
import com.toys_market.Exeption.ToyParseException;
import com.toys_market.FileWork.JsonFileWork;
import com.toys_market.Shop.Toy;
import com.toys_market.Shop.ToyController;
import com.toys_market.View.ConsoleView;

public class PresenterConsole {
    private ConsoleView view;
    private ToyController toys;
    private ToyController wonToys;
    private JsonFileWork fileWork;
    private ToysRandom toysRandom;


    public PresenterConsole(ConsoleView view, JsonFileWork fileWork, ToysRandom toysRandom) {
        this.view = view;
        this.fileWork = fileWork;
        this.toysRandom = toysRandom;
        toys = new ToyController();
        wonToys = new ToyController();
    }

    public void CreateToy(){
        view.Set("Enter name of toy, loss frequency(0...100) and amount(>0) of toys via space: \n"+
                    "Name 35 2 \n");
        while (true)
        try {
            Toy toy = new ToyParser().Parse(view.Get());
            toys.AddToy(toy);
            break;
        } catch (ToyParseException e) {
            view.Set("Re-enter (Name 35 2): ");
        }        
    }

    public void LoadToys(){
        this.toys = fileWork.ReadFile("ToysInShop.json");
        this.wonToys = fileWork.ReadFile("WonToys.json");
    }

    public void SaveToys(){
        fileWork.WriteFile("ToysInShop.json",toys);
        fileWork.WriteFile("WonToys.json",toys);
    }

    public void RemoveToy(){
        ArrayList<Integer> toyId = ShowToy();
        view.Set("Enter number of toy for remove this toy: ");
        while (true) {
            try {
                Integer IdToRemove = toyId.get(Integer.parseInt(view.Get())-1);
                this.toys.RemoveToy(IdToRemove);
                break;
            } catch (RuntimeException e) {
                view.Set("Re-enter number of toy for remove ");
            }  
        }
    }

    private ArrayList<Integer> ShowToy(){
        ArrayList<Integer> toyId = new ArrayList<>();
        int i = 1;
        for (Toy toy: this.toys.getToys()){
            view.Set(i + ".) " + toy.getToyName() + "\n");
            toyId.add(toy.getToyId());
        }
        return toyId;
    }

    public void EditFrequencyToy(){
        ArrayList<Integer> toyId = ShowToy();
        view.Set("Enter number of toy for edit frequency: ");
        while (true) {
            try {
                Integer IdToRemove = toyId.get(Integer.parseInt(view.Get())-1);
                Toy editToy = this.toys.SearchToy(IdToRemove);
                view.Set(editToy.getToyName() + 
                    " have frequency = " + editToy.getFrequency() + ".");
                view.Set("Enter new frequency");
                try {
                    Integer newFrequency = Integer.parseInt(view.Get());
                    editToy.setFrequency(newFrequency);
                    this.toys.AddToy(editToy);
                    this.toys.RemoveToy(IdToRemove);
                    view.Set("The changes were completed correctly");
                    break;
                }
                catch (RuntimeException e) {
                    view.Set("Frequency entered incorrectly");
                } 
            } catch (RuntimeException e) {
                view.Set("Re-enter number of toy for remove ");
            }  
        }
    }

    public void PlayToy(){
        view.Set("Lets go");
        Integer winId = this.toysRandom.GetRandom(toys.getToys());
        Toy wonToy = this.toys.GetToy(winId);
        wonToy.setAmount(1);
        view.Set("You are win " + wonToy.getToyName() + ".");
        this.wonToys.AddToy(wonToy);

    }

}
