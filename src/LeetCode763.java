import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode763 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 2,3,1,1,4
        // 2,3,0,1,4
        int[] grid = new int[]{0};
        // eccbbbbdec
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     *
     * 感觉只是个脑筋急转弯````
     * > 55%
     *
     */
    public static List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(lastIndex[c - 'a'], end);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}