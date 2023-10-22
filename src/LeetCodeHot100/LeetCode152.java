package LeetCodeHot100;

import java.util.LinkedList;
import java.util.List;

public class LeetCode152 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,-3}));
    }


    /**
     * 额，这种题目为啥我第一反应是 dfs 搜索```超时了```
     *
     * copy 正确答案了
     */
    public static int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]< 0 ) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }


}