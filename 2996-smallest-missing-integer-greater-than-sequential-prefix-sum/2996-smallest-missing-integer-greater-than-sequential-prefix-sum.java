class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(nums[i]);
        }
        
        int i = 0;
        int j = i+1;
        //int sum = Integer.MIN_VALUE;
        int add = nums[i];
        while(j<n){
            if(nums[j] == nums[i]+1){
                add = add+nums[j]; 
                i++;
                j++;
            }else{
                break;
            }
            
            
        }
        for(int k=0;k<arr.size();k++){
            if(arr.contains(add)){
                add = add+1;
            }
        }
        return add;
    }
}