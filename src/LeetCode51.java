import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {

    public static void main(String[] args) {
        System.out.println(solveNQueensz(4));
    }

    private static List<List<String>> result = new ArrayList<>();

    /**
     * 斜线原来是这么算的```
     * 虽然这种题目已经经典烂掉了，但是我真的没去做过```
     * > 53%
     * 因为没使用 set，使用 int[], 肯定比使用 set 的要快一点
     */
    private static List<List<String>> solveNQueensz(int n) {
        boolean[] visitedCol = new boolean[n];
        boolean[] visitedDiagonal1 = new boolean[2 * n];
        boolean[] visitedDiagonal2 = new boolean[2 * n];

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ".";
            }
        }
        dfs(0, n, visitedCol, visitedDiagonal1, visitedDiagonal2, matrix);
        return result;
    }

    private static void dfs(int row, int n, boolean[] visitedCol, boolean[] visitedDiagonal1, boolean[] visitedDiagonal2, String[][] matrix) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder sb  = new StringBuilder();
                for (int j = 0; j < matrix[0].length; j++) {
                    sb.append(matrix[i][j]);
                }
                tmp.add(sb.toString());
            }
            result.add(tmp);
            return;
        }
        for (int col = 0; col < matrix[0].length; col++) {
            if (visitedCol[col]) {
                continue;
            }
            if (visitedDiagonal1[row - col + n]) {
                continue;
            }
            if (visitedDiagonal2[row + col]) {
                continue;
            }
            visitedCol[col]=true;
            visitedDiagonal1[row - col + n]=true;
            visitedDiagonal2[row + col]=true;
            matrix[row][col] = "Q";
            dfs(row + 1, n, visitedCol, visitedDiagonal1, visitedDiagonal2, matrix);
            matrix[row][col] = ".";
            visitedCol[col]=false;
            visitedDiagonal1[row - col + n]=false;
            visitedDiagonal2[row + col]=false;
        }
    }

}