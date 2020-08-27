package com.hillel.primenumbers.mainthread;

import java.util.Scanner;

import com.hillel.primenumbers.engine.PrimeNumberFinder;

public class TestThread {
    public static void main(String[] args) {
        int lowerThreshold;
        int upperThreshold;
        int numberOfThreads;
        int lengthOfRange;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Lower threshold -> ");
        lowerThreshold = scanner.nextInt();
        System.out.print("Upper threshold -> ");
        upperThreshold = scanner.nextInt();
        System.out.print("Number of threads -> ");
        numberOfThreads = scanner.nextInt();
        scanner.close();
        lengthOfRange = (int) Math.ceil(((double) (upperThreshold - lowerThreshold) / numberOfThreads));
        PrimeNumberFinder threads[] = new PrimeNumberFinder[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
                threads[i] = new PrimeNumberFinder(lowerThreshold, upperThreshold, i, lengthOfRange);
        }
        try {
            for (PrimeNumberFinder primeNmberFinder : threads) {
                if (primeNmberFinder != null) {
                    primeNmberFinder.getT().join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < PrimeNumberFinder.getCommonArrayOfPrimeNums().length; i++) {
            System.out.print(PrimeNumberFinder.getCommonArrayOfPrimeNums()[i] + " ");
        }
    }
}
