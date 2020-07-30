
public class Truck extends Car {

    private double carryingСapacity;

    public Truck() {
    }

    public Truck(String mark, double cost, double speed, double fuelConsumption, double carryingCapacity) {
        super(mark, cost, speed, fuelConsumption);
        this.carryingСapacity = carryingCapacity;
    }

    public String toString() {
        String result = String.format(
                "Mark: %s Cost:  %.2f $ Speed:  %.2f km/h "
                        + "Fuel Consumption:  %.2f l/100km Carrying Capacity:  %.2f kg",
                super.getMark(), super.getCost(), super.getSpeed(), super.getFuelConsumption(), carryingСapacity);
        return result;
    }
}
