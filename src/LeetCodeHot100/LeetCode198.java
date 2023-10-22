package LeetCodeHot100;

public class LeetCode198 {
    public static void main(String[] args) {
        int[] grid = new int[]{1,2,3,1};
        int[] grid2 = new int[]{2,7,9,3,1};
        System.out.println(rob(grid2));
    }

    /**
     * >100%
     * 看了标准答案，通过 dp[i-2] 递推，应该比我这个快啊，可能是网络延迟问题吧```
     */
    public static int rob(int[] nums) {
        int dp[][] = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] + nums[i]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

}