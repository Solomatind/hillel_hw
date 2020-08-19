package com.hillel.flowers.entity;

import com.hillel.flowers.utils.ArrayUtils;

public class Accessory implements ArrayUtils {

    private String name;
    private double price;

    public Accessory(String name, double cost) {
        this.name = name;
        this.price = cost;
    }
    
    public Object[] extendArray(Object accessory, Object[] coppiedArray) {
        if (coppiedArray == null) {
            Accessory[] extendedArray = new Accessory[1];
            extendedArray[0] = (Accessory) accessory;
            return extendedArray;
        } else {
            Accessory[] extendedArray = new Accessory[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = (Accessory) coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = (Accessory) accessory;
            return extendedArray;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return price;
    }

    public void setCost(double cost) {
        this.price = cost;
    }

    public String toString() {
        return name + " [price=" + price + "]\n";
    }

}
