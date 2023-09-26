
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode560 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        System.out.println(solution1.subarraySum2(new int[]{1, -1, 0}, 0));
        Solution solution2 = new Solution();
        System.out.println(solution2.subarraySum2(new int[]{1}, 1));
        Solution solution3 = new Solution();
        System.out.println(solution3.subarraySum2(new int[]{1}, 0));
    }


    static class Solution {
        private int count = 0;

        /**
         * 额 超时了
         */
        public int subarraySum(int[] nums, int k) {
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                dfs(nums, i + 1, k, cur);
            }
            return count;
        }

        /**
         * 直接抄答案
         */
        public int subarraySum2(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre -k)) {
                    count+=map.get(pre-k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }

        private void dfs(int[] nums, int index, int k, int cur) {
            if (k == cur) {
                count++;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(nums, index + 1, k, cur + nums[index]);
        }
    }

}