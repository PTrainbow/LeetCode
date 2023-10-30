package String;

public class LCR020 {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));

    }


    /**
     * > 87.80%
     */
    private static class Solution {
        public int countSubstrings(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result += getCount(s, i, i);
                result += getCount(s, i, i + 1);
            }
            return result;
        }

        private int getCount(String s, int i, int j) {
            int count = 0;
            while (i <= j && i >= 0 && j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    i--;
                    j++;
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
    }

}