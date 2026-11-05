class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == max){
                continue;
            }else{
                sum += Math.abs(nums[i]-max);
            }
        }
        return sum;
    }
}