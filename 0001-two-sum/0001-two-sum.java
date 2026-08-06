class Solution {
    public int[] twoSum(int[] nums, int target) {
        // //brute force approach 
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[2];


        //hashmap method 
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comple = target - nums[i];
            if(hm.containsKey(comple)){
                return new int[]{hm.get(comple),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};

    }
}