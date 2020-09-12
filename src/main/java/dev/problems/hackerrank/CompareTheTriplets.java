package dev.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/compare-the-triplets/problem
public class CompareTheTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int pointsForAlice = 0;
        int pointsForBob = 0;
        List<Integer> pointsList = new ArrayList();

        for (int i = 0; i < a.size(); i++) {
            int result = a.get(i).compareTo(b.get(i));
            if (result > 0){
                pointsForAlice++;
            }else if(result < 0){
                pointsForBob++;
            }

        }
        pointsList.add(pointsForAlice);
        pointsList.add(pointsForBob);
        return pointsList;
    }
}
