package LeetCodeHot100;

import java.util.LinkedList;
import java.util.Map;

public class LeetCode543 {
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
        private int result = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return result;
        }

        private int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = depth(node.left);
            int right = depth(node.right);
            result = Math.max(result, left + right);
            return Math.max(left, right)+1;
        }

    }


    /**
     * 究极简单题 > 100%
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root3.right = root5;
        root2.right = root4;
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }

}