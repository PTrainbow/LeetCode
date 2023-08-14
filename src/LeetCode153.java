import java.util.LinkedList;
import java.util.Queue;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] grid = new int[]{11,13,15,17};
        System.out.println(findMin(grid));
    }

    /**
     * 击败 100%
     * 通过了以后发现题目要求时间复杂度 O(logN)，可能测试 case 普遍最小值在前面？玄学通过了
     *
     * 应该用二分
     */
    private static int findMin(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

}