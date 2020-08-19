package com.hillel.flowers.exception;

public class InvalidStemLengthException extends Exception {
    private int minLength;
    private int maxLength;

    public InvalidStemLengthException(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public InvalidStemLengthException() {
    }

    public String toString() {
        return "The argument cannot be negative: " + minLength + " " + maxLength;
    }
}
