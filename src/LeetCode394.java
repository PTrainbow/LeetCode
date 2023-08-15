import java.util.Stack;

public class LeetCode394 {
    private static int index = 0;

    public static void main(String[] args) {
        // 3[a2[c]] accaccacc
        // 2[abc]3[cd]ef abcabccdcdcdef
        System.out.println(decodeString2("100[leetcode]"));
    }


    private static String decodeString2(String s) {
        return dfs(s, 0);
    }

    /**
     * dfs 击败 100%
     */
    private static String dfs(String s, int nextTimes) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c >= 48 && c <= 57) {
                times = times * 10 + (c - 48);
            } else if (c == '[') {
                sb.append(dfs(s, times));
                times = 0;
            } else if (c == ']') {
                StringBuilder v = new StringBuilder();
                if (nextTimes == 0) {
                    nextTimes = 1;
                }
                for (int j = 0; j < nextTimes; j++) {
                    v.append(sb);
                }
                return v.toString();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String decodeString(String s) {
        Stack<Integer> timeStack = new Stack<>();
        Stack<StringBuilder> valueStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int times = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                times = times * 10 + c - 48;
            } else if (c == '[') {
                timeStack.push(times);
                valueStack.push(cur);
                times = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                if (!valueStack.isEmpty() && !timeStack.isEmpty()) {
                    int t = timeStack.pop();
                    StringBuilder curSb = valueStack.pop();
                    for (int j = 0; j < t; j++) {
                        curSb.append(cur);
                    }
                    cur = curSb;
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }


}