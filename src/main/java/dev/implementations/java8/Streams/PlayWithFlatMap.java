package dev.implementations.java8.Streams;

import dev.Person;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithFlatMap {
    public static void main(String[] args) {
        Person p1 = new Person("Mani", 10);
        Person p2 = new Person("Moni", 21);
        Person p3 = new Person("Aravind", 13);
        Person p4 = new Person("Gupta", 12);
        Person p5 = new Person("Subbu", 41);

        City newyork = new City("NewYork", p1, p2);
        City london = new City("NewYork", p3, p4);
        City paris = new City("NewYork", p5);

        List<City> cityList = Arrays.asList(newyork, london, paris);
        System.out.println(cityList.stream().flatMap(city -> city.persons.stream()).count());
        cityList.stream().flatMap(city -> city.persons.stream()).forEach(System.out::println);

    }
}
