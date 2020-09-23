package dev.implementations.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduction {

    public static void main(String[] args) {
        // Java 8 example to filter a list
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Adventure", 4.4, "Paulo Coelho"));
        books.add(new Book("The Book2", "Romance", 4.1, "Mani Coelho"));
        books.add(new Book("The Book3", "Horror", 2, "Moni Coelho"));
        books.add(new Book("The Book4", "Horror", 3.5, "Aravind Coelho"));

        // Stream pipeline
        List<Book> filteredBooks = books.stream() // source
                .filter(book -> book.getGenre().equalsIgnoreCase("horror")) // Intermediate operation
                .filter(book -> book.getRating() > 3) // Intermediate operation
                .collect(Collectors.toList()); // terminal operation

        filteredBooks.forEach(System.out::println);

        // find popular romantic books
        List<Book> popularRomanticBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("romance"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());
        popularRomanticBooks.forEach(System.out::println);
    }
}
