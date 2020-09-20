package com.hillel.taxistation.function;

import com.hillel.taxistation.models.Car;

public class CarComparator {
    
    public static int compare(Car car1, Car car2) {
        return Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption());
    }

}
