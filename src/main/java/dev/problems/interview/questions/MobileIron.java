package dev.problems.interview.questions;

import java.util.*;
import java.util.stream.Collectors;

public class MobileIron {
    public static void main(String[] args) {


        List<Map<Integer, String>> votesList = new LinkedList<>();

        Map<Integer, String> voter1 = new HashMap<>();
        voter1.put(1, "A");
        voter1.put(2, "B");
        voter1.put(3, "C");

        Map<Integer, String> voter2 = new HashMap<>();
        voter2.put(1, "C");
        voter2.put(2, "B");
        voter2.put(3, "A");

        Map<Integer, String> voter3 = new HashMap<>();
        voter3.put(1, "C");
        voter3.put(2, "A");
        voter3.put(3, "B");

        votesList.add(voter1);
        votesList.add(voter2);
        votesList.add(voter3);
//
        List<String> votes = new LinkedList<>();

//        TC:
//        O(V) ~O(n)
//        SC:
//        O(n)
        for (var voter : votesList) {
            for (var entry : voter.entrySet()) {
                int value = entry.getKey();
                while (value - 3 < 1) {
                    votes.add(entry.getValue());
                    value++;
                }
            }
        }


//        List<String> votes = Arrays.asList("A", "C", "B", "B", "C", "D", "C", "D", "B");


//        Map<String, Long> map = votes.stream()
//                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
//
//        System.out.println(map);

        // Find the frequency of the candidates to a map
        // TC: O(3n) ~ O(n)
        // SC: O(NumberOfCandidates)
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String vote : votes) {
            if (frequencyMap.containsKey(vote)) {
                frequencyMap.put(vote, frequencyMap.get(vote) + 1);
            } else {
                frequencyMap.put(vote, 1);
            }
        }
//        System.out.println(frequencyMap);
        // Sort the map based on the frequency
        // passing the comparator for sorting the entry set in reverse order
        // TC: O(n log n)
        // SC:
        Optional<Map.Entry<String, Integer>> maxVotesEntry = frequencyMap.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue));

        int maxVotes = maxVotesEntry.get().getValue();

        // TC: O(n)
        // SC: O(NumberOfCandidates)
        Map<String, Integer> winnerWithMaxVotes = frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxVotes)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (winnerWithMaxVotes.size() == 1) {
            System.out.println("The winner is " + maxVotesEntry.get().getKey());
        } else {
            // find the one who gets the votes the maximum votes first
            // TC: O(n)
            // SC:
            for (String vote : votes) {
                if (winnerWithMaxVotes.containsKey(vote)) {
                    winnerWithMaxVotes.put(vote, winnerWithMaxVotes.get(vote) - 1);
                    if (winnerWithMaxVotes.get(vote) == 0) {
                        System.out.println("The winner is " + vote);
                        break;
                    }
                }
            }
        }
    }
}
