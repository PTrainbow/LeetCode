package LeetCodeHot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode101 {
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
        public boolean isSymmetric(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<TreeNode> tmp = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode left = queue.get(i);
                    TreeNode right = queue.get(size - i -1);
                    if (left == null && right != null) {
                        return  false;
                    }
                    if (left != null && right == null) {
                        return  false;
                    }
                    if (left != null && right != null && left.val != right.val) {
                        return  false;
                    }
                    if (left != null) {
                        tmp.push(left.left);
                        tmp.push(left.right);
                    }

                }
                queue = tmp;
            }
            return true;
        }
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
        System.out.println(new Solution().isSymmetric(root));
    }

}