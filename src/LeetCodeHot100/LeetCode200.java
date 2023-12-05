package LeetCodeHot100;

public class LeetCode200 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] matrix2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] matrix3 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };

        System.out.println(new Solution().numIslands(matrix));
        System.out.println(new Solution().numIslands(matrix2));
        System.out.println(new Solution().numIslands(matrix3));

    }

    /**
     * 以为会很慢，结果击败了63%```
     */
    private static class Solution {
        int count = 0;

        public int numIslands(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (visited[x][y] || grid[x][y] == '0') {
                        continue;
                    }
                    dfs(grid, visited, x, y);
                    count++;
                }
            }
            return count;
        }

        private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') {
                return;
            }
            visited[x][y] = true;
            dfs(grid, visited, x + 1, y);
            dfs(grid, visited, x, y + 1);
            dfs(grid, visited, x - 1, y);
            dfs(grid, visited, x, y - 1);

        }
    }


}