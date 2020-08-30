package com.hillel.taxistation.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.dataio.DataReader;
import com.hillel.taxistation.dataio.DataWriter;
import com.hillel.taxistation.impl.TaxiStationBolt;
import com.hillel.taxistation.models.Car;

public class Runner {

    public static void main(String[] args) {
        DataReader dr = new DataReader(new File("inputcars.txt"));
        Car[] cars = null;
        try {
            cars = dr.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TaxiStation station = new TaxiStationBolt(cars);
        double sumCostOfStation;
        Car[] searchedBySpeed;

        sumCostOfStation = station.calculateCostOfTaxiStation();
        station.sortByFuelConsumption();
        searchedBySpeed = station.searchBySpeed(220, 250);
        DataWriter dw = new DataWriter(station.getCars());
        try {
            dw.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sorted by fuel: ");
        System.out.println(Arrays.toString(cars));
        System.out.println("Summary cost of taxi station = " + sumCostOfStation);
        System.out.println("Sorted by speed: ");
        System.out.println(Arrays.toString(searchedBySpeed));
    }

}
