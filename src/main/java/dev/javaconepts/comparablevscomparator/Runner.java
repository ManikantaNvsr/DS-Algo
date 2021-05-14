package dev.javaconepts.comparablevscomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Laptop> laptopsList = new ArrayList<>();
        laptopsList.add(new Laptop("Dell", 16, 800));
        laptopsList.add(new Laptop("Apple", 8, 1200));
        laptopsList.add(new Laptop("Acer", 12, 700));
        laptopsList.sort(Comparator.comparing(o -> o.getRam()));
//        Collections.sort(laptopsList); // Comparable Sort
        for (Laptop l : laptopsList) {
            System.out.println(l);
        }
    }

}
