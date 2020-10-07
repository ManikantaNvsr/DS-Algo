package dev.problems.leetcode;

import java.util.*;

//https://leetcode.com/problems/find-common-characters/
public class FindCommonCharacters {

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        System.out.println(findCommonCharacters.commonChars(new String[]{"bella", "label", "roller"}));
    }

    public List<String> commonChars(String[] A) {
        // We need to add characters to the result and no lookup is needed so chose linked list
        List<String> result = new LinkedList<>();

        // Naive Approach
        // Store the frequency for one string of A in the map // Format: Key - character, value - frequency
        // Iterate over each string of A
        // Calculate the frequency for each character in that string and store frequency for character which is already there in the map only.
        // While storing the frequency,
        // Store only minimum between the frequency value in the map for that character and the frequency of that character in the current string.
        // Finally, after all the iterations of the strings, return a list of characters based on that map

        // My efficient Approach:
        // Iterate over the characters in the first string
        // In each iteration, find the minimum frequency of that character among all the strings
        // Store in a frequency map as (Character - Frequency)
        // If the character doesn't contain in any string, do not store it in the frequency map
        /*Map<Character, Integer> frequencyMap = new HashMap<>();
        outerloop:
        // Run this loop for each character in the first string
        for (char character : A[0].toCharArray()) {
            // Run this loop for all the strings
            for (String eachString : A) {
                // Check whether the string contains the character
                if (eachString.contains("" + character)) {
                    int characterFrequency = 0;
                    for (char eachCharacter : eachString.toCharArray()) {
                        if (eachCharacter == character) {
                            characterFrequency++;
                        }
                    }
                    frequencyMap.put(character,
                            Math.min(characterFrequency,
                                    frequencyMap.get(character) != null ?
                                            frequencyMap.get(character) : Integer.MAX_VALUE));
                } else {
                    frequencyMap.put(character, 0);
                    continue outerloop;
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            while (frequency > 0) {
                result.add(Character.toString(entry.getKey()));
                frequency--;
            }
        }*/

        // Updated Approach from the below comments in leetcode and it is more efficient than above:
        // Maintain two arrays to compare frequencies between two strings
        // Since all characters lowercase, we can just use arrays to store the frequencies of respective characters in a string
        // frequency1 to store the minimum of the strings compared
        // frequency2 to act as buffer for the frequency of the comparing string
        // After comparing all the strings, we just need to add the frequency1 to list
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];
        // loading the frequency of first string
        for (char character : A[0].toCharArray()) {
            // getting the relative index for character in the alphabets ranging from 0 - 25
            frequency1[character - 'a']++;
        }
        // looping over the other strings in the array
        for (int j = 1; j < A.length; j++) {
            for (char character : A[j].toCharArray()) {
                // getting the relative index for character in the alphabets ranging from 0 - 25
                frequency2[character - 'a']++;
            }
            for (int i = 0; i < frequency1.length; i++) {
                frequency1[i] = Math.min(frequency1[i], frequency2[i]);
                frequency2[i] = 0;
            }
        }

        for (int i = 0; i < frequency1.length; i++) {
            while (frequency1[i] > 0) {
                // Converting index to the required character
                result.add(Character.toString((char) ('a' + i)));
                frequency1[i]--;
            }
        }

        return result;
    }
}
