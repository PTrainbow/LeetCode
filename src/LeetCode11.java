
public class LeetCode11 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(nums));
    }

    /**
     * 超时
     */
    public static int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        for (int x = 0; x< height.length;x++) {
            for (int y = x + 1; y< height.length;y++) {
                result = Math.max(result, Math.min(height[x], height[y])* (y-x));
            }
        }
        return result;
    }

    /**
     * 双指针即可, > 90%
     */
    public static int maxArea2(int[] height) {
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length -1;
        while (left < right) {
            if(height[left] < height[right]) {
                result = Math.max(result, height[left]*(right -left));
                left++;
            } else {
                result = Math.max(result, height[right]*(right -left));
                right--;
            }
        }
        return result;
    }


}