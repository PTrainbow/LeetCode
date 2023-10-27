package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode104 {
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }


    /**
     * 究极简单题 > 100%
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        System.out.println(new Solution().maxDepth(root));
    }

}