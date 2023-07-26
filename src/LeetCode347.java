import java.util.*;

public class LeetCode347 {
    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{1, 2}, 2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * > 93.92%
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 记录每个数字频率
        for (int num : nums) {
            if (map.containsKey(num)) {
                int target = map.get(num) + 1;
                map.put(num, target);
            } else {
                map.put(num, 1);
            }
        }
        // 数字频率为 index，数字本身为桶中内容，填充对应频率的桶
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(entry.getKey());
        }
        int[] result = new int[k];
        int tmp = 0;
        // 从后往前遍历 k 个桶内元素
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (int key: bucket[i]) {
                result[tmp] = key;
                tmp++;
            }
            if (tmp >= k) {
                break;
            }
        }
        return result;
    }
}