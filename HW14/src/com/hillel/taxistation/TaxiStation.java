package com.hillel.taxistation;

import com.hillel.taxistation.models.Car;

public interface TaxiStation {
    double calculateCostOfTaxiStation();
    Car[] searchBySpeed(double min, double max);
    void sortByFuelConsumption();
    void sortByFuelConsumptionWithLambda();
    void sortByFuelConsumptionWithReference();
}
