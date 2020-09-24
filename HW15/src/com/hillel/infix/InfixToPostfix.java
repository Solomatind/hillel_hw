package com.hillel.infix;

import java.util.Stack;

public class InfixToPostfix {

    private static int getPriority(char c) {
        switch (c) {
        case '+', '-':
            return 1;
        case '*', '/', '%':
            return 2;
        }
        return -1;
    }

    public static String turnToPostfix(String statement) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (char c : statement.toCharArray()) {
            if (getPriority(c) > 0) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    result += stack.pop();
                }
                stack.push(c);
            } else if (c == ')') {
                char b = stack.pop();
                while (b != '(') {
                    result += b;
                    b = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                result += c;
            }
        }

        for (int i = 0; i <= stack.size(); i++) {
            result += stack.pop();
        }
        return result;
    }

    public static double calculate(String infixStatement, double... var) {
        double result = 0;
        boolean isFirstOperator = true;
        int counterOfVars = 0;
        Stack<Double> operands = new Stack<>();
        for (char c : infixStatement.toCharArray()) {
            if (Character.isLetter(c)) {
                operands.push(var[counterOfVars]);
                counterOfVars++;
            } else if (isFirstOperator) {
                result = operands.get(operands.size() - 2);
                operands.remove(operands.size() - 2);
                isFirstOperator = false;
            }
            if (!Character.isLetter(c)) {
                switch (c) {
                case '+':
                    result += operands.pop();
                    break;
                case '-':
                    result -= operands.pop();
                    break;
                case '*':
                    result *= operands.pop();
                    break;
                case '/':
                    result /= operands.pop();
                    break;
                case '%':
                    result %= operands.pop();
                    break;
                }
            }
        }
        return result;
    }

}
