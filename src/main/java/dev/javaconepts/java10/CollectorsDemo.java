package dev.javaconepts.java10;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(15, 20, 27, 30);
        List<Integer> list1 = list.stream().filter(integer -> integer % 3 == 0).collect(Collectors.toUnmodifiableList());
        list1.add(40); // This gives error since we asked unmodifiableList
    }
}
