package LeetCodeHot100;

public class LeetCode416 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 2,3,1,1,4
        // 2,3,0,1,4
        int[] grid = new int[]{1,2,5};
//        int[] grid = new int[]{1,2,5};
        System.out.println(canPartition(grid));
    }

    /**
     * 击败 29%，先这样吧
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length+1][sum / 2+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] =true;
                } else {
                    if (j < nums[i-1]) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j-nums[i-1]];
                    }
                }
            }
        }
        boolean result = false;
        for (int i = 0;i <= nums.length;i++) {
            result = result || dp[i][sum/2];
        }
        return result;
    }

}