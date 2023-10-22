package LeetCodeHot100;

import java.util.*;

public class LeetCode56 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    /**
     * > 7% sort 问题，看了下最快的答案，其实没必要 sort，但是懒得改了
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty()) {
                result.add(intervals[i]);
            } else {
                int[] tmp = result.get(result.size()-1);
                if (tmp[1] < intervals[i][0]) {
                     result.add(intervals[i]);
                }else {
                    tmp[1] = Math.max(tmp[1], intervals[i][1]);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }


}