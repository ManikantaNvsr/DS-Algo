package dev.problems;

import java.util.Arrays;
import java.util.Random;

//https://leetcode.com/problems/distribute-candies-to-people
public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        dc.distributeCandiesByDraw(100, 5);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int indexOfPerson = 0;
        int candiesToPerson = 1;

        while (candies > 0) {

            if (candies > candiesToPerson) {
                candies -= candiesToPerson;
                result[indexOfPerson++ % num_people] += candiesToPerson++;

            } else {
                result[indexOfPerson % num_people] += candies;

                break;
            }
        }
        return result;
    }

    // answer to my own question
    public int[] distributeCandiesByDraw(int candies, int num_people) {
        int[] result = new int[num_people];
        int indexOfPerson = 0;
        //int candiesToPerson = 1;

        while (candies > 0) {

            // getting no of candies to given by a draw
            Random random = new Random();
            int candiesToPerson = 0;
            while (candiesToPerson == 0) {
                candiesToPerson = random.nextInt(candies + 1);
            }


            if (candies > candiesToPerson) {
                candies -= candiesToPerson;
                result[indexOfPerson++ % num_people] += candiesToPerson;
                System.out.println("Candies By draw for the " + indexOfPerson + " person: " + candiesToPerson);

            } else {
                result[indexOfPerson++ % num_people] += candies;
                System.out.println("Candies By draw for the " + indexOfPerson  + " person: " + candies);

                break;
            }
        }
        System.out.println("Last Tread Received: " + indexOfPerson);
        System.out.println("Treats Distribution " + Arrays.toString(result));
        return result;
    }
}
