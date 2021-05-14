package dev.javaconepts.java9.streamingapi;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingAPI {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 37, 30, 40, 50);
        System.out.println(list.stream().filter(integer -> integer % 5 == 0).collect(Collectors.toList()));
        System.out.println(list.stream().takeWhile(integer -> integer % 5 == 0).collect(Collectors.toList()));
        System.out.println(list.stream().dropWhile(integer -> integer % 5 == 0).collect(Collectors.toList()));
        List<Integer> listWithNull = Arrays.asList(10, 20, 37, 30, 40, 50, null);
        System.out.println(listWithNull.stream().flatMap(e -> Stream.ofNullable(e)).collect(Collectors.toList()));

    }
}
