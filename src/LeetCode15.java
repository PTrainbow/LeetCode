
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum(nums));
    }


    /**
     * 无语了，超时
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int left = first + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[first] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[first] < 0) {
                    left++;
                } else {
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[first]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;

    }

//    private static void dfs(int[] nums, List<Integer> path, int index, int count, int sum) {
//        if (count == 3) {
//            if (sum == 0) {
//                result.add(new ArrayList<>(path));
//            }
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (sum > -nums[i]) {
//                break;
//            }
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            path.add(nums[i]);
//            dfs(nums, path, i + 1, count + 1, sum + nums[i]);
//            path.remove(path.size() - 1);
//        }
//    }


}