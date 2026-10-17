import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // arr[i] holds: {digitSum, actualValue, originalIndex}
        int[][] arr = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            arr[i][0] = sum;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        
        // Sort by digitSum; if equal, sort by actualValue in nums
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        // Count swaps by placing each element back into its original index
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // While the current element didn't originally belong at index i
            while (arr[i][2] != i) {
                int targetIndex = arr[i][2];
                
                // Swap arr[i] with arr[targetIndex]
                int[] temp = arr[i];
                arr[i] = arr[targetIndex];
                arr[targetIndex] = temp;
                
                swaps++;
            }
        }
        
        return swaps;
    }
}