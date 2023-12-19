package LeetCodeHot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {

    private static class Solution {

        /**
         * > 18.7%
         * 牛马了```
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i <= nums.length; i++) {
                dfs(nums, i, 0, result, new ArrayList<>());
            }
            return result;
        }

        private void dfs(int[] nums, int length, int index, List<List<Integer>> result, List<Integer> path) {
            if (length == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            length--;
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(nums, length, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}