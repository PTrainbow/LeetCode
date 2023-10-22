package LeetCodeHot100;

import java.util.Arrays;

public class LeetCode322 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[] grid = new int[]{2};
        System.out.println(coinChange(grid, 3));
    }

    /**
     * > 85%
     *
     * 使用 Integer.MAX_VALUE 占位需要注意 + 1 溢出
     */
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}