package dev.implementations;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Graph {

    private int numberOfNodes;
    private LinkedHashMap<Integer, HashSet<Integer>> adjacencyList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacencyList = new LinkedHashMap<>();
    }

    public void addVertex(int value) {
        if (this.numberOfNodes == 0) {
            adjacencyList.put(value, new HashSet<>());
            numberOfNodes++;
        } else {
            if (this.adjacencyList.containsKey(value)) {
                System.out.println(value + " is already added");
            } else {
                adjacencyList.put(value, new HashSet<>());
                numberOfNodes++;
            }
        }

    }

    public void addEdge(int value1, int value2) {
        // Undirected Graph
        if (this.adjacencyList.containsKey(value1) && this.adjacencyList.containsKey(value2)) {
            this.adjacencyList.get(value1).add(value2);
            this.adjacencyList.get(value2).add(value1);
        } else {
            System.out.println("Can't add this edge since one or more of the values is not a vertex");
        }
    }

    public void printGraph() {
        for (int x : this.adjacencyList.keySet()) {
            System.out.println(x + "-->" + this.adjacencyList.get(x).toString());
        }
    }
}
