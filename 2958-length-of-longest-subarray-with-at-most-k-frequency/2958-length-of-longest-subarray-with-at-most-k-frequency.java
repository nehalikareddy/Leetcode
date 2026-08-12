class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right=0;right<nums.length;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0) + 1);
            while (hm.get(nums[right]) > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }
}