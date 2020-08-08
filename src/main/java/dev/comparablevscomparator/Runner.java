package dev.comparablevscomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Laptop> laptopsList = new ArrayList<>();
        laptopsList.add(new Laptop("Dell", 16, 800));
        laptopsList.add(new Laptop("Apple", 8, 1200));
        laptopsList.add(new Laptop("Acer", 12, 700));
        Comparator<Laptop> comparator = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if (o1.getRam() > o2.getRam()) {
                    return 1; // It just has to be a positive Value when greater
                } else if (o1.getRam() < o2.getRam()) {
                    return -1; // It just has to be a negative value when lesser
                } else {
                    return 0; // It just has to be a neutral value when equal
                }
            }
        };
        Collections.sort(laptopsList, comparator);
//        Collections.sort(laptopsList); // Comparable Sort
        for (Laptop l : laptopsList) {
            System.out.println(l);
        }
    }

}
