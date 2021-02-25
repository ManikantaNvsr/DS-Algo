package dev.implementations.java8.Streams;

import dev.Person;

import java.util.Arrays;
import java.util.List;

public class City {
    String cityname;

    @Override
    public String toString() {
        return "City{" +
                "cityname='" + cityname + '\'' +
                ", persons=" + persons +
                '}';
    }

    List persons;

    public City(String cityname, Person... personList) {
        this.cityname = cityname;
        this.persons = Arrays.asList(personList);
    }
}
