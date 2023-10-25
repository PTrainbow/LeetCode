package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root,result);
            return result;
        }

        private void inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right,result);
        }
    }

    /**
     * 究极简单题 > 100%
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right = root2;
        root2.left = root3;
        System.out.println(new Solution().inorderTraversal(root));
    }

}