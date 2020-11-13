package dev.problems.leetcode;

import java.util.*;
import java.util.stream.Stream;

//https://leetcode.com/problems/word-subsets/
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new LinkedList<>();
        // Brute-force:
        // Iterate over each word in A.
        // Check whether all the words of B are subset of the iterating word.
        // If yes, add the iterating word to result list.

        // Efficient:
        // From the brute force, we know that all the words in B should be present in a word of A including repetition
        // (1) Calculate maximum frequencies of a character among all words in B and form a single word
        // (2) If that single word is present in a word of A, we can say that word of A is universal
        // We use indexes 0-25 analogy for alphabets
        // (1)
        int[] singleWord = new int[26];
        for (String str : B) {
            int[] temp = calculateFrequency(str);
            for (int i = 0; i < temp.length; i++) {
                singleWord[i] = Math.max(singleWord[i], temp[i]);
            }
        }
        // (2)
        outerloop:
        for (String str : A) {
            int[] frequencyOfA = calculateFrequency(str);
            for (int i = 0; i < singleWord.length; i++) {
                if (frequencyOfA[i] < singleWord[i]) {
                    continue outerloop;
                }
            }
            result.add(str);
        }

        return result;
    }

    public int[] calculateFrequency(String str) {
        int[] result = new int[26];
        for (char c : str.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }
}
