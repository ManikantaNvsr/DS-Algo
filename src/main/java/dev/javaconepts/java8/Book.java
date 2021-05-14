package dev.javaconepts.java8;

public class Book {

    private String name;
    private String genre;
    private double rating;
    private String author;

    public Book(String name, String genre, double rating, String author) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", author='" + author + '\'' +
                '}';
    }
}
