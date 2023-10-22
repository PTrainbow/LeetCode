package LeetCodeHot100;

public class LeetCode74 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(grid, 3));
    }


    /**
     * 击败 100%```
     * 离谱
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        return dfs(0, matrix[0].length-1, matrix, target);
    }

    private static boolean dfs(int x, int y, int[][] matrix, int target) {
        if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1) {
            return false;
        }
        if (matrix[x][y] == target) {
            return true;
        } else if (matrix[x][y] < target) {
            return dfs(x+1, y, matrix, target);
        } else {
            return dfs(x , y-1, matrix, target);
        }
    }
}