package String;

public class KMP {
    public static void main(String[] args) {
        String str1 = "B";
        String str2 = "B";
        // 获得部分匹配表
        int[] next = buildArray(str2);
        int result = kmpSearch(str1, str2, next);
        System.out.println(result);
    }

    private static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] buildArray(String str) {
        int i = 0;
        int j = -1;
        int[] next = new int[str.length()];
        next[0] = -1;
        while (i < str.length() - 1) {
            while (j != -1 && str.charAt(i) != str.charAt(j)) {
                j = next[j];
            }
            next[++i] = ++j;
        }
        return next;
    }


}
