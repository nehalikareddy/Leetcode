class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Step 1: Build LPS array
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {

            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Step 2: KMP search
        i = 0;
        int j = 0;

        while (i < n) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j;
            }

            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }

        return -1;
    }
}