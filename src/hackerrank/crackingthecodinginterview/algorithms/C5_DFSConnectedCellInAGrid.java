package hackerrank.crackingthecodinginterview.algorithms;

import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C5_DFSConnectedCellInAGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

    //https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/forum
    private static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, countCells(matrix, i, j));
            }
        }
        return max;
    }

    private static int countCells(int[][] matrix, int i, int j) {
        if (isNotFilled(matrix, i, j)) {
            return 0;
        }

        int count = matrix[i][j]--;
        count += countCells(matrix, i + 1, j);
        count += countCells(matrix, i - 1, j);
        count += countCells(matrix, i, j + 1);
        count += countCells(matrix, i, j - 1);
        count += countCells(matrix, i + 1, j + 1);
        count += countCells(matrix, i - 1, j - 1);
        count += countCells(matrix, i - 1, j + 1);
        count += countCells(matrix, i + 1, j - 1);
        return count;
    }

    private static boolean isNotFilled(int[][] matrix, int i, int j) {
        return i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] == 0;
    }
}
