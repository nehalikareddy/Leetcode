
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        int j = n - 1;

        // Each pair stores {value, count}
        Deque<int[]> dq = new ArrayDeque<>();

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller groups into the current number
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                // Increase all elements in this group
                cost += (long) (num - nextNum) * nextCount;
            }

            // Add the current group
            dq.offerLast(new int[]{num, count});

            // Shrink window while operations exceed k
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                // Remove the contribution of nums[j]
                cost -= (long) (rightmostNum - nums[j]);

                j--;

                // Keep the remaining elements in the group
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // All subarrays ending between i and j are valid
            ans += j - i + 1;
        }

        return ans;
    }
}
