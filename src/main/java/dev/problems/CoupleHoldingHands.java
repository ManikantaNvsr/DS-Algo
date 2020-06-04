package dev.problems;

// https://leetcode.com/problems/couples-holding-hands/
// https://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
public class CoupleHoldingHands {


    public int minSwapsCouples(int[] row) {

        int numberOfPairs = row.length / 2;

        return minSwaps(row);

    }

    // This function will write minimum number of swaps required.
    public int minSwaps(int[] row) {
        // store index of each element in the array
        int[] index = new int[row.length + 1];
        for (int i = 0; i < row.length; i++) {
            index[row[i]] = i;
        }

        return minSwapsRecursive(row, index, 0, row.length - 1);
    }

    private int minSwapsRecursive(int[] row, int[] index, int start, int end) {

        // since all the pairs visited no more swaps required.
        if (start >= row.length - 1)
            return 0;

        // If current pair is valid, don't swap and move ahead.
        if (row[start] == pair(row[start + 1])) {
            return minSwapsRecursive(row, index, start + 2, end);
        }

        // If we are coming to this line means the two numbers being considered are not pair.
        // we have two choices to make
        // 1. We have to swap pair of row[start] with row[start + 1 ]
        // 2. We have to swap row[start] with the pair of row[start + 1]
        // save the min swaps in a if the choice 1 is made
        // save the min swaps in b if the choice 2 is made
        // finally consider the min of a and b for the calculation

        // 1

        int pairValueA = pair(row[start]);
        // System.out.println("replacing " + row[start + 1] + "with "+ pairValueA);
        int tempA = row[start + 1];
        row[start + 1] = pairValueA;
        row[index[pairValueA]] = tempA;

        updateIndexes(index, tempA, index[pairValueA], row[start + 1], start + 1);
        int a = minSwapsRecursive(row, index, start + 2, end);

        // since we changed some positions, we need to change their positions back to find out what if the 2 choice is made
        row[start + 1] = tempA;
        row[index[row[start + 1]]] = pairValueA;
        updateIndexes(index, pairValueA, index[row[start + 1]], row[start + 1], start + 1);

        // 2
        int pairValueB = pair(row[start + 1]);
        // System.out.println("replacing " + row[start] + "with " + pairValueB);
        int tempB = row[start];
        row[start] = pairValueB;
        row[index[pairValueB]] = tempB;
        updateIndexes(index, tempB, index[pairValueB], row[start], start);
        int b = minSwapsRecursive(row, index, start + 2, end);

        // since we changed some positions, we need to change their positions back to find out what if the 2 choice is made
        row[start] = tempB;
        row[index[row[start]]] = pairValueB;
        updateIndexes(index, pairValueB, index[row[start]], row[start], start);

        return 1 + Math.min(a, b);

    }

    private void updateIndexes(int[] index, int value1, int value1Index, int value2, int value2Index) {
        index[value1] = value1Index;
        index[value2] = value2Index;
    }

    public int pair(int x) {
        if (x % 2 == 0) {
            return x + 1;
        } else {
            return x - 1;
        }
    }

    public static void main(String[] args) {

        int[] row = {15,22,30,31,2,6,43,25,53,7,13,5,45,34,27,54,21,55,28,24,58,9,4,10,46,20,33,52,41,12,44,1,29,8,14,51,23,50,18,40,57,0,37,59,11,32,3,36,38,26,42,16,56,19,17,39,49,35,48,47};
        CoupleHoldingHands dev = new CoupleHoldingHands();
        System.out.println(dev.minSwapsCouples(row));
    }
}
