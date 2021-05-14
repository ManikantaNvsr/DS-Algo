package dev.javaconepts.java11;

import java.util.Optional;

public class OptionalUpdates {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.empty();
        if(stringOptional.isEmpty()) System.out.println("yes");
        System.out.println(stringOptional.isEmpty());
    }
}
