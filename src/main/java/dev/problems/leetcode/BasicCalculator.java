package dev.problems.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/
public class BasicCalculator {
    public int calculate(String s) {
//        int result = 0;
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        char[] charArray = s.replaceAll(" ", "").toCharArray();
        for (int charArrayLength = charArray.length, i = charArrayLength - 1; i > -1; i--) {
            char character = charArray[i];
            if (Character.isDigit(character)) {
                operands.push(Character.getNumericValue(character));
            } else {
                if (character == '(') {
                    while (operators.peek() != ')') {
                        int value = calculate(operators.pop(), operands.pop(), operands.pop());
                        operands.push(value);
                    }
                    operators.pop();
                } else {
                    operators.push(character);
                }
            }
        }

        while (!operators.isEmpty()) {
            int value = calculate(operators.pop(), operands.pop(), operands.pop());
            operands.push(value);
        }
        return operands.pop();
    }

    private int calculate(Character operator, Integer operand1, Integer operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '*':
                return operand1 * operand2;
            case '-':
                return operand1 - operand2;
        }
        return 0;
    }
}

class Test {
    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("1 + 1"));
        System.out.println(basicCalculator.calculate(" (2-1) + 2 "));
        System.out.println(basicCalculator.calculate(" 2-1 + 2 "));
        System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(basicCalculator.calculate("123"));
    }
}
