package LeetCodeHot100;

import java.util.*;

public class LeetCode128 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[] {100,4,200,2,1,3}));
    }

    /**
     * 超时，加过滤
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length;i++) {
            int count = 1;
            while (set.contains(nums[i]-count)) {
                count++;
            }
            max=Math.max(max, count);
        }
        return max;
    }

    /**
     * 增加连续数跳过的逻辑
     * > 84.66%
     */
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length;i++) {
            if (set.contains(nums[i]+1)) {
                continue;
            }
            int count = 1;
            while (set.contains(nums[i]-count)) {
                count++;
            }
            max=Math.max(max, count);
        }
        return max;
    }
}