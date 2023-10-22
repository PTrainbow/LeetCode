package LeetCodeHot100;

public class LeetCode4 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }

    /**
     * 双指针
     * >100%  有点离谱的
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        int pre = 0;
        int length = nums1.length + nums2.length;
        for (int i = 0; i <= length / 2; i++) {
            pre = cur;
            if (p1 >= nums1.length) {
                cur = nums2[p2++];
                continue;
            }
            if (p2 >= nums2.length) {
                cur = nums1[p1++];
                continue;
            }
            if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }

        }
        if (length % 2 == 0) {
            return (cur + pre) / 2.0f;
        } else {
            return cur;
        }
    }

}