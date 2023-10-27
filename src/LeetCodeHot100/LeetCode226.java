package LeetCodeHot100;

public class LeetCode226 {
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

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertTree(left);
            invertTree(right);
            return root;
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
        System.out.println(new Solution().invertTree(root));
    }

}