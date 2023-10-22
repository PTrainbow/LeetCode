package LeetCodeHot100;

public class LeetCode124 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(maxPathSum(node1));
    }

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        traversal(root);
        return maxSum;
    }

    /**
     *
     * 只击败了 1%，哈哈哈哈哈
     */
    private static int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(traversal(root.left), 0);
        int maxRight = Math.max(traversal(root.right), 0);
        int val = root.val;
        maxSum = Math.max(val + maxLeft + maxRight, maxSum);
        return val + Math.max(maxLeft, maxRight);
    }

    static class TreeNode {
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
}