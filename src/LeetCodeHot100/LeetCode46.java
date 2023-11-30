package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    private static class Solution {
        /**
         * 用的 dfs，有个深度慢慢增加的过程，巨慢
         * > 9%
         *
         */
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(nums, path, result);
                path.remove(path.size()-1);
            }
            return result;
        }

        private void dfs(int[] nums, List<Integer> path, List<List<Integer>> result) {
            if (nums.length == path.size()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                dfs(nums, path,result);
                path.remove(path.size()-1);
            }
        }
    }

}