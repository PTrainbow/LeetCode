package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     *  > 44%，修改完后  > 100%
     *
     *  其实也不需要 dp 数组
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int max =  dp[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i-1] > 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
//            max = Math.max(max, dp[i]);
//        }
        int cur =  nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                pre = pre + nums[i];
            } else {
                pre = nums[i];
            }
            cur = Math.max(cur, pre);
        }
        return cur;
    }


}