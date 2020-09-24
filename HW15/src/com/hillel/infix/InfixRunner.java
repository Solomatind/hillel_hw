package com.hillel.infix;

public class InfixRunner {
    
    public static void main(String[] args) {
        String state = "A+B*(C%D-E)";
        System.out.println(state);
        System.out.println(InfixToPostfix.turnToPostfix(state));
        double result = InfixToPostfix.calculate(InfixToPostfix.turnToPostfix(state), 1, 2, 3, 4, 5);
        System.out.println(result);
        System.out.println(1 + 2 * (3 % 4 - 5));
    }

}
