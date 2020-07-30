
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

    public Car[] sortByFuelConsumption() {
        Car[] result = cars;
        double temp;
        for (int i = 0; i < result.length; i++) {
            for (int j = result.length - 1; j > i; j--) {
                if (result[j - 1].getFuelConsumption() > result[j].getFuelConsumption()) {
                    temp = result[j - 1].getFuelConsumption();
                    result[j - 1].setFuelConsumption(result[j].getFuelConsumption());
                    result[j].setFuelConsumption(temp);
                }
            }
        }
        return result;
    }

    public Car[] searchBySpeed(double min, double max) {
        Car[] arrayForCopy = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            if (min < cars[i].getSpeed() && cars[i].getSpeed() < max) {
                arrayForCopy[i] = cars[i];
            }
        }
        return arrayCopy(arrayForCopy);
    }

    private Car[] arrayCopy(Car[] cars) {
        Car[] result = {};
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                result = new Car[i + 1];
                for (int j = 0; j < cars.length; j++) {
                    if (j != result.length) {
                        result[j] = cars[j];
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }

        }
        return result;
    }

}
