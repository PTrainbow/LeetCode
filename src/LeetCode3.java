import java.util.HashSet;

public class LeetCode3 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     *
     * >53.87%
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                result = Math.max(result, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }


}