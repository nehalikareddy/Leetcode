class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int i,List<Integer> al,List<List<Integer>> ans){
        if(i == nums.length){
            if(!ans.contains(al)){
                ans.add(new ArrayList<>(al));
                
            }
            return;
        }
        al.add(nums[i]);
        helper(nums,i+1,al,ans);
        al.remove(al.size() -  1);
        helper(nums,i+1,al,ans);
    }
}