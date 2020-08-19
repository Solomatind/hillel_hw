package com.hillel.flowers.worker;

import com.hillel.flowers.entity.Bouquet;

public class FlowersShop {

    private Bouquet[] bouquets;

    public double getPriceOfBouquets() {
        double priceOfBouquets = 0;
        for (Bouquet bouquet : bouquets) {
            priceOfBouquets += bouquet.getPriceOfBouquet();
        }
        return priceOfBouquets;
    }

    public void addBouquet(Bouquet bouquet) {
        bouquets = (Bouquet[]) bouquet.extendArray(bouquet, bouquets);
    }
    
    public Bouquet[] getBouquets() {
        return bouquets;
    }

    public void setBouquets(Bouquet[] bouquets) {
        this.bouquets = bouquets;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Bouquet bouquet : bouquets) {
            if (bouquet != null)
                sb.append(bouquet.toString());
        }
        return sb.toString();
    }

}
