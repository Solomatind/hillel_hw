package com.hillel.taxistation.impl;

import java.util.ArrayList;
import java.util.Collections;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.function.CarComparator;
import com.hillel.taxistation.models.Car;

public class TaxiStationBolt implements TaxiStation {

    private ArrayList<Car> cars;

    public TaxiStationBolt() {
    }

    public TaxiStationBolt(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public double calculateCostOfTaxiStation() {
        double costOfTaxiStation = 0;
        for (Car car : cars) {
            costOfTaxiStation += car.getCost();
        }
        return costOfTaxiStation;
    }

    public ArrayList<Car> searchBySpeed(double min, double max) {
        ArrayList<Car> foundCars = new ArrayList<>();
        for (Car car : cars ) {
            if (car.getSpeed() > min && car.getSpeed() < max)
                foundCars.add(car);
        }
        return foundCars;
    }

    public void sortByFuelConsumption() {
        Collections.sort(cars, CarComparator::compare);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars.addAll(cars);
    }

}
