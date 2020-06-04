package dev.problems;

import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
            String anim= "|/-\\";
        System.out.println("hey: ");
            for (int x =0 ; x < 100 ; x++) {
                String data = "\r" + " " + x;
                System.out.write(data.getBytes());
                Thread.sleep(10);
            }
    }
}
