
abstract public class PassengerCar extends Car {

    private int countOfPassengerSeats;

    public PassengerCar(String mark, double cost, double speed, double fuelConsumption, int countOfPassengerSeats) {
        super(mark, cost, speed, fuelConsumption);
        this.countOfPassengerSeats = countOfPassengerSeats;
    }

    public PassengerCar() {
    }

    public String toString() {
        String result = String.format(
                "Mark: %s Cost: %.2f $ Speed:  %.2f km/h "
                        + "Fuel Consumption:  %.2f l/100km Count of passenger seats: %d",
                super.getMark(), super.getCost(), super.getSpeed(), super.getFuelConsumption(), countOfPassengerSeats);
        return result;
    }

}
