package com.hillel.taxistation.dataio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.hillel.taxistation.models.Car;
import com.hillel.taxistation.models.Eco;
import com.hillel.taxistation.models.Minibus;
import com.hillel.taxistation.models.Sedan;
import com.hillel.taxistation.models.Truck;

public class DataReader {

    private File sourceFile;
    private String[] carString;

    public DataReader(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Car[] read() throws IOException {
        FileInputStream fin = new FileInputStream(sourceFile);
        byte[] byteCars = new byte[fin.available()];
        byteCars = fin.readAllBytes();
        String result = new String(byteCars);
        carString = result.split(";\r\n");
        fin.close();
        return makeCars();
    }

    private Car[] makeCars() {
        Car[] cars = new Car[carString.length];
        for (int i = 0; i < carString.length; i++) {
            String[] carProperties = carString[i].split(",");
            ;
            switch (carProperties[0]) {
            case "Sedan":
                cars[i] = new Sedan(carProperties[1], Double.parseDouble(carProperties[2]),
                        Double.parseDouble(carProperties[3]), Double.parseDouble(carProperties[4]),
                        Integer.parseInt(carProperties[5]), Boolean.parseBoolean(carProperties[6]));
                break;
            case "Minibus":
                cars[i] = new Minibus(carProperties[1], Double.parseDouble(carProperties[2]),
                        Double.parseDouble(carProperties[3]), Double.parseDouble(carProperties[4]),
                        Integer.parseInt(carProperties[5]), Boolean.parseBoolean(carProperties[6]));
                break;
            case "Eco":
                cars[i] = new Eco(carProperties[1], Double.parseDouble(carProperties[2]),
                        Double.parseDouble(carProperties[3]), Integer.parseInt(carProperties[4]),
                        Double.parseDouble(carProperties[5]));
                break;
            case "Truck":
                cars[i] = new Truck(carProperties[1], Double.parseDouble(carProperties[2]),
                        Double.parseDouble(carProperties[3]), Double.parseDouble(carProperties[4]),
                        Double.parseDouble(carProperties[5]));
                break;
            }
        }
        return cars;
    }

}
