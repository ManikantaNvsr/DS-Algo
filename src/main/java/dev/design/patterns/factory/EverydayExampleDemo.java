package dev.design.patterns.factory;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class EverydayExampleDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal); // Here cal is loaded with a Gregorian Calendar implementation
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        System.out.println(calendar); // Here also same gregorian implementation
        // Likewise, It can act as a factory and provide a different implementation as per the client request
    }
}
