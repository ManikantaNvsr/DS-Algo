package dev.javaconepts.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Consumer<Integer> consumer = System.out::println;

        printElements(list, consumer);
    }

    private static void printElements(List<Integer> list, Consumer<Integer> consumer) {
        for (int val : list) {
            consumer.accept(val);
        }
    }
}
