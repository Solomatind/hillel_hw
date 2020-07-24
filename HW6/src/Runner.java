
public class Runner {

    public static void main(String[] args) {
        Car[] cars = { new Car(0, "Ford", "Mustang", 2015, "Red", 18_000.00, "AK0965BN"),
                new Car(1, "Chevrolet", "Camaro", 2012, "Yellow", 15_250.00, "AH0777KL"),
                new Car(2, "Dodge", "Chalenger", 2016, "Black", 30_900.00, "KK6893LK"),
                new Car(3, "Ford", "F-150", 2012, "Black", 25_000.00, "AB5533VL"),
                new Car(4, "Chevrolet", "Camaro", 2019, "Black", 31_499.00, "AA7887AA") };

        CarProcessor proc = new CarProcessor(cars);

        proc.screenByBrand("Ford");
        System.out.println();
        proc.screenByModelAndExplPeriod("Camaro", 4);
        System.out.println();
        proc.screenByYearAndCost(2012, 20_000.00);
    }

}
