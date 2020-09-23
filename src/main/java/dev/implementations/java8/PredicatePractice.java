package dev.implementations.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("");
        list.add("String4");
        list.add("HelloBossPredicate");
        list.add("PredicatePractice");

        // This predicate is used for listing only non empty strings
        Predicate<String> predicate = e -> !e.isEmpty();

        List<String> nonEmptyStringsList = filterList(list, predicate);

        // Now the predicate holds for strings containing Predicate in it.
        predicate = e -> e.contains("Predicate");

        List<String> predicateList = filterList(list, predicate);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        Predicate<Integer> integerFilter = e -> e % 2 == 0;
        System.out.println(filterList(list1, integerFilter));

        System.out.println(nonEmptyStringsList);
        System.out.println(predicateList);

    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T str : list) {
            if (predicate.test(str)) newList.add(str);
        }
        return newList;
    }

}
