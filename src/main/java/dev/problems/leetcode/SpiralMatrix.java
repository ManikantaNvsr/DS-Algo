package dev.problems.leetcode;

import java.util.LinkedList;
import java.util.List;

// LeetCode: 54
// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(spiralMatrix.spiralOrder(arr));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        // consider leftIndex and rightIndex are cartesian coordinates of given array
        int leftIndex = 0;
        int rightIndex = 0;
        int numberOfElements = matrix[0].length * matrix.length;
        int counterForPrintedElements = 0;
        int topBorder;
        int downBorder = matrix.length;
        int leftBorder = -1;
        int rightBorder = matrix[0].length;
        List<Integer> list = new LinkedList<>();
        while (counterForPrintedElements < numberOfElements) {
            // slide right
            while (rightIndex < rightBorder) {
                list.add(matrix[leftIndex][rightIndex++]);
                counterForPrintedElements++;
                if (counterForPrintedElements == numberOfElements) {
                    return list;
                }
            }
            topBorder = leftIndex;
            rightIndex--;
            leftIndex++;
            // slide down
            while (leftIndex < downBorder) {
                list.add(matrix[leftIndex++][rightIndex]);
                counterForPrintedElements++;
                if (counterForPrintedElements == numberOfElements) {
                    return list;
                }
            }
            rightBorder = rightIndex;
            leftIndex--;
            rightIndex--;
            // slide left
            while (rightIndex > leftBorder) {
                list.add(matrix[leftIndex][rightIndex--]);
                counterForPrintedElements++;
                if (counterForPrintedElements == numberOfElements) {
                    return list;
                }
            }
            downBorder = leftIndex;
            rightIndex++;
            leftIndex--;
            // slide up
            while (leftIndex > topBorder) {
                list.add(matrix[leftIndex--][rightIndex]);
                counterForPrintedElements++;
                if (counterForPrintedElements == numberOfElements) {
                    return list;
                }
            }
            leftBorder = rightIndex;
            leftIndex++;
            rightIndex++;
        }
        return list;
    }
}
