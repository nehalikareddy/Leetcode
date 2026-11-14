class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int k = l; k <= r; k++) {

            int sum = 0;

            // First window
            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                ans = Math.min(ans, sum);
            }

            // Slide window
            for (int i = k; i < n; i++) {

                sum += nums.get(i);
                sum -= nums.get(i - k);

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}