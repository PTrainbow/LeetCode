package LeetCodeHot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    private static int min = Integer.MAX_VALUE;

    public static class TreeNode {
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

    static class Solution {

        /**
         * 额 17.8%，递归 dfs 不需要额外容器更快
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode parent = queue.poll();
                    if (parent == null) {
                        continue;
                    }
                    level.add(parent.val);
                    if (parent.left != null) {
                        queue.add(parent.left);
                    }
                    if (parent.right != null) {
                        queue.add(parent.right);
                    }
                }
                if (!level.isEmpty()) {
                    result.add(level);
                }
            }
            return result;
        }


        /**
         * 究极简单题 > 100%
         */
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            TreeNode root2 = new TreeNode(2);
            TreeNode root3 = new TreeNode(2);
            TreeNode root4 = new TreeNode(3);
            TreeNode root5 = new TreeNode(3);
            root.left = root2;
            root.right = root3;
            root3.right = root5;
            root2.right = root4;
            System.out.println(new Solution().levelOrder(root));
        }

    }
}