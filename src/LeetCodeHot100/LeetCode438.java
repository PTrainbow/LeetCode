package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    /**
     * 竟然没有超时 > 14.27%
     *
     * 思路竟然一致，只不过我在 for 循环判断```
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int[] cur = new int[26];
        for (int i = 0; i <= s.length() - p.length(); i++) {
            for (int j = i; j < i + p.length(); j++) {
                cur[s.charAt(j) - 'a']++;
            }
            int k = 0;
            for (k = 0; k < p.length(); k++) {
                char c = p.charAt(k);
                if (cur[c - 'a'] != target[c - 'a']) {
                    break;
                }
            }
            if (k == p.length()) {
                result.add(i);
            }
            Arrays.fill(cur, 0);
        }
        return result;
    }
}