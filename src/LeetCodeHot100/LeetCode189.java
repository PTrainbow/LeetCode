package LeetCodeHot100;

import java.util.Arrays;

public class LeetCode189 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 抄答案，居然 > 100%
     */
    public static void rotate(int[] nums, int k) {
        int index =  k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0,index - 1);
        reverse(nums, index, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int  tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right--;
        }
    }

}