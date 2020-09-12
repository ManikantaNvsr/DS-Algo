package dev.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/grading/problem
public class GradingStudents {

    public static void main(String[] args) {


    }


    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        for (int grade:
             grades) {
            int remainder = grade % 5;
            if(remainder >=3 && grade > 37){
                grade += 5 - remainder;
            }
            result.add(grade);

        }

        return result;
    }
}
