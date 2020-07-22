
public class CarProcessor {

	void screenByBrand(Car[] cars, String brand) {
		for (Car car : cars) {
			if (car.brand == brand) {
				printCars(car);
			}
		}
	}

	void screenByModelAndExplPeriod(Car[] cars, String model, int year) {
		for (Car car : cars) {
			if (car.model == model && (2020 - car.year) > year) {
				printCars(car);
			}
		}
	}

	void screenByYearAndCost(Car[] cars, int year, double cost) {
		for (Car car : cars) {
			if (car.year == year && car.cost > cost) {
				printCars(car);
			}
		}
	}

	void printCars(Car car) {
		System.out.println(car.id + " " + car.brand + " " + car.model + 
				" " + car.year + " " + car.color + " " + car.cost + 
				" " + car.registerNumber);
	}

}
