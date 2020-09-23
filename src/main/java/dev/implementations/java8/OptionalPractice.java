package dev.implementations.java8;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
//        Integer a = null;
//        Optional<Integer> optionalInteger = Optional.ofNullable(a);
//        Integer value = optionalInteger.orElse(0);
//        System.out.println(value);

        // map
//        String str = "Mani";
//        Optional<String> optional = Optional.ofNullable(str);
        Optional<String> optional = Optional.empty();
        String value = optional.map(e -> "Replaced").orElse("Empty");
        System.out.println(value);

    }
}
