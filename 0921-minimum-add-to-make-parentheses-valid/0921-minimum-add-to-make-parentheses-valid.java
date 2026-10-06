class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && stack.isEmpty()){
                count++;
            }
            else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }
        }
        int size = stack.size();
        int result = size + count;
        return result;
    }
}