class Solution {
    public int distinctSubseqII(String s) {
        long[] dp = new long[s.length() + 1];
        long[] last = new long[26];

        dp[0] = 1; // empty subsequence

        for (int i = 1; i <= s.length(); i++) {
            int ch = s.charAt(i - 1) - 'a';

            // Every old subsequence can either take or skip this character
            dp[i] = (2 * dp[i - 1]) % 1000000007;

            // Remove duplicates created by the previous occurrence
            dp[i] = (dp[i] - last[ch] + 1000000007) % 1000000007;

            // Remember the number of subsequences before this character
            last[ch] = dp[i - 1];
        }

        // Remove the empty subsequence
        return (int)((dp[s.length()] - 1 + 1000000007) % 1000000007);
    }
}