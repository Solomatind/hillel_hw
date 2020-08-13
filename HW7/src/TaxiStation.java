
public class TaxiStation {

    private Car[] cars;
    private double costOfTaxiStatio;

    public TaxiStation(Car[] cars) {
        this.cars = cars;
    }

    public TaxiStation() {
    }

    public Car[] getCars() {
        return cars;
    }

    public double getCostOfTaxiStatio() {
        return costOfTaxiStatio;
    }

    public double calculateCostOfTaxiStation() {
        for (Car car : cars) {
            costOfTaxiStatio += car.getCost();
        }
        return costOfTaxiStatio;
    }

    public void sortByFuelConsumption() {
        double temp;
        for (int i = 0; i < cars.length; i++) {
            for (int j = cars.length - 1; j > i; j--) {
                if (cars[j - 1].getFuelConsumption() > cars[j].getFuelConsumption()) {
                    temp = cars[j - 1].getFuelConsumption();
                    cars[j - 1].setFuelConsumption(cars[j].getFuelConsumption());
                    cars[j].setFuelConsumption(temp);
                }
            }
        }
    }

    public Car[] searchBySpeed(double min, double max) {
        Car[] foundCars = {};
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].getSpeed() > min && cars[i].getSpeed() < max)
            foundCars = extendArray(cars[i], foundCars); 
                
            }
        return foundCars;
        }

    private Car[] extendArray(Car findedCar, Car[] coppiedArray) {
        if(coppiedArray == null) {
            coppiedArray[0] = findedCar;
            return coppiedArray;
        } else {
            Car[] extendedArray = new Car[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = findedCar;
            return extendedArray;
        }
    }    

}
