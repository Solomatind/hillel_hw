package com.hillel.primenumbers.mainthread;

import java.util.Arrays;
import java.util.Scanner;

import com.hillel.primenumbers.engine.PrimeNmberFinder;

public class TestThread {
    public static void main(String[] args) {
        int lowerThreshold;
        int upperThreshold;
        int numberOfThreads;
        int lengthOfRange;
        Scanner scanner = new Scanner(System.in);

        lowerThreshold = scanner.nextInt();
        upperThreshold = scanner.nextInt();
        numberOfThreads = scanner.nextInt();
        lengthOfRange = (int) Math.ceil(((double) (upperThreshold - lowerThreshold) / numberOfThreads));
        PrimeNmberFinder threads[] = new PrimeNmberFinder[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            if (i * lengthOfRange <= (upperThreshold - lowerThreshold)) {
                threads[i] = new PrimeNmberFinder(lowerThreshold, upperThreshold, i, lengthOfRange);
            }
        }
        try {
            for (PrimeNmberFinder primeNmberFinder : threads) {
                if (primeNmberFinder != null) {
                    primeNmberFinder.t.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < PrimeNmberFinder.commonArrayOfPrimeNums.length; i++) {
            System.out.print(PrimeNmberFinder.commonArrayOfPrimeNums[i] + " ");
        }
    }
}
