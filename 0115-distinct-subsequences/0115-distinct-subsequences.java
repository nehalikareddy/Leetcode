class Solution {

    Integer[][] dp;

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];

        return helper(s, t, 0, 0);
    }

    public int helper(String s, String t, int i, int j) {

        // We successfully formed t
        if (j == t.length()) {
            return 1;
        }

        // s finished before t
        if (i == s.length()) {
            return 0;
        }

        // Already calculated? Use stored answer
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            int use = helper(s, t, i + 1, j + 1);

            int skip = helper(s, t, i + 1, j);

            dp[i][j] = use + skip;

        } else {

            dp[i][j] = helper(s, t, i + 1, j);
        }

        return dp[i][j];
    }
}