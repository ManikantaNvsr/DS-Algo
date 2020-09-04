package Streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Sample {

    public static int counter = 0;


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220);
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        Map<Object, Object> map;


//        numbers.parallelStream().forEach(e -> {
//            map.put(e, test(e));
////            System.out.println(e);
//        });


        System.out.println(new Date());
        map = numbers.stream().collect(Collectors.toMap(e -> e, Sample::test));
        System.out.println(map);
        System.out.println(new Date());


//        numbers.parallelStream().forEach(System.out::println);
    }

    private static Integer test(Integer e) {
        System.out.println(counter++ + "---" + e);
        return e * 1234324234 + 234231234;
    }
}
