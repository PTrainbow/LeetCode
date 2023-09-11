import javax.swing.*;
import java.util.Stack;

public class LeetCode84 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[]{1, 10, 2}));
    }


    /**
     * 超时了```O(N*N)
     */
    public static int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int minH = heights[i];
            for (int j = i; j < heights.length; j++) {
                minH = Math.min(minH, heights[j]);
                max = Math.max(max, minH * (j - i + 1));
            }
        }
        return max;
    }


    /**
     * > 5.3% 但是感觉很好理解
     *
     */
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

}