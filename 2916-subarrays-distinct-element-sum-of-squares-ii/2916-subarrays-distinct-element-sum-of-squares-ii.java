
class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        SegmentTree tree = new SegmentTree(n);
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = last[nums[r]];

            tree.update(prev + 1, r);

            ans = (ans + tree.sqSum[1]) % MOD;

            last[nums[r]] = r;
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum, sqSum, lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long add) {
            long len = r - l + 1L;

            sqSum[node] = (
                sqSum[node] + 2L * add * sum[node]
                + len * add % MOD * add
            ) % MOD;

            sum[node] = (sum[node] + len * add) % MOD;
            lazy[node] += add;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = l + (r - l) / 2;

            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        void update(int ql, int qr) {
            update(1, 0, n - 1, ql, qr);
        }

        void update(int node, int l, int r, int ql, int qr) {
            if (r < ql || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, 1);
                return;
            }

            push(node, l, r);

            int mid = l + (r - l) / 2;

            update(node * 2, l, mid, ql, qr);
            update(node * 2 + 1, mid + 1, r, ql, qr);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sqSum[node] = (sqSum[node * 2] + sqSum[node * 2 + 1]) % MOD;
        }
    }
}
