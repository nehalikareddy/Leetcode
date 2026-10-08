class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int lcount = 0;
        int rcount = 0;
        int l = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' && lcount == 0){
                l = i;
                lcount++;
                continue;
            }
            if(s.charAt(i) == '('){
                lcount++;
            }
            if(s.charAt(i) == ')'){
                rcount++;
            }
            if(lcount == rcount){
                sb.append(s.substring(l+1,i));
                lcount = 0;
                rcount = 0;
            }
        }
        
        return sb.toString();
    }
}