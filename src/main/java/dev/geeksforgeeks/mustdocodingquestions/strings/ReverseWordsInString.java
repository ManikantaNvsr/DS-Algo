package dev.geeksforgeeks.mustdocodingquestions.strings;

import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        while (testcases > 0){
            String givenString = scanner.next();
            String[] words = givenString.split("\\.");
            StringBuilder stringBuilder = new StringBuilder();
            for (int w = words.length-1; w > 0; w--) {
                stringBuilder.append(words[w] + ".");
            }
            stringBuilder.append(words[0]);
            System.out.println(stringBuilder.toString());
            testcases--;
        }
    }
}
