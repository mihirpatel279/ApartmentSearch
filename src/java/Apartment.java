/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harshshah2303
 */
public class Apartment {
    
    private String model;
    private String bed;
    private String bath;
    private int sqf;
    private int price;
    
    public Apartment(String m,String bd, String bt, int s, int p)
    {
        model = m;
        bed = bd;
        bath = bt;
        sqf = s;
        price = p;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getBath() {
        return bath;
    }

    public void setBath(String bath) {
        this.bath = bath;
    }

    public int getSqf() {
        return sqf;
    }

    public void setSqf(int sqf) {
        this.sqf = sqf;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
