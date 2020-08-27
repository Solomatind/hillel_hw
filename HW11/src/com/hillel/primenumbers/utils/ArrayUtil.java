package com.hillel.primenumbers.utils;

public class ArrayUtil {
    
    public static int[] extendArray(int value, int[] coppiedArray) {
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
