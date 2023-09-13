public class LeetCode72 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }


    /**
     * 做过 动态规划
     * > 6.8%```
     */
    private static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}