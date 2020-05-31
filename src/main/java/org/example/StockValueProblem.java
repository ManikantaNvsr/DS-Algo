package org.example;

/**
 * Hello world!
 */
public class StockValueProblem {

    public static void main(String[] args) {

        // stack value decreases by one and multiplied by 2 in alternate days respectively

        int initialValue = 100;
        int targetValue = 393;
        boolean flag = true;

        int days = 0;
        while (initialValue != targetValue) {
            days++;
            if (flag) {
                initialValue = initialValue - 1;
                flag = false;
            } else {
                initialValue = initialValue * 2;
                flag = true;
            }
        }

        System.out.println(days);
    }

}
