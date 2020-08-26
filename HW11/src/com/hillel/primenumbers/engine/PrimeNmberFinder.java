package com.hillel.primenumbers.engine;

import java.util.Arrays;

public class PrimeNmberFinder implements Runnable {

    public Thread t;
    int subArray[];
    int primeNumbersArray[];
    int range;
    int lowerThreshold;
    int upperThreshold;
    int lengthOfRange;
    public static int commonArrayOfPrimeNums[];

    public PrimeNmberFinder(int lowerThreshold, int upperThreshold, int range, int lengthOfRange) {
        t = new Thread(this);
        this.lowerThreshold = lowerThreshold;
        this.upperThreshold = upperThreshold;
        this.lengthOfRange = lengthOfRange;
        this.range = range;
        t.start();
    }

    public void run() {
        makeSubArray();
        findPrimeNumbers();
        addPrimeNumsToComArray();
    }

    private void makeSubArray() {
        subArray = new int[lengthOfRange];
        if (range == 0) {
            for (int i = 0; i < lengthOfRange; i++, lowerThreshold++) {
                subArray[i] = lowerThreshold;
            }
        } else {
            for (int i = 0, value = lowerThreshold + lengthOfRange * range; i < lengthOfRange; i++, value++) {
                if (value <= upperThreshold) {
                    subArray[i] = value;
                } else {
                    break;
                }
            }
        }
    }

    private void findPrimeNumbers() {
        for (int value : subArray) {
            if (value == 2 || value == 3 || value == 5) {
                primeNumbersArray = extendArray(value, primeNumbersArray);
            }
            for (int i = 2; i < (value / 2); i++) {
                if (value % i == 0) {
                    break;
                } else if ((i == ((value / 2) - 1))) {
                    primeNumbersArray = extendArray(value, primeNumbersArray);
                }
            }
        }
    }

    private synchronized void addPrimeNumsToComArray() {
        if (primeNumbersArray != null) {
            for (int primeNumber : primeNumbersArray) {
                commonArrayOfPrimeNums = extendArray(primeNumber, commonArrayOfPrimeNums);
            }
        }
    }

    private int[] extendArray(int value, int[] coppiedArray) {
        if (coppiedArray == null) {
            int[] extendedArray = new int[1];
            extendedArray[0] = value;
            return extendedArray;
        } else {
            int[] extendedArray = new int[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = value;
            return extendedArray;
        }
    }

}
