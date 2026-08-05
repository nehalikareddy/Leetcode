class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,0,0,"",ans);
        return ans;
    }
    public void helper(int n,int open,int close,String curr,List<String> ans){
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }

        if(open<n){
            helper(n,open+1,close,curr + "(",ans);
        }

        if(close<open){
            helper(n,open,close+1,curr+")",ans);
        }
    }
}