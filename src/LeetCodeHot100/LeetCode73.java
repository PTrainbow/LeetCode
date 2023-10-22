package LeetCodeHot100;

import java.util.Arrays;

public class LeetCode73 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix = new int[][]{{1,0,3}};
        setZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 明明比正确答案写的麻烦，也是常量空间，不知道为啥 > 100%
     * 思路就是用 col0 和 row0 作为标记位
     */
    public static void setZeroes(int[][] matrix) {
        boolean column_0 = false;
        boolean row_0 = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                    if (i == 0) {
                        row_0 = true;
                    }
                    if (j == 0) {
                        column_0 = true;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (row_0 ) {
            Arrays.fill(matrix[0], 0);
        }

        if (column_0 ) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}