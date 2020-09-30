package com.hillel.taxistation;

import java.util.List;

import com.hillel.taxistation.models.Car;

public interface TaxiStation {
    double calculateCostOfTaxiStation();
    List<Car> searchBySpeed(double min, double max);
    void sortByFuelConsumption();
    List<Car> getCars();
}
