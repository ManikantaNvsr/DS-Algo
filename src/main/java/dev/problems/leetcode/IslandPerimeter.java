package dev.problems.leetcode;

// https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int horizontalLength = grid[0].length;
        int verticalLength = grid.length;
        int perimeter = 0;

        // naive approach
        for (int i = 0; i < verticalLength; i++) {
            for (int j = 0; j < horizontalLength; j++) {


                // we will only count borders of a land only
                if (grid[i][j] == 1) {

                    // left adjacent border
                    if (j == 0 || grid[i][j - 1] == 0)
                        perimeter++;

                    // right adjacent border
                    if (j + 1 == horizontalLength || grid[i][j + 1] == 0)
                        perimeter++;


                    // top adjacent border
                    if (i == 0 || grid[i - 1][j] == 0)
                        perimeter++;

                    // bottom adjacent border
                    if (i + 1 == verticalLength || grid[i + 1][j] == 0)
                        perimeter++;


                }


            }
        }

        return perimeter;

    }
}
