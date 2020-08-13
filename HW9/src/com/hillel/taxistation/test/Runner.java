package com.hillel.taxistation.test;

import java.util.Arrays;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.impl.TaxiStationBolt;
import com.hillel.taxistation.models.Car;
import com.hillel.taxistation.models.Hatchback;
import com.hillel.taxistation.models.Minibus;
import com.hillel.taxistation.models.Sedan;
import com.hillel.taxistation.models.Truck;


public class Runner {

    public static void main(String[] args) {
        Car[] cars = { new Sedan("Opel Astra", 12_000, 240, 7, 5), new Minibus("Opel Vivaro", 15_000, 230, 12, 8),
                new Hatchback("Toyota Corolla", 17_000, 270, 8.1, 5), new Truck("Isuzu", 23_000, 150, 16.5, 30_000) };
        TaxiStation station = new TaxiStationBolt(cars);
        double sumCostOfStation;
        Car[] searchedBySpeed;

        sumCostOfStation = station.calculateCostOfTaxiStation();
        station.sortByFuelConsumption();
        searchedBySpeed = station.searchBySpeed(220, 250);
        System.out.println("Sorted by fuel: ");
        System.out.println(Arrays.toString(cars));
        System.out.println("Summary cost of taxi station = " + sumCostOfStation);
        System.out.println("Sorted by speed: ");
        System.out.println(Arrays.toString(searchedBySpeed));
    }

}
