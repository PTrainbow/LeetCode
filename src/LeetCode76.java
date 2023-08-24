public class LeetCode76 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


    /**
     * 没有任何多余操作直接就看了答案
     * 滑动窗口呗
     * 用 hashmap 感觉会比数组慢
     *
     * 果然 > 98.08%
     */
    public static String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] need = new int[128];
        int totalCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (need[t.charAt(i)] == 0) {
                totalCount++;
            }
            need[t.charAt(i)]++;
        }
        int right = 0;
        int left = 0;
        int count = 0;
        int minWidth = Integer.MAX_VALUE;
        int minLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (need[c] == window[c]) {
                count++;
            }
            right++;
            while (count == totalCount) {
                if (right - left < minWidth) {
                    minWidth = right - left;
                    minLeft = left;
                }
                char willDelete = s.charAt(left);
                left++;
                window[willDelete]--;
                if (need[willDelete] != 0) {
                    if (window[willDelete] < need[willDelete]) {
                        count--;
                    }
                }
            }
        }
        return minWidth == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minWidth);
    }


}