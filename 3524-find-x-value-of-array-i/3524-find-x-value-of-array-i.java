class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k]; // dp[r] = number of subarrays ending at previous index with product % k == r

        for (int num : nums) {
            int val = num % k;
            long[] nextDp = new long[k];

            // Subarray consisting of just the current element
            nextDp[val]++;

            // Extend existing subarrays ending at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    nextDp[(r * val) % k] += dp[r];
                }
            }

            // Accumulate counts into the global answer
            for (int r = 0; r < k; r++) {
                ans[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return ans;
    }
}