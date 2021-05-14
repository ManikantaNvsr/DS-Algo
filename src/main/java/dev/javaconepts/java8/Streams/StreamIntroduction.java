package dev.javaconepts.java8.Streams;

import dev.javaconepts.java8.Book;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntroduction {

    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
        System.out.println("sum is " + sum);
        int mul = Stream.of(1, 2, 3, 4, 5).reduce(1, (a, b) -> a * b);
        Optional<String> str = Stream.of("1", "2", "3", "4", "5").reduce( (a, b) -> a + b);
        System.out.println("mul is " + str.get());
        int sub = Stream.of(1, 2, 3).reduce(0, (a, b) ->  a-b);
        System.out.println("div is " + sub);

        // Java 8 example to filter a list
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Adventure", 4.4, "Paulo Coelho"));
        books.add(new Book("The Book2", "Romance", 4.1, "Mani Coelho"));
        books.add(new Book("The Book3", "Horror", 2, "Moni Coelho"));
        books.add(new Book("The Book4", "Horror", 3.5, "Aravind Coelho"));

        // Stream pipeline
        List<Double> filteredBooks = books.stream() // source
                .map(book -> book.getRating())
                .filter(rating -> rating > 2)

//                .filter(book -> book.getGenre().equalsIgnoreCase("horror")) // Intermediate operation
//                .filter(book -> book.getRating() > 3) // Intermediate operation
                .collect(Collectors.toList()); // terminal operation

        books.stream().map(b -> b.getRating()).filter(r -> r > 2).count();

        filteredBooks.forEach(System.out::println);

        // find popular romantic books
        List<Book> popularRomanticBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("romance"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toCollection(ArrayList::new));
        popularRomanticBooks.forEach(System.out::println);

        // find the average rating of the books collection
        OptionalDouble averageRating = books.stream().map(book -> book.getRating()).mapToDouble(rating -> rating).average();
        System.out.println(averageRating.getAsDouble());
        OptionalDouble another = books.stream().mapToDouble(book -> book.getRating()).average();
        System.out.println(another.getAsDouble());

        int intsum = IntStream.of(1,3,4).sum();
        OptionalInt max = IntStream.of(1,2,3).max();
        System.out.println(intsum);
        System.out.println(max.getAsInt());


//        IntStream.iterate(0, i -> i+1).limit(15).forEach(System.out::println);
//        Stream.iterate(0, i -> i+1).limit(15).forEach(System.out::println);

        IntStream.of(1,2,3,4,5).sorted().limit(3).forEach(System.out::println);

//        Stream.generate(()->"Hey").forEach(System.out::println);
        Stream.generate(new Random() :: nextInt).forEach(System.out::println);

    }
}
