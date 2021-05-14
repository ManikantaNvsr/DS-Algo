package dev.javaconepts.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        Function<String, Integer> function = String::length;

        // A new list will hold the lengths of the above list
        List<Integer> newlist = map(list, function);

        System.out.println(newlist);

    }

    private static List<Integer> map(List<String> list, Function<String, Integer> function) {
        List<Integer> newlist = new ArrayList<>();
        for (String str : list) {
            newlist.add(function.apply(str));
        }
        return newlist;
    }

}
