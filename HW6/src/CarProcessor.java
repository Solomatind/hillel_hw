
public class CarProcessor {

    Car[] cars;

    public CarProcessor(Car[] cars) {
        this.cars = cars;
    }

    public CarProcessor() {
        cars = null;
    }

    void screenByBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (car.brand.equals(brand)) {
                printCar(car);
            }
        }
    }

    void screenByBrand(String brand) {
        if (cars == null) {
            System.out.println("An object is null");
        } else {
            for (Car car : cars) {
                if (car.brand.equals(brand)) {
                    printCar(car);
                }
            }
        }
    }

    void screenByModelAndExplPeriod(Car[] cars, String model, int year) {
        for (Car car : cars) {
            if (car.model.equals(model) && (2020 - car.year) > year) {
                printCar(car);
            }
        }
    }

    void screenByModelAndExplPeriod(String model, int year) {
        if (cars == null) {
            System.out.println("An object is null");
        } else {
            for (Car car : cars) {
                if (car.model.equals(model) && (2020 - car.year) > year) {
                    printCar(car);
                }
            }
        }
    }

    void screenByYearAndCost(Car[] cars, int year, double cost) {
        for (Car car : cars) {
            if (car.year == year && car.cost > cost) {
                printCar(car);
            }
        }
    }

    void screenByYearAndCost(int year, double cost) {
        if (cars == null) {
            System.out.println("An object is null");
        } else {
            for (Car car : cars) {
                if (car.year == year && car.cost > cost) {
                    printCar(car);
                }
            }
        }
    }

    void printCar(Car car) {
        System.out.println(car.id + " " + car.brand + " " + car.model + " " + car.year + " " + car.color + " "
                + car.cost + " " + car.registerNumber);
    }

}
