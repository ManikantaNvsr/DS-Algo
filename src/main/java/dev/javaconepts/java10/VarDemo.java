package dev.javaconepts.java10;

import java.util.LinkedHashMap;

public class VarDemo {
    public static void main(String[] args) {
        var x = 10;
        System.out.println(x);
        var map = new LinkedHashMap<String, String>();
        map.put("test", "test");
        for (var eachRecord : map.entrySet()) {
            System.out.println(eachRecord);
        }
    }
}
