package com.hillel.flowers.entity;

import com.hillel.flowers.utils.ArrayUtils;

public class Flower implements ArrayUtils {

    private String name;
    private int daysToLive;
    private int stemLength;
    private double price;

    public Flower(String name, int daysToLife, int stemLength, double cost) {
        this.name = name;
        this.daysToLive = daysToLife;
        this.stemLength = stemLength;
        this.price = cost;
    }
    
    public Object[] extendArray(Object flower, Object[] coppiedArray) {
        if (coppiedArray == null) {
            Flower[] extendedArray = new Flower[1];
            extendedArray[0] = (Flower) flower;
            return extendedArray;
        } else {
            Flower[] extendedArray = new Flower[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = (Flower) coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = (Flower) flower;
            return extendedArray;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysToLife() {
        return daysToLive;
    }

    public void setDaysToLife(int daysToLife) {
        this.daysToLive = daysToLife;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    public double getCost() {
        return price;
    }

    public void setCost(double cost) {
        this.price = cost;
    }

    public String toString() {
        return name + " [price=" + price + ", " + "daysToLive=" + daysToLive + ", " + "stemLength=" + stemLength
                + "]\n";
    }

}
