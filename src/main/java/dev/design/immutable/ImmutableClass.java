package dev.design.immutable;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final String name;
    private final Map<String, String> map;

    public ImmutableClass(String name, Map<String, String> map) {
        this.name = name;
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.map = tempMap;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                this.map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

    // for testing
//    public static void main(String[] args) {
//        ImmutableClass immutableClass = new ImmutableClass("test", new HashMap<>());
//        System.out.println("Initialized with: " + immutableClass.getMap());
//        immutableClass.getMap().put("test", "test");
//        System.out.println("Changed with: " + immutableClass.getMap());
//    }
}
