package com.hillel.flowers.entity;

import com.hillel.flowers.exception.InvalidStemLengthException;

public class Bouquet {

    private Flower[] flowers;
    private Accessory[] accessories;

    public void addFlower(Flower flower) {
        flowers = (Flower[]) flower.extendArray(flower, flowers);
    }

    public void addAccessory(Accessory accessory) {
        accessories = (Accessory[]) accessory.extendArray(accessory, accessories);
    }
    
    public Object[] extendArray(Object bouquet, Object[] coppiedArray) {
        if (coppiedArray == null) {
            Bouquet[] extendedArray = new Bouquet[1];
            extendedArray[0] = (Bouquet) bouquet;
            return extendedArray;
        } else {
            Bouquet[] extendedArray = new Bouquet[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = (Bouquet) coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = (Bouquet) bouquet;
            return extendedArray;
        }
    }

    public double getPriceOfBouquet() {
        double priceOfBouquet = 0;
        if (flowers != null) {
            for (Flower flower : flowers) {
                priceOfBouquet += flower.getCost();
            }
        }
        if (accessories != null) {
            for (Accessory accessory : accessories) {
                priceOfBouquet += accessory.getCost();
            }
        }
        return priceOfBouquet;
    }

    public void sortFlowers() {
        Flower temp;
        for (int i = 0; i < getFlowers().length; i++) {
            for (int j = getFlowers().length - 1; j > i; j--) {
                if (getFlowers()[j - 1].getDaysToLife() > getFlowers()[j].getDaysToLife()) {
                    temp = getFlowers()[j - 1];
                    getFlowers()[j - 1] = getFlowers()[j];
                    getFlowers()[j] = temp;
                }
            }
        }
    }

    public Flower[] filterFlowersByStemLength(int minLength, int maxLength) throws InvalidStemLengthException {
        if (minLength < 0 || maxLength < 0) {
            throw new InvalidStemLengthException(minLength, maxLength);
        }
        Flower[] filteredFlowers = null;
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                filteredFlowers = (Flower[]) flower.extendArray(flower, filteredFlowers);
            }
        }
        return filteredFlowers;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory[] accessories) {
        this.accessories = accessories;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flowers:\n");
        if (flowers != null) {
            for (Flower flower : flowers) {
                sb.append("\t");
                sb.append(flower.toString());
            }
        }
        sb.append("Accessories:\n");
        if (accessories != null) {
            for (Accessory accessory : accessories) {
                sb.append("\t");
                sb.append(accessory.toString());
            }
        }
        return sb.toString();

    }

}
