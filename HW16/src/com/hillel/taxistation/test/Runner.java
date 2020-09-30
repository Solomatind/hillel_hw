package com.hillel.taxistation.test;

import java.util.ArrayList;
import java.util.List;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.impl.TaxiStationBolt;
import com.hillel.taxistation.models.Car;
import com.hillel.taxistation.models.Hatchback;
import com.hillel.taxistation.models.Minibus;
import com.hillel.taxistation.models.Sedan;
import com.hillel.taxistation.models.Truck;


public class Runner {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Sedan("Opel Astra", 12_000, 240, 7, 5));
        cars.add(new Minibus("Opel Vivaro", 15_000, 230, 12, 8));
        cars.add(new Hatchback("Toyota Corolla", 17_000, 270, 8.1, 5));
        cars.add(new Truck("Isuzu", 23_000, 150, 16.5, 30_000));
        TaxiStation station = new TaxiStationBolt(cars);
        double sumCostOfStation;
        List<Car> searchedBySpeed;

        sumCostOfStation = station.calculateCostOfTaxiStation();
        station.sortByFuelConsumption();
        System.out.println("Sorted by fuel: ");
        System.out.println(station.getCars());
        searchedBySpeed = station.searchBySpeed(220, 250);
        System.out.println("Summary cost of taxi station = " + sumCostOfStation);
        System.out.println("Sorted by speed: ");
        System.out.println(searchedBySpeed);
    }

}
