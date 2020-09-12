package dev.problems.leetcode;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInAString {

    public static void main(String[] args) {

        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();

        System.out.println(reverseWordsInAString.reverseWords("a good     example"));

    }

    public String reverseWords(String s) {

        String[] arr = s.split(" ");

        String result = "";

        for (int i = arr.length - 1; i > -1; i--) {
            result += arr[i] + " ";
        }

        // trim removes the trailing spaces
        // replaceAll(\\s{2,}) replaces the spaces 2 or more with single space
        return result.trim().replaceAll("\\s{2,}", " ");
    }
}
