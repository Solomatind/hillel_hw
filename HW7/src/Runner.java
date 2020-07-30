
public class Runner {

    public static void main(String[] args) {
        Car[] cars = { new Sedan("Opel Astra", 12_000, 240, 7, 5), new Minibus("Opel Vivara", 15_000, 230, 12, 8),
                new Hatchback("Toyota Corolla", 17_000, 270, 8.1, 5), new Truck("Isuzu", 23_000, 150, 16.5, 30_000) };
        TaxiStation station = new TaxiStation(cars);
        double sumCostOfStation;
        Car[] sortedCars;

        sumCostOfStation = station.calculateCostOfTaxiStation();
        cars = station.sortByFuelConsumption();
        sortedCars = station.searchBySpeed(220, 250);
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
        System.out.println("Summary cost of taxi station = " + sumCostOfStation);
        System.out.println();
        System.out.println("Sorted by fuel: ");
        for (Car car : sortedCars) {
            System.out.println(car.toString());
        }

    }

}
