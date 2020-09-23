package dev.implementations.java8;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        // Supplier for returning a random number
        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());
        Supplier<String> supplierString = () -> "Test";
        System.out.println(supplierString.get());
    }
}
