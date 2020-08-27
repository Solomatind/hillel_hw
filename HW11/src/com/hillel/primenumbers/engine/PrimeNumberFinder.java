package com.hillel.primenumbers.engine;

import com.hillel.primenumbers.utils.ArrayUtil;

public class PrimeNumberFinder implements Runnable {

    private Thread t;
    private int subArray[];
    private int primeNumbersArray[];
    private int range;
    private int lowerThreshold;
    private int upperThreshold;
    private int lengthOfRange;
    private static int commonArrayOfPrimeNums[];

    public PrimeNumberFinder(int lowerThreshold, int upperThreshold, int range, int lengthOfRange) {
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
                primeNumbersArray = ArrayUtil.extendArray(value, primeNumbersArray);
            }
            for (int i = 2; i < (value / 2); i++) {
                if (value % i == 0) {
                    break;
                } else if ((i == ((value / 2) - 1))) {
                    primeNumbersArray = ArrayUtil.extendArray(value, primeNumbersArray);
                }
            }
        }
    }

    private synchronized void addPrimeNumsToComArray() {
        if (primeNumbersArray != null) {
            for (int primeNumber : primeNumbersArray) {
                commonArrayOfPrimeNums = ArrayUtil.extendArray(primeNumber, commonArrayOfPrimeNums);
            }
        }
    }
    
    public Thread getT() {
        return t;
    }
    
    public static int[] getCommonArrayOfPrimeNums() {
        return commonArrayOfPrimeNums;
    }

}
