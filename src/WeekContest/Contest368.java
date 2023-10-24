package WeekContest;

import jdk.tools.jmod.Main;

import java.util.HashMap;
import java.util.Map;

public class Contest368 {
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
    }

    public static int minimumSum(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];
        int l_min = Integer.MAX_VALUE;
        int r_min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < l_min) {
                l_min = nums[i - 1];
            }
            leftMin[i] = l_min;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] < r_min) {
                r_min = nums[i + 1];
            }
            rightMin[i] = r_min;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftMin[i] && nums[i] > rightMin[i]) {
                result = Math.min(result, nums[i] + leftMin[i] + rightMin[i]);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
