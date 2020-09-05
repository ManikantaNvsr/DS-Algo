package dev.geeksforgeeks.mustdocodingquestions.stacksandqueues;
import java.util.*;

//https://leetcode.com/problems/valid-parentheses/
public class ParenthesisChecker {

    public static void main(String[] args) {
        System.out.println(isValid("{{"));
        System.out.println(isValid("}(()){}"));
        System.out.println(isValid("(()"));
        System.out.println(isValid("))))))"));
        System.out.println(isValid("{([])}"));
        System.out.println(isValid("([]"));
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Map<String, String> matchingPairs = new HashMap<>();
        matchingPairs.put("}", "{");
        matchingPairs.put("]", "[");
        matchingPairs.put(")", "(");
        Stack<String> stack = new Stack<>();
        for (String each : s.split("")) {
            if (matchingPairs.containsKey(each)) {
                // Everytime we get a closing bracket, there should be a matching opening bracket.
                // Pop the matching opening bracket from the stack since it is valid.
                if (!stack.isEmpty() && stack.peek().equalsIgnoreCase(matchingPairs.get(each))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                // If it is a opening bracket, push it on to the stack.
                stack.push(each);
            }
        }
        return stack.isEmpty();// If the stack is empty, it is valid
    }


}
