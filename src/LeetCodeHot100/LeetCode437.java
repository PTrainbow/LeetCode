package LeetCodeHot100;

public class LeetCode437 {

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

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int result = rootSum(root, targetSum);
            result += pathSum(root.left, targetSum);
            result += pathSum(root.right, targetSum);
            return result;
        }

        public int rootSum(TreeNode root, long targetSum) {
            int result = 0;
            if (root == null) {
                return 0;
            }
            targetSum -= root.val;
            if (targetSum == 0) {
                result++;
            }
            result += rootSum(root.right, targetSum);
            result += rootSum(root.left, targetSum);
            return result;
        }

    }


    /**
     * 还说啥呢？抄答案都抄错了~~
     *
     * 强行改了个 long 参数，有溢出问题```
     *
     * > 16.21%
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        TreeNode root1 = new TreeNode(1000000000);
        TreeNode root2 = new TreeNode(294967296);
        TreeNode root3 = new TreeNode(1000000000);
        TreeNode root4 = new TreeNode(1000000000);
        TreeNode root5 = new TreeNode(1000000000);

        root.left = root1;
        root1.left = root2;

        root2.left = root3;
        root3.left = root4;
        root4.left = root5;
        System.out.println(new Solution().pathSum(root, 0));
    }
}