class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBoundary(nums, target, true);
        int last = findBoundary(nums, target, false);

        return new int[]{first, last};
    }

    public int findBoundary(int[] nums, int target, boolean findFirst) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;

                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}