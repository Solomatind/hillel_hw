package com.hillel.service;

import java.util.Arrays;

public class NumberService {

    public String sortArray(String numbers) {
        int[] numsArray = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sorted().toArray();
        return Arrays.toString(numsArray);
    }
}
