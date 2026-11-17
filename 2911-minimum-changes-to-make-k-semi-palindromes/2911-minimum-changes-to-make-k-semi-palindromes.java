import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();

        // Step 1: Precompute cost of every substring
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;
                int best = Integer.MAX_VALUE;

                // Try every proper divisor
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) continue;

                    int changes = 0;

                    // Check each group
                    for (int offset = 0; offset < d; offset++) {

                        int count = (len - 1 - offset) / d + 1;

                        // Compare opposite characters
                        for (int t = 0; t < count / 2; t++) {

                            int left = l + offset + t * d;

                            int right = l + offset +
                                        (count - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[l][r] = best;
            }
        }

        // Step 2: DP
        int INF = 1000000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // p = number of substrings
        for (int p = 1; p <= k; p++) {

            // end = number of characters used
            for (int end = 2 * p; end <= n; end++) {

                // start = beginning of last substring
                for (int start = 2 * (p - 1);
                     start <= end - 2; start++) {

                    dp[p][end] = Math.min(
                        dp[p][end],
                        dp[p - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}