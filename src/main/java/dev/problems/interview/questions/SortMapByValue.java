package dev.problems.interview.questions;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {

    public static void main(String[] args) {

        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("a", 1);
        result.put("b", 2);
        result.put("c", 1);
        result.put("d", 0);

        // sort it using Java 8 functions
        // By default, Collectors toMap returns hashmap and it doesn't guarantee sorted order
        // So, we had to use new LinkedHashMap creation when we use collectors
        result = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
//                .sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

//        Sorting in normal way
/*        List<Map.Entry<String, Integer>> list = new LinkedList<>(result.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));

        result.clear();

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
            result.put(entry.getKey(), entry.getValue());
        }*/

        System.out.println(result.toString());
    }
}
