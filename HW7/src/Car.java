
abstract public class Car {

    private String mark;
    private double cost;
    private double speed;
    private double fuelConsumption;

    public Car(String mark, double cost, double speed, double fuelConsumption) {
        this.mark = mark;
        this.cost = cost;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
    }

    public Car() {
    }

    public double getCost() {
        return cost;
    }

    public String getMark() {
        return mark;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract String toString();

}
