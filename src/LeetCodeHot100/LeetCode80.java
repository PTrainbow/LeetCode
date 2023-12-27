package LeetCodeHot100;

public class LeetCode80 {

    static class Solution {

        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n <= 2) {
                return n;
            }
            int slow = 2, fast = 2;
            while (fast < n) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    ++slow;
                }
                ++fast;
            }
            return slow;
        }
    }


    /**
     * 直接抄答案
     */
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
    }

}