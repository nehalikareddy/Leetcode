
class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0;
        long even = 1;
        long prefix = 0;
        long ans = 0;

        int MOD = 1000000007;

        for (int num : arr) {
            prefix += num;

            if (prefix % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }

            ans %= MOD;
        }

        return (int) ans;
    }
}
