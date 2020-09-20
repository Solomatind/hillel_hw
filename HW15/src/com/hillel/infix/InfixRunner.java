package com.hillel.infix;

public class InfixRunner {
    
    public static void main(String[] args) {
        String state = "A+B*(C^D-E)";
        System.out.println(state);
        System.out.println(InfixToPostfix.turnToPostfix(state));
    }

}
