package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode78_Duplicated {

    private static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
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
                if (i > index) {
                    if (nums[i - 1] == nums[i]) {
                        continue;
                    }
                }
                path.add(nums[i]);
                dfs(nums, length, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{3, 1,2, 3}));
    }
}