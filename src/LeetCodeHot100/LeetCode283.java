package LeetCodeHot100;

import java.util.Arrays;

public class LeetCode283 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 简单 > 99.9%```
     *
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i  =0 ; i < nums.length;i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}