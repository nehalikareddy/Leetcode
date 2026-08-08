class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0){
            return ans;
        }

        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");


        backtrack(digits,0,new StringBuilder(),ans,map);

        return ans;
    }

    public void backtrack(String digits,int index,StringBuilder curr,List<String> ans, HashMap<Character,String> hm){
        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }
        String letters = hm.get(digits.charAt(index));
        for(int i=0;i<letters.length();i++){
            //choose
            curr.append(letters.charAt(i));
            backtrack(digits,index+1,curr,ans,hm);
            curr.deleteCharAt(curr.length() - 1);

        }


    }
}