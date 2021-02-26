package dev.design.patterns.templateMethod.javaexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemplateDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Mani","123456789",20);
        Person p2 = new Person("Hey","1276686789",30);
        Person p3 = new Person("Gupta","113687789",10);
        List<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        Collections.sort(people);

        people.forEach(System.out::println);
    }
}
