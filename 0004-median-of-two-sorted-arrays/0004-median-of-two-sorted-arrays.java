class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = new int[nums1.length + nums2.length];

        int left = 0;
        int right = 0;
        int k = 0;

        // Merge both arrays
        while (left < nums1.length && right < nums2.length) {

            if (nums1[left] <= nums2[right]) {
                merged[k] = nums1[left];
                left++;
            } else {
                merged[k] = nums2[right];
                right++;
            }

            k++;
        }

        // Remaining elements of nums1
        while (left < nums1.length) {
            merged[k] = nums1[left];
            left++;
            k++;
        }

        // Remaining elements of nums2
        while (right < nums2.length) {
            merged[k] = nums2[right];
            right++;
            k++;
        }

        // Find median
        int n = merged.length;

        if (n % 2 == 0) {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;

            return (merged[mid1] + merged[mid2]) / 2.0;
        } else {
            int mid = n / 2;
            return merged[mid];
        }
    }
}