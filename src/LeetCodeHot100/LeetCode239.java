package LeetCodeHot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }


    /**
     * 击败 5.6%```
     *
     * 用了个 stack，但是总会修改头和尾，并不适合，转 LinkedList > 69.9%
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        while (left < nums.length && right < nums.length) {
            while (right - left < k) {
                while (!stack.isEmpty() && stack.getLast() < nums[right]) {
                    stack.removeLast();
                }
                stack.add(nums[right]);
                right++;
            }

            result[left] = stack.getFirst();
            if (nums[left] == stack.getFirst()) {
                stack.removeFirst();
            }
            left++;
        }
        return result;
    }
}