package dev.design.immutable;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final String name;
    private final Map<String, String> map;

    public ImmutableClass(String name, Map<String, String> map) {
        this.name = name;
        this.map = new HashMap<>(map);
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return new HashMap<>(this.map);
    }

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("test", new HashMap<>());
        System.out.println("Initialized with: " + immutableClass.getMap());
        immutableClass.getMap().put("test", "test");
        System.out.println("Changed with: " + immutableClass.getMap());
    }
}
