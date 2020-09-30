package com.hillel.taxistation.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.hillel.taxistation.TaxiStation;
import com.hillel.taxistation.function.CarComparator;
import com.hillel.taxistation.models.Car;

public class TaxiStationBolt implements TaxiStation {

    private List<Car> cars;

    public TaxiStationBolt() {
    }

    public TaxiStationBolt(List<Car> cars) {
        this.cars = cars;
    }

    public double calculateCostOfTaxiStation() {
        return cars.stream().mapToDouble(Car::getCost).sum();
    }

    public List<Car> searchBySpeed(double min, double max) {
        return cars.stream().filter((c) -> (c.getSpeed() > min && c.getSpeed() < max)).collect(Collectors.toList());
    }

    public void sortByFuelConsumption() {
        cars = cars.stream().sorted(CarComparator::compare).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

}
