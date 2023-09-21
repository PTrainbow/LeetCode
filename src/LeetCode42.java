public class LeetCode42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * > 77.87%
     */
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = 0; i< height.length; i++) {
            if (i == 0 ) {
                left[i] = 0;
                right[height.length -1 -i] = 0;
                continue;
            }
            leftMax = Math.max(leftMax, height[i-1]);
            left[i] = leftMax;
            rightMax = Math.max(rightMax, height[height.length -i]);
            right[height.length -1 -i] = rightMax;
        }
        int result = 0;
        for (int i = 0; i < height.length;i++) {
            if (i == 0 || i == height.length -1) {
                continue;
            }
            result+= Math.max(Math.min(left[i], right[i]), height[i]) - height[i];
        }
        return result;
    }

}