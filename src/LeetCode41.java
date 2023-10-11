public class LeetCode41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }


    /**
     * >98.98%
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 容易死循环```
            // 不能只判断 nums[i] - 1 != i
            // 而应该是看 索引 0(nums[0]-1) 的位置上是不是 1(nums[0])
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}