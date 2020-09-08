package dev.geeksforgeeks.mustdocodingquestions.recursion;

import java.util.Arrays;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.toString(image[0]));
        System.out.println(Arrays.toString(image[1]));
        System.out.println(Arrays.toString(image[2]));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int colorOfCurrentPixel = image[sr][sc];
        // If the new color is same as old color, there is no need to run the fill function.
        return colorOfCurrentPixel != newColor ? fill(colorOfCurrentPixel, image, sr, sc, newColor) : image;
    }

    public int[][] fill(int colorOfCurrentPixel, int[][] image, int row, int column, int newColour) {
        image[row][column] = newColour;
        if (row >= 1 && image[row - 1][column] == colorOfCurrentPixel)
            fill(colorOfCurrentPixel, image, row - 1, column, newColour);
        if (row + 1 < image.length && image[row + 1][column] == colorOfCurrentPixel)
            fill(colorOfCurrentPixel, image, row + 1, column, newColour);
        if (column >= 1 && image[row][column - 1] == colorOfCurrentPixel)
            fill(colorOfCurrentPixel, image, row, column - 1, newColour);
        if (column + 1 < image[0].length && image[row][column + 1] == colorOfCurrentPixel)
            fill(colorOfCurrentPixel, image, row, column + 1, newColour);
        return image;
    }
}
