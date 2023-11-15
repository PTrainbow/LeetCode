package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, targetSum, path, list);
            return list;
        }

        private void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> list) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            targetSum -= root.val;
            if (0 == targetSum && root.left == null && root.right == null) {
                list.add(new ArrayList<>(path));
                if (!path.isEmpty()) {
                    path.remove(path.size()-1);
                }
                return;
            }
            dfs(root.left, targetSum, path, list);
            dfs(root.right, targetSum, path, list);
            if (!path.isEmpty()) {
                path.remove(path.size()-1);
            }
        }

    }

    /**
     *
     * 做了上一题看答案，做了这一题十分简单~~
     * > 99%
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(-2);
        TreeNode root2 = new TreeNode(-3);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(-2);
        TreeNode root6 = new TreeNode(-1);


        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        root3.left = root6;

        root2.left = root5;


        System.out.println(new Solution().pathSum(root, 2));
    }
}