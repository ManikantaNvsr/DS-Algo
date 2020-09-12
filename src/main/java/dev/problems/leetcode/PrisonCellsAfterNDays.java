package dev.problems.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/prison-cells-after-n-days/
public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
//        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
//        int n = 30;
//        int[] cells = new int[]{1,0,0,1,0,0,1,0};
//        int n = 1000000000;
//        int[] cells = new int[]{0,0,0,1,1,0,1,0};
//        int n = 574;
        int[] cells = new int[]{1, 0, 0, 1, 0, 0, 0, 1};
        int n = 826;

        System.out.println(Arrays.toString(prisonCellsAfterNDays.prisonAfterNDays(cells, n)));
    }

    // naive approach
    public int[] prisonAfterNDays(int[] cells, int N) {

        int noOfPrisons = cells.length;
        int[] result = null;

        // cells length is fixed here.
        // that gives an idea that since the number of cells is constant, as the n increases, we can probably have a pattern in our cells places after certain number of days.
        // When I ran for 20 days, I could see a repetition of day 1 arrangement on the 15th day.
        // That gives idea for efficient approach.
        // This line makes the whole program efficient.
        N = N % 14 == 0 ? 14 : N % 14;

//        int day = 1;

        while (N > 0) {
            result = new int[noOfPrisons];

            for (int i = 0; i < noOfPrisons; i++) {
                if (i >= 1 && i < noOfPrisons - 1) {

                    if ((cells[i - 1] == 0 && cells[i + 1] == 0) || (cells[i - 1] == 1 && cells[i + 1] == 1)) {
                        result[i] = 1;
                    } else {
                        result[i] = 0;
                    }


                } else {
                    if (cells[i] == 1) {
                        result[i] = 0;
                    }
                }
            }

//            System.out.println("Day " + day++ + ":" + Arrays.toString(result));

            cells = result;
            N--;
        }
        return result;
    }


}
