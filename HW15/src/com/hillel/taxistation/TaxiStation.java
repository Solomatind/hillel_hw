package com.hillel.taxistation;

import java.util.ArrayList;

import com.hillel.taxistation.models.Car;

public interface TaxiStation {
    double calculateCostOfTaxiStation();
    ArrayList<Car> searchBySpeed(double min, double max);
    void sortByFuelConsumption();
    ArrayList<Car> getCars();
}
