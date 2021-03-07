package dev.problems.interview.questions;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStringByKeepingNumericalsAsIs {

    public static void main(String[] args) {
        String s = "sdfwaew23dfg";
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        // iterate over array and add all the alphabets to a stack
        for (char value : charArray) {
            if (!Character.isDigit(value)) {
                stack.push(value);
            }
        }
        StringBuilder reversedString = new StringBuilder();
        for (char c : charArray) reversedString.append(Character.isDigit(c) ? Character.valueOf(c) : stack.pop());

        System.out.println(reversedString);

    }

}
