package com.hillel.infix;

import java.util.Stack;

public class InfixToPostfix {

    private static int getPriority(char c) {
        switch (c) {
            case '+', '-':
                return 1;
            case '*', '/':
                return 2;
            case '^':
                return 3;
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

}
