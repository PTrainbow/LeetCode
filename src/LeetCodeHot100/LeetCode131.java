package LeetCodeHot100;

import java.util.*;

public class LeetCode131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }


    /**
     *  > 23%
     *  优化子串回文判断，可以通过存储中间的回文状态
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> path = new LinkedList<>();
        dfs2(s, 0, result, path);
        return result;
    }

    private static void dfs2(String s, int start, List<List<String>> result, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            if (check2(s, start, i)) {
                path.add(s.substring(start, i + 1));
                dfs2(s, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean check2(String s, int left, int right) {
        while (left<= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right --;
        }
        return true;
    }
}