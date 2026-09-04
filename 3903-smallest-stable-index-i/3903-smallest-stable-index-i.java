class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int max = nums[0];
            int min = nums[i];
            int difference = 0;
            for(int j=0;j<=i;j++){
                max = Math.max(nums[j],max);
            }
            for(int l=i;l<n;l++){
                min = Math.min(nums[l],min);
            }

            difference = max-min;
            if(difference <= k){
                return i;
            }else{
                continue;
            }

        }
        return -1;
    }
}