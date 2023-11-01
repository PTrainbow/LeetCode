package LeetCodeHot100;

public class LeetCode236 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1) ;
        TreeNode node2 = new TreeNode(2) ;
        TreeNode node3 = new TreeNode(3) ;
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution().lowestCommonAncestor(node1, node2, node3));
    }


    private static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || (root == p || root == q)) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right!= null) {
                return root;
            }
            return left != null? left: right;
        }
    }

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
}