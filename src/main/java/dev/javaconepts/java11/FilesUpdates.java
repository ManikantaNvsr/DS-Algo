package dev.javaconepts.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesUpdates {
    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(Files.createTempFile("testFile", ".txt"), "Java 11 is cool");
        System.out.println(path);
        String str = Files.readString(path);
        System.out.println(str);
    }
}
