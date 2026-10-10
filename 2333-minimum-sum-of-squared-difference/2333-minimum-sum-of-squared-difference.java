import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
        }

        if (sum <= k) {
            return 0;
        }

        Arrays.sort(diff);

        int level = diff[n - 1];
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            long cost = (long) (level - diff[i]) * count;

            if (cost <= k) {
                k -= cost;
                level = diff[i];
                count++;
            } else {
                long reduction = k / count;
                long remainder = k % count;

                level -= reduction;

                long ans = 0;

                for (int j = 0; j <= i; j++) {
                    ans += (long) diff[j] * diff[j];
                }

                for (int j = i + 1; j < n; j++) {
                    long d = level;
                    if (j >= n - remainder) {
                        d--;
                    }
                    ans += d * d;
                }

                return ans;
            }
        }

        long reduction = k / n;
        long remainder = k % n;
        level -= reduction;

        long ans = 0;

        for (int j = 0; j < n; j++) {
            long d = level;
            if (j >= n - remainder) {
                d--;
            }
            ans += d * d;
        }

        return ans;
    }
}