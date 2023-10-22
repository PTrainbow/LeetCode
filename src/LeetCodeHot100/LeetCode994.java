package LeetCodeHot100;

import java.util.*;

public class LeetCode994 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    /**
     * 先收集所有起点，然后去重的 BFS
     * 直接就是一个击败 100%
     */
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int depth = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    fresh++;
                } else if (grid[x][y] == 2) {
                    queue.add(new int[]{x, y});
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point[0] + 1 < grid.length && grid[point[0] + 1][point[1]] == 1) {
                    grid[point[0] + 1][point[1]] = 2;
                    queue.add(new int[]{point[0] + 1, point[1]});
                    fresh--;
                }

                if (point[0] - 1 >= 0 && grid[point[0] - 1][point[1]] == 1) {
                    grid[point[0] - 1][point[1]] = 2;
                    queue.add(new int[]{point[0] - 1, point[1]});
                    fresh--;
                }

                if (point[1] + 1 < grid[0].length && grid[point[0]][point[1] + 1] == 1) {
                    grid[point[0]][point[1] + 1] = 2;
                    queue.add(new int[]{point[0], point[1] + 1});
                    fresh--;
                }

                if (point[1] - 1 >= 0 && grid[point[0]][point[1] - 1] == 1) {
                    grid[point[0]][point[1] - 1] = 2;
                    queue.add(new int[]{point[0], point[1] - 1});
                    fresh--;
                }
            }
        }
        return fresh != 0 ? -1 : depth;
    }

}