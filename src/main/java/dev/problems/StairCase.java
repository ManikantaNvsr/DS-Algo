package dev.problems;
// https://www.hackerrank.com/challenges/staircase/problem
public class StairCase {

    public static void main(String[] args) {
        staircase(6);
    }

    static void staircase(int n) {
        int pivot = n-1;
        while(pivot >=0) {
            for(int i=0;  i < pivot; i++){
                System.out.print(" ");
            }
            for(int i=pivot; i<n; i++){
                System.out.print("#");
            }
            System.out.print("\n");
            pivot--;
        }
    }
}
