package LeetCodeHot100;

import java.util.Arrays;

public class LeetCode279 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * 超时，人傻了，在遍历 j，还判断是否是完全平方数，需要遍历 j*j
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i-j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

}