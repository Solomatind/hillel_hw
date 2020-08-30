package com.hillel.taxistation.dataio;

import java.io.FileOutputStream;
import java.io.IOException;

import com.hillel.taxistation.models.Car;
import com.hillel.taxistation.models.Eco;
import com.hillel.taxistation.models.Minibus;
import com.hillel.taxistation.models.Sedan;
import com.hillel.taxistation.models.Truck;

public class DataWriter {

    private Car[] carsToWrite;

    public DataWriter(Car[] carsToWrite) {
        this.carsToWrite = carsToWrite;
    }

    public void write() throws IOException {
            FileOutputStream fout = new FileOutputStream("outputcars.txt");
            fout.write(makeStringCars().getBytes());
            fout.close();
    }

    private String makeStringCars() {
        String carString = "";
        for (int i = 0; i < carsToWrite.length; i++) {
            switch (carsToWrite[i].getClass().getSimpleName()) {
            case "Sedan":
                Sedan sTemp;
                sTemp = (Sedan) carsToWrite[i];
                carString += "Sedan," + sTemp.getMark() + "," + sTemp.getCost() + "," + sTemp.getSpeed() + ","
                        + sTemp.getFuelConsumption() + "," + sTemp.getCountOfPassengerSeats() + "," + sTemp.isCabrio();
                break;
            case "Minibus":
                Minibus mTemp;
                mTemp = (Minibus) carsToWrite[i];
                carString += "Minibus," + mTemp.getMark() + "," + mTemp.getCost() + "," + mTemp.getSpeed() + ","
                        + mTemp.getFuelConsumption() + "," + mTemp.getCountOfPassengerSeats() + ","
                        + mTemp.isCargoPassenger();
                break;
            case "Eco":
                Eco eTemp;
                eTemp = (Eco) carsToWrite[i];
                carString += "Eco," + eTemp.getMark() + "," + eTemp.getCost() + "," + eTemp.getSpeed() + ","
                        + eTemp.getCountOfPassengerSeats() + "," + eTemp.getChargeLevel();
                break;
            case "Truck":
                Truck tTemp;
                tTemp = (Truck) carsToWrite[i];
                carString += "Truck," + tTemp.getMark() + "," + tTemp.getCost() + "," + tTemp.getSpeed() + ","
                        + tTemp.getFuelConsumption() + "," + tTemp.getCarryingCapacity();
                break;
            }
            if (i != (carsToWrite.length - 1)) {
                carString += ";\r\n";
            }
        }
        return carString;
    }

}
