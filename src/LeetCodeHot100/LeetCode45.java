package LeetCodeHot100;

public class LeetCode45 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 2,3,1,1,4
        // 2,3,0,1,4
        int[] grid = new int[]{0};
        System.out.println(jump(grid));
    }

    /**
     * dfs 枚举超时， copy 答案
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    private static void dfs(int[] nums, int i, int step) {
        int value = nums[i - 1];
        if (i + value >= nums.length) {
            min = Math.min(step, min);
            return;
        }
        step++;
        for (int j = i + 1; j < nums.length && j <= i + value; j++) {
            dfs(nums, j, step);
        }
    }
}