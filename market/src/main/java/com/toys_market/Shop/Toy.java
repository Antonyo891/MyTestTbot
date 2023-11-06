package com.toys_market.Shop;
/**
 * Toy for shop
 */
public class Toy implements Comparable<Toy> {
    private Integer toyId,frequency;
    private String toyName;


    public Toy(Integer toyId, Integer frequency, String toyName) {
        this.toyId = toyId;
        this.frequency = frequency;
        this.toyName = toyName;
    }


    public Integer getToyId() {
        return this.toyId;
    }

    public void setToyId(Integer toyId) {
        this.toyId = toyId;
    }

    public Integer getFrequency() {
        return this.frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getToyName() {
        return this.toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public int compareTo(Toy o) {
        /* if (this.frequency< o.getFrequency())
            return -1;
        if (this.frequency== o.getFrequency())
            return 0;
        if (this.frequency> o.getFrequency())
            return 1; */
        return Integer.compare(this.frequency, o.getFrequency());        
    }

    @Override
    public String toString() {
        return "{" +
            " toyId='" + getToyId() + "'" +
            ", frequency='" + getFrequency() + "'" +
            ", toyName='" + getToyName() + "'" +
            "}";
    }


    


}
