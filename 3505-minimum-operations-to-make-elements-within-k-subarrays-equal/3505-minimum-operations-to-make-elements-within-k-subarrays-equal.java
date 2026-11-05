
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int c = map.get(val);
        if (c == 1) map.remove(val);
        else map.put(val, c - 1);
    }

    void insert(int val) {
        if (leftSize == 0 || val <= left.lastKey()) {
            add(left, val);
            leftSize++;
            leftSum += val;
        } else {
            add(right, val);
            rightSize++;
            rightSum += val;
        }
        balance();
    }

    void erase(int val) {
        if (left.containsKey(val)) {
            remove(left, val);
            leftSize--;
            leftSum -= val;
        } else {
            remove(right, val);
            rightSize--;
            rightSum -= val;
        }
        balance();
    }

    void balance() {
        int target = (leftSize + rightSize + 1) / 2;

        while (leftSize > target) {
            int v = left.lastKey();
            remove(left, v);
            leftSize--;
            leftSum -= v;

            add(right, v);
            rightSize++;
            rightSum += v;
        }

        while (leftSize < target) {
            int v = right.firstKey();
            remove(right, v);
            rightSize--;
            rightSum -= v;

            add(left, v);
            leftSize++;
            leftSum += v;
        }
    }

    long getCost() {
        long median = left.lastKey();
        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++)
            insert(nums[i]);

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            erase(nums[i - x]);
            insert(nums[i]);
            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++)
            Arrays.fill(dp[j], INF);

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
