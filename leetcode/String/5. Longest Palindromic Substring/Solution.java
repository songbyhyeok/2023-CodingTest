class Solution {
    int left = 0;
    int maxLen = 0;

    private void extendPalindrome(String s, int i, int j) {
        while(0 <= i && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        final int len = j - i - 1;
        if (maxLen < len) {
            left = i + 1;
            maxLen = len;
        }
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }
}